/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class autoRight extends CommandGroup {
  /**
   * Creates a new auto.
   */
  public autoRight() {


    Double turnTime = 0.33;
    Double turnAmount = 0.6;

    Double driveTime = 1.65;
    Double driveAmount = 0.3;


    // line up target
    addSequential(new LimeLightAuto(), 5.0);

    // drop intake arm
    addSequential(new IntakeArmPiston(true), 0.5);

    // start shoot motor
    addSequential(new ShootTrigger(0.9), 0.5);

    // shoot balls
    addParallel(new ShootTrigger(0.9), 2.0);
    addSequential(new Belt(0.7), 2.0);

    // // turn left
    addSequential(new DriveManual(0.0, -turnAmount), turnTime);

    // addSequential(new Log("WAIT"));
    addSequential(new DriveManual(0.0, 0.0), 0.5);

    addSequential(new DriveManual(driveAmount, 0.0), driveTime);

  }
}
