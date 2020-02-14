package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import frc.robot.RobotMap;


/**
 * Controls ball intake
 */
public class ElevateArm extends Subsystem {

	static VictorSPX ElevateArm = new VictorSPX(RobotMap.ElevateArm);

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
		ElevateArm.set(ControlMode.PercentOutput, speed);
		SmartDashboard.putNumber("ElevateArm", speed);
	}

}