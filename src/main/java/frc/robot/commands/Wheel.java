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
 * this command will use a wheel to spin the ColorWheel.
 */
public class Wheel extends Command {

  Double _Speed = 0.0;
  String _ColorStop = "Unknown";
  int colorCounter = 0;
  boolean okInc = false;
  String startColor = "Unknown";
 
  int colorCheck = 0; // we will need to check the color a couple times to make sure it is correct
  String currentColor = "Unknown";

  public Wheel(Double speed, String colorStop) {
    // Use requires() here to declare subsystem dependencies





    String[] colorSensorReal = {"R", "Y", "B", "G" };
    String[] colorSensorOffset = {"B", "G", "R", "Y" };

    _Speed = speed;
    _ColorStop = colorStop;
    // _ColorStop = colorSensorOffset[java.util.Arrays.asList(colorSensorReal).indexOf(colorStop)];

    requires(Robot.Wheel);

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

    // are we on our start color
    Boolean onColor = SmartDashboard.getString("Detected Color", "Unknown").equals(startColor);

    // the color that is currently getting detected
    String sensedColor = SmartDashboard.getString("Detected Color", "Unknown");

    // we will check the color a couple times to make sure it is getting the correct color
    if (currentColor.equals(sensedColor)) {
      colorCheck++;
      System.out.println("color");

    }

    if (onColor && okInc && colorCheck >= 3) {
      colorCounter++;
      colorCheck = 0;
    }

    okInc = !onColor;


    if (colorCounter >= 8) {
      Robot.Wheel.SetSpeed(0.0);
    } else {
      Robot.Wheel.SetSpeed(_Speed);
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
