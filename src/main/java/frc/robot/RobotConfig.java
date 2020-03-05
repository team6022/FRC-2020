/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotConfig {


    // INTAKE ARM MOTOR ============================================================

    public static double intakeMotorSpeed = 1.0;


    // LIFT ARM MOTOR ============================================================

    public static double elevateArmLiftSpeed = -0.5;
    public static double elevateArmBackSpeed = 1.0;


    // SHOOT MOTOR ============================================================

    // speeds
    public static double shootTriggerMaxSpeed = 0.9;
    public static double shootTriggerMidSpeed = 0.75;

    // trigger pull percent to activate speeds
    public static double shootTriggerMaxSpeedPull = 0.8;
    public static double shootTriggerMidSpeedPull = 0.03;


    // BELT ============================================================

    // speeds
    public static double beltTriggerMaxSpeed = 0.7;
    public static double beltTriggerMidSpeed = 0.3;
    public static double beltBackSpeed = -0.5;

    // trigger pull percent to activate speeds
    public static double beltTriggerMaxSpeedPull = 0.9;
    public static double beltTriggerMidSpeedPull = 0.3;


    // LIMELIGHT AUTO ============================================================

    public static double limelightAutoTurnSpeed = 0.25;
    public static double limelightAutoOffset = 4.5; // how far from 0 is considered alright


}
