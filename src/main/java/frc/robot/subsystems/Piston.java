/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Moves intake up and down
 */
public class Piston extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.PistonsForwardChannel, RobotMap.PistonsReverseChannel);

 
  public Piston() {
        super();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Active(XboxController Sarjoy) {
    
    boolean isActive = (Sarjoy.getTriggerAxis(Hand.kRight) >= 0.9);
    doubleSolenoid.set((isActive)
      ? DoubleSolenoid.Value.kForward
      : DoubleSolenoid.Value.kReverse);
      SmartDashboard.putBoolean("PistonOut", isActive);

  }
}
