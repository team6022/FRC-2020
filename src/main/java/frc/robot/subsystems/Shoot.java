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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.ShootTrigger;

/**
 * This is the subsystem for the shoot command which will help shoot out the
 * Power Cell
 */
public class Shoot extends Subsystem {

  static WPI_TalonSRX shootMaster = new WPI_TalonSRX(RobotMap.shootMaster);
  static WPI_TalonSRX shootSlave = new WPI_TalonSRX(RobotMap.shootSlave);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShootTrigger());
  }

  public void SetSpeed(final Double speed) {

    shootMaster.configFactoryDefault();
    shootSlave.configFactoryDefault();

    shootMaster.setInverted(false);
    shootSlave.setInverted(true);
    // shootSlave.follow(shootMaster);

    shootMaster.set(ControlMode.PercentOutput, speed);
    shootSlave.set(ControlMode.PercentOutput, speed);

    SmartDashboard.putNumber("Shoot", speed);
  }

}
