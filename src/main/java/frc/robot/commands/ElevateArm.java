/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ElevateArm extends Command
{

	Double _Speed = 0.0;

	/**
	* Intake toggles ball intake. Puts intake up
	*
	* @param speed what direction to turn - Positive speed means take ball in, negative means shoot ball out
	*/
	public ElevateArm(Double Speed)
	{
		_Speed = Speed;
		requires(Robot.ElevateArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ElevateArm.LiftArm(_Speed);
	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}
