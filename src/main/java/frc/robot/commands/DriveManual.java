/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * This command will be used to drive the robot via joystick
 */
public class DriveManual extends Command {
  public DriveManual() {
    // Use requires() here to declare subsystem dependencies
    // requires(Robot.m_subsystem);

    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.driveSubsystem.leftMaster.setNeutralMode(NeutralMode.Brake);
    // Robot.driveSubsystem.rightMaster.setNeutralMode(NeutralMode.Brake);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double move = -Robot.OI.getJoystickSar().getY(Hand.kLeft);
    double turn = Robot.OI.getJoystickSar().getX(Hand.kLeft);

    Robot.driveSubsystem.manualDrive(move, turn);
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
