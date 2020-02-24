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


  // CAN DEVICES
  public static int leftMasterPort = 1;
  public static int leftSlavePort = 4;
  public static int rightMasterPort = 6;
  public static int rightSlavePort = 3;


  public static int shootMaster = 8; // left
  public static int shootSlave = 2; // right

  public static int belt = 7;
  public static final int ElevateArm = 9;
  public static final int WheelMotor = 5;
  public static final int IntakeArm = 10;


  // FRONT (Victor SPX order)
  // 1 - ID 10
  // 2 - ID 05
  // 3 - ID 07
  // 4 - ID 09

  // PISTON CHANNELS
  public static final int PistonsIntakeForwardChannel = 3;
  public static final int PistonsIntakeReverseChannel = 4;

  public static final int PistonsWheelForwardChannel = 2;
  public static final int PistonsWheelReverseChannel = 5;

  public static final int PistonsLiftReleaseForwardChannel = 1;
  public static final int PistonsLiftReleaseReverseChannel = 6;

}
