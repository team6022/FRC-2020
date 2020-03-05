/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class autoCenter extends CommandGroup {
  /**
   * Creates a new auto.
   */
  public autoCenter() {


    Double turnTime = 0.33;
    Double turnAmount = 0.6;

    Double driveTime = 1.65;
    Double driveAmount = 0.5;


    // backup
    addSequential(new DriveManual(-0.3, 0.0), 0.5);

    addSequential(new DriveManual(0.0, 0.0), 0.5);


    // line up target
    addSequential(new LimeLightAuto(), 5.0);

    // drop intake arm
    addSequential(new IntakeArmPiston(true), 0.5);

    // start shoot motor
    addSequential(new ShootTrigger(0.76), 0.5);

    // shoot balls
    addParallel(new ShootTrigger(0.76), 2.0);
    addSequential(new Belt(0.7), 2.0);

    // // turn left
    addSequential(new DriveManual(0.0, -turnAmount), turnTime);

    // addSequential(new Log("WAIT"));
    addSequential(new DriveManual(0.0, 0.0), 0.5);

    // move backup while running intake and belt
    addSequential(new Log("5 - Back it up and grab balls"));
    addParallel(new ShootTrigger(0.0), driveTime);
    addParallel(new IntakeArmMotor(0.5), driveTime);
    addParallel(new Belt(0.7), driveTime);
    addSequential(new DriveManual(-driveAmount, 0.0), driveTime);

    // wait
    addSequential(new DriveManual(0.0, 0.0), 0.5);

    // move forward
    addSequential(new Log("6 - Move Forward"));
    addParallel(new IntakeArmMotor(0.0), driveTime);
    addSequential(new DriveManual(driveAmount, 0.0), driveTime);

    // wait
    addSequential(new DriveManual(0.0, 0.0), 0.5);



    // turn left again and stop belt
    addSequential(new Belt(0.0), turnTime);
    addSequential(new DriveManual(0.0, turnAmount), turnTime);

    // //
    // addSequential(new Log("WAIT"));
    addSequential(new DriveManual(0.0, 0.0), 0.3);

    // // line it up
    // addSequential(new Log("LINE UP TARGET"));
    addSequential(new LimeLightAuto(), 5.0);

    // start shoot motor
    // addSequential(new Log("8 - Start Shoot Motor"));
    addSequential(new ShootTrigger(0.75), 0.5);

    // shoot balls
    // addSequential(new Log("9 - Shoot Balls"));
    addParallel(new ShootTrigger(0.75), 3.0);
    addSequential(new Belt(0.7), 3.0);

  }
}
