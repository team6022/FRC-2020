package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;

/**
 * Controls ball intake
 */
public class IntakeArmMotor extends Subsystem {

  static VictorSPX IntakeArm = new VictorSPX(RobotMap.IntakeArm);

  public IntakeArmMotor() {
    super();
  }

  public void initDefaultCommand() {
  }

  /**
   * IntakeArm toggles ball intake
   *
   * @param speed what direction to turn - Positive speed means take ball in,
   *              negative means shoot ball out
   */
  public void IntakeBall(Double speed) {
    IntakeArm.set(ControlMode.PercentOutput, speed);
    SmartDashboard.putNumber("IntakeArmMotor", speed);
  }

}