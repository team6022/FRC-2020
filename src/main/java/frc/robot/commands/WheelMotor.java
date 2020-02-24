/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;

/**
 * This command will use a wheel to spin the ColorWheel.
 */
public class WheelMotor extends Command {

  Double _Speed = 0.0;
  String _ColorStop = "Unknown";
  int colorCounter = 0;
  boolean okInc = false; // it's ok to increment
  String startColor = "Unknown";
 
  int colorCheck = 0; // We will need to check the color a couple times to make sure it is correct
  String currentColor = "Unknown";

  public WheelMotor(Double speed, String colorStop) {
    // Use requires() here to declare subsystem dependencies





    String[] colorSensorReal = {"R", "Y", "B", "G", "Unknown" };
    String[] colorSensorOffset = {"B", "G", "R", "Y", "Unknown" };

    _Speed = speed;
    _ColorStop = colorStop;
    // _ColorStop = colorSensorOffset[java.util.Arrays.asList(colorSensorReal).indexOf(colorStop)];

    requires(Robot.WheelMotor);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    startColor = SmartDashboard.getString("Detected Color", "Unknown");
    currentColor = startColor;
    okInc = true;
    colorCounter = 0;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Will stop the wheel when desired color is detected

    // Are we on our start color?
    Boolean onColor = SmartDashboard.getString("Detected Color", "Unknown").equals(startColor);

    // The color that is currently getting detected
    String sensedColor = SmartDashboard.getString("Detected Color", "Unknown");

    // We will check the color a couple times to make sure it is getting the correct color
    if (currentColor.equals(sensedColor)) {
      colorCheck++;
      System.out.println("color");

    }

    // if we get the same color 3 times in a row, we can consider it move onto the next color
    if (onColor && okInc && colorCheck >= 3) {
      colorCounter++;
      colorCheck = 0;
    }

    okInc = !onColor;


    if (colorCounter >= 8) {
      Robot.WheelMotor.SetSpeed(0.0);
    } else {
      Robot.WheelMotor.SetSpeed(_Speed);
    }

    System.out.println(colorCounter);


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
