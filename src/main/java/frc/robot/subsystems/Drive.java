/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.DriveManual;

/**
 * Subsystem for driving the robot via Xbox controller. Also allows differential drive.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public boolean driveInverted = false;

  public boolean tunable = false;

  public WPI_TalonSRX leftMaster, leftSlave, rightMaster, rightSlave;

  public DifferentialDrive drive;

  public static double turnMultiplier;



  public Drive(boolean tunable) {
    this.tunable = tunable;

    leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
    leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
    rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
    rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);

    drive = new DifferentialDrive(leftMaster, rightMaster);

    // RESET TALONS
    leftMaster.configFactoryDefault();
    leftSlave.configFactoryDefault();
    rightMaster.configFactoryDefault();
    rightSlave.configFactoryDefault();

    // LEFT MASTER
    leftMaster.setInverted(driveInverted);
    leftSlave.setInverted(driveInverted);

    leftMaster.setSensorPhase(false);
    leftMaster.setNeutralMode(NeutralMode.Brake);

    // FOLLOW
    leftSlave.follow(leftMaster);

    // RIGHT MASTER
    rightMaster.setInverted(driveInverted);
    rightSlave.setInverted(driveInverted);

    rightMaster.setSensorPhase(false);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    // FOLLOW
    rightSlave.follow(rightMaster);


    turnMultiplier = .4;
  }

  // DRIVE THE MOTORS
  public void manualDrive(double move, double turn) {
    turn = turn * turnMultiplier;
    drive.arcadeDrive(move, turn, false);
  }

  public void stop() {
    drive.tankDrive(0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new DriveManual());
  }
}
