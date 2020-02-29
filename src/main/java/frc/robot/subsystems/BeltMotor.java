/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

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
  static WPI_VictorSPX belt = new WPI_VictorSPX(RobotMap.belt);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Belt());
  }

  public void SetSpeed(Double speed) {

    // belt.configFactoryDefault();
    belt.set(ControlMode.PercentOutput, speed);
    // belt.setInverted(true);

    SmartDashboard.putNumber("BeltMotor", speed);

  }
}
