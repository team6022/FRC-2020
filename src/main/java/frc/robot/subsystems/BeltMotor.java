/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.Belt;

/**
 * Subsystem for the Belt command.
 */
public class BeltMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  static WPI_VictorSPX beltTop = new WPI_VictorSPX(RobotMap.beltTop);
  static WPI_TalonSRX beltBottom = new WPI_TalonSRX(RobotMap.beltBottom);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Belt());

    beltTop.configFactoryDefault();
    beltBottom.configFactoryDefault();

  }

  public void SetSpeed(Double speed) {

    beltTop.setInverted(false);
    beltBottom.setInverted(true);

    beltTop.set(ControlMode.PercentOutput, speed);
    beltBottom.set(ControlMode.PercentOutput, (speed * 0.8));

    SmartDashboard.putNumber("BeltMotor", speed);

  }
}
