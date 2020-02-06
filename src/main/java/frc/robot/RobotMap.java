/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // public static final int Shoot = 0;
  public static final int Wheel = 4;

  // CAN Devices
  public static int leftMasterPort = 3;
  public static int leftSlavePort = 6;
  public static int rightMasterPort = 0;
  public static int rightSlavePort = 1;


  public static int shootMaster = 2;
  public static int shootSlave = 4;

  public static int belt = 5;



  public static final int ShootMotor = 0;

  // TALON Settings
  public static final int slot0 = 0;
  public static final int slot1 = 1;
  public static final int slot2 = 2;
  public static final int slot3 = 3;

  public static final int pidPrimary = 0;
  public static final int pidTurn = 1;

  public static final int timeoutMs = 30;
  public static final int baseTrajPeriodMs = 0;
  
  public static final double driveNeutralDeadband = 0.1;

  // 30AMP CURRENT LIMITS
  public static final int current30AmpPeakCurrentLimit = 25;
  public static final int current30AmpPeakCurrentDuration = 200;
  public static final int current30AmpContinuousCurrentLimit = 25;

  // 40AMP CURRENT LIMITS
  public static final int current40AmpPeakCurrentLimit = 35;
  public static final int current40AmpPeakCurrentDuration = 200;
  public static final int current40AmpContinuousCurrentLimit = 35;

  // PISTON CHANNELS

  public static final int PistonsForwardChannel = 0;
  public static final int PistonsReverseChannel = 1;
  

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
