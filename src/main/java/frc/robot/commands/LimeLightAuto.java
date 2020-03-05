/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotConfig;


/**
 * Lines up robot with vision target
 */
public class LimeLightAuto extends Command {



  NetworkTableInstance inst;
  NetworkTable table;
  double centerX;

  Boolean isFinished = false;

  public LimeLightAuto() {
    requires(Robot.driveSubsystem);
  }

  protected void initialize() {
  }

  protected void execute() {

    System.out.println(centerX);
    centerX = SmartDashboard.getNumber("LimelightX", 0);


    Double TurnSpeed = RobotConfig.limelightAutoTurnSpeed;
    Double Offset = RobotConfig.limelightAutoTurnSpeed;
    isFinished = false;


    // figure out direction to spin
    if (centerX > Offset) {
      TurnSpeed = TurnSpeed * -1;
    } else {
      TurnSpeed = 0.0;
      isFinished = true;
    }

    Robot.driveSubsystem.manualDrive(0.0, -TurnSpeed);


  }

  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {
  }

  protected void interrupted() {
  }

}