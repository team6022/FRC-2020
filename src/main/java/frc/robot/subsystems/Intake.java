package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

import frc.robot.RobotMap;


/**
 * Starts the Power Cell intake
 */
public class Intake extends Subsystem {

	static Talon Intake = new Talon(RobotMap.IntakeChannel);

	public Intake()
	{
		super();
	}

	public void initDefaultCommand()
	{
	}

	/**
	* Intake toggles ball intake
	*
	* @param speed what direction to turn - Positive speed means take ball in, negative means shoot ball out
	*/
	public void IntakeBall(Double speed)
	{
		Intake.set(speed);
		SmartDashboard.putNumber("Intake", speed);
	}

}