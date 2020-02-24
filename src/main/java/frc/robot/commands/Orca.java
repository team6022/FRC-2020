/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

import com.ctre.phoenix.music.Orchestra;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/**
 * An example command. You can replace me with your own command.
 */
public class Orca extends Command {

  /* The orchestra object that holds all the instruments */
  Orchestra _orchestra;

  static TalonFX Treb = new TalonFX(RobotMap.shootMaster);
  static TalonFX Bass = new TalonFX(RobotMap.shootSlave);

  public Orca() {
    // Use requires() here to declare subsystem dependencies
    // requires(Robot.m_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    /* A list of TalonFX's that are to be used as instruments */
    ArrayList<TalonFX> _instruments = new ArrayList<TalonFX>();

    /* Initialize the TalonFX's to be used */
    _instruments.add(Treb);
    _instruments.add(Bass);

    /* Create the orchestra with the TalonFX instruments */
    _orchestra = new Orchestra(_instruments);

    _orchestra.loadMusic("pkmn.chrp");

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {


    _orchestra.play();

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
