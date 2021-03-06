/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;

/**
 * Subsystem for spinning the ColorWheel for a certain amount of times and for a
 * certain color
 */
public class WheelMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  static VictorSPX Wheel = new VictorSPX(RobotMap.WheelMotor);

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }

  public void SetSpeed(Double speed) {
    Wheel.set(ControlMode.PercentOutput, speed);
    SmartDashboard.putNumber("WheelMotor", speed);

  }

}
