/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class autoLeft extends CommandGroup {
  /**
   * Creates a new auto.
   */
  public autoLeft() {


    Double turnTime = 0.22;
    Double turnAmount = 0.6;

    Double driveTime = 2.5;
    Double driveAmount = 0.45;


    // line up target
    addSequential(new Log("LINE UP TARGET"));
    addSequential(new LimeLightAuto(), 5.0);

    // drop intake arm
    addSequential(new Log("1 - Dropping Intake"));
    addSequential(new IntakeArmPiston(true), 0.5);

    // start shoot motor
    addSequential(new Log("2 - Start Shoot Motor"));
    addSequential(new ShootTrigger(0.75), 0.5);

    // shoot balls
    addSequential(new Log("3 - Shoot Balls"));
    addParallel(new ShootTrigger(0.75), 2.0);
    addSequential(new Belt(0.7), 2.0);

    // turn right
    addSequential(new Log("4 - Turn Right"));
    addSequential(new DriveManual(0.0, turnAmount), turnTime);

    addSequential(new Log("WAIT"));
    addSequential(new DriveManual(0.0, 0.0), 0.5);

    // move backup while running intake and belt
    addSequential(new Log("5 - Back it up and grab balls"));
    addParallel(new ShootTrigger(0.0), driveTime);
    addParallel(new IntakeArmMotor(1.0), driveTime);
    addParallel(new Belt(0.9), driveTime);
    addSequential(new DriveManual(-driveAmount, 0.0), driveTime);

    addSequential(new Log("WAIT"));
    addSequential(new DriveManual(0.0, 0.0), 0.8);

    // move forward
    addSequential(new Log("6 - Move Forward"));
    addParallel(new Belt(0.0), driveTime);
    addSequential(new DriveManual(driveAmount, 0.0), driveTime);

    addSequential(new Log("WAIT"));
    // addParallel(new IntakeArmMotor(0.0), driveTime);
    addSequential(new DriveManual(0.0, 0.0), 0.5);




    // turn left again and stop belt
    addSequential(new Log("7 - Turn Left"));
    addSequential(new DriveManual(0.0, -turnAmount), turnTime);

    // Wait
    addSequential(new Log("WAIT"));
    addSequential(new DriveManual(0.0, 0.0), 0.3);

    // line it up
    addSequential(new Log("LINE UP TARGET"));
    addSequential(new LimeLightAuto(), 5.0);

    // start shoot motor
    addSequential(new Log("8 - Start Shoot Motor"));
    addSequential(new ShootTrigger(0.75), 0.5);

    // shoot balls
    addSequential(new Log("9 - Shoot Balls"));
    addParallel(new ShootTrigger(0.75), 3.0);
    addSequential(new Belt(0.7), 3.0);

  }
}
