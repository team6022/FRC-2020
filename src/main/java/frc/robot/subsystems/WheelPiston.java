/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;

/**
 * Moves intake up and down
 */
public class WheelPiston extends Subsystem {

  static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.PistonsWheelForwardChannel, RobotMap.PistonsWheelReverseChannel);

  public WheelPiston() {
    super();
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Active(Boolean isActive) {

    doubleSolenoid.set((isActive)
      ? DoubleSolenoid.Value.kForward
      : DoubleSolenoid.Value.kReverse);

    SmartDashboard.putBoolean("WheelPiston", isActive);

  }
}
