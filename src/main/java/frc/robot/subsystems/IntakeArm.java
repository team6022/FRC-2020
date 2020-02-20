package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

import frc.robot.RobotMap;


/**
 * Controls ball intake
 */
public class IntakeArm extends Subsystem {

	static Talon IntakeArm = new Talon(RobotMap.IntakeArmChannel);

	public IntakeArm()
	{
		super();
	}

	public void initDefaultCommand()
	{
	}

	/**
	* IntakeArm toggles ball intake
	*
	* @param speed what direction to turn - Positive speed means take ball in, negative means shoot ball out
	*/
	public void IntakeBall(Double speed)
	{
		IntakeArm.set(speed);
		SmartDashboard.putNumber("IntakeArm", speed);
	}

}