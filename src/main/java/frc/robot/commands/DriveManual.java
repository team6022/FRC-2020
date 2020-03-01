/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * This command will be used to drive the robot via Xbox controller. Also allows
 * differential drive.
 */
public class DriveManual extends Command {

  Double _move = 0.0;
  Double _turn = 0.0;
  Boolean _driveBackwards = false;
  Boolean autoDrive = false;

  public DriveManual() {
    requires(Robot.driveSubsystem);
  }

  public DriveManual(Double Move, Double Turn) {
    requires(Robot.driveSubsystem);

    _move = Move;
    _turn = Turn;
    autoDrive = true;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSubsystem.leftMaster.setNeutralMode(NeutralMode.Brake);
    Robot.driveSubsystem.rightMaster.setNeutralMode(NeutralMode.Brake);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {




    // if no values were passed in, use controller input
    if (!autoDrive) {

      // pull values from controller
      _move = -Robot.OI.getJoystickSar().getY(Hand.kLeft);
      _turn = Robot.OI.getJoystickSar().getX(Hand.kRight);

      // set controller deadzone
      _move = (_move > 0.1 || _move < -0.1) ? _move : 0;
      _turn = (_turn > 0.1 || _turn < -0.1) ? _turn : 0;
    }

    // reverse drive direction
    _driveBackwards = SmartDashboard.getBoolean("DriveBackwards", false);

    if (_driveBackwards) {
      _move = _move * -1;
    }

    Robot.driveSubsystem.manualDrive(_move, _turn);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
