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


/**
 * Lines up robot with vision target
 */
public class LimeLightAuto extends Command {

  // this is considered the center on the screen
  // these needs to be a double array because there is the possibility of having
  // multiple targets on the screen
  double center = 75.0;

  // how far off from the center can the target be in pixels before the robot
  // should stop turning
  double precision = 10.0;

  // how fast you should turn the robot when it is far from the center
  double turnSpeedFar = 0.50;

  // how fast you should turn the robot when it is close to the center
  double turnSpeedClose = 0.25;

  // how many pixels is considered close to the center
  double closeDistance = 38.0;

  NetworkTableInstance inst;
  NetworkTable table;
  double centerX;

  public LimeLightAuto() {
    requires(Robot.driveSubsystem);
  }

  protected void initialize() {
    // pull data from GRIP report
    // inst = NetworkTableInstance.getDefault();
    // table = inst.getTable("SmartDashboard");

    // // get the centerX value, if it can't be found, default to 75 (center)
    // centerX = table.getEntry("LimelightX").getDoubleArray(center);
    // System.out.println(centerX);
    centerX = SmartDashboard.getNumber("LimelightX", 0);
    System.out.println(centerX);
  }

  protected void execute() {

    // had to add this try for now because centerx is an array an might not contain
    // any values
    // if (centerX >= 1) {

      // decide if we need to turn left or right.
      // decrese precision to increase accuracy
      if (centerX < center - precision) {

        if (centerX < center - closeDistance) {
          Robot.driveSubsystem.manualDrive(0.0, -turnSpeedFar);
        } else {
          Robot.driveSubsystem.manualDrive(0.0, -turnSpeedClose);
        }

        if (centerX > center + closeDistance) {
          Robot.driveSubsystem.manualDrive(0.0, turnSpeedFar);
        } else {
          Robot.driveSubsystem.manualDrive(0.0, turnSpeedClose);
        }

      } else if (centerX > center + precision) {

        if (centerX > center + closeDistance) {
          Robot.driveSubsystem.manualDrive(0.0, turnSpeedFar);

        } else {
          Robot.driveSubsystem.manualDrive(0.0, turnSpeedClose);
        }

      } else {
        Robot.driveSubsystem.manualDrive(0.0, 0.0);
      }
    // }

  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
  }

  protected void interrupted() {
  }

}