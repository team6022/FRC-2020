/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManual;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public boolean tunable = false;

	public WPI_TalonSRX leftMaster, leftSlave, 
	rightMaster, rightSlave;

    public DifferentialDrive drive;


	public static double turnMultiplier;

	public Drive(boolean tunable) {
		this.tunable = tunable;

		leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
		leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
		rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
        rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);
        
    

        drive = new DifferentialDrive(leftMaster, rightSlave);

		// RESET TALONS
		leftMaster.configFactoryDefault();
		leftSlave.configFactoryDefault();
		rightMaster.configFactoryDefault();
		rightSlave.configFactoryDefault();

		// LEFT MASTER
		leftMaster.configNeutralDeadband(RobotMap.driveNeutralDeadband, RobotMap.timeoutMs);
		leftMaster.setInverted(false);
		leftSlave.setInverted(false);
		leftMaster.setSensorPhase(false);
		leftMaster.setNeutralMode(NeutralMode.Brake);
		
		// FOLLOW
		leftSlave.follow(leftMaster);
		
		// RIGHT MASTER
		rightMaster.configNeutralDeadband(RobotMap.driveNeutralDeadband, RobotMap.timeoutMs);
		rightMaster.setInverted(false);
		rightSlave.setInverted(false);
		rightMaster.setSensorPhase(false);	
		rightMaster.setNeutralMode(NeutralMode.Brake);

		// FOLLOW
		rightSlave.follow(rightMaster);

		// Current Limiting
		leftMaster.configPeakCurrentLimit(RobotMap.current40AmpPeakCurrentLimit, RobotMap.timeoutMs);
		leftMaster.configPeakCurrentDuration(RobotMap.current40AmpPeakCurrentDuration, RobotMap.timeoutMs);
		leftMaster.configContinuousCurrentLimit(RobotMap.current40AmpContinuousCurrentLimit, RobotMap.timeoutMs);
		leftMaster.enableCurrentLimit(true); 
		
		rightMaster.configPeakCurrentLimit(RobotMap.current40AmpPeakCurrentLimit, RobotMap.timeoutMs);
		rightMaster.configPeakCurrentDuration(RobotMap.current40AmpPeakCurrentDuration, RobotMap.timeoutMs);
		rightMaster.configContinuousCurrentLimit(RobotMap.current40AmpContinuousCurrentLimit, RobotMap.timeoutMs);
		rightMaster.enableCurrentLimit(true); 		
	
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
