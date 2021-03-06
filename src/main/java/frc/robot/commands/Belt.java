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
import frc.robot.RobotConfig;

/**
 * This runs the conveyor belt. Power Cells will be run up to the fly wheels.
 */
public class Belt extends Command {

  Double _speed = 0.0;
  Boolean autoShoot = false;

  public Belt() {
    requires(Robot.BeltMotor);
  }

  public Belt(Double Speed) {
    requires(Robot.BeltMotor);
    _speed = Speed;
    autoShoot = true;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // System.out.println(autoShoot);

    // check to see if trigger is held
    if (!autoShoot) {
      if (Robot.OI.getJoystickSar().getTriggerAxis(Hand.kLeft) > RobotConfig.beltTriggerMaxSpeedPull) {
        _speed = RobotConfig.beltTriggerMaxSpeed;
      } else if (Robot.OI.getJoystickSar().getTriggerAxis(Hand.kLeft) > RobotConfig.beltTriggerMidSpeedPull) {
        _speed = RobotConfig.beltTriggerMidSpeed;
      } else {
        _speed = 0.0;
      }
    }

    Robot.BeltMotor.SetSpeed(_speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // return false;
    return _speed == 0.0;
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
