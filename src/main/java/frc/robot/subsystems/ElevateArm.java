package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.RobotMap;


/**
 * Controls ball intake
 */
public class ElevateArm extends Subsystem {

	static Talon ElevateArm = new Talon(RobotMap.ElevateArmChannel);

	public ElevateArm()
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
	public void LiftArm(Double speed)
	{
		ElevateArm.set(speed);
		SmartDashboard.putNumber("ElevateArm", speed);
	}

}