/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class auto2 extends CommandGroup {
  /**
   * Creates a new auto.
   */
  public auto2() {

    // https://docs.wpilib.org/en/latest/docs/software/old-commandbased/commands/synchronizing-two-commands.html


    // addSequential(new DriveManual(0.2, 0.0), 0.5);

    // addSequential(new DriveManual(0.0, 0.5), 0.5);


    // addParallel(new ShootTrigger(0.9), 0.5);
    // addSequential(new DriveManual(0.0, -0.5), 0.5);



    // drop intake arm
    addSequential(new IntakeArmPiston(true), 0.5);

    // start shoot motor
    // addSequential(new ShootTrigger(0.8), 0.5); // front
    addParallel(new ShootPiston(true), 0.5);
    addSequential(new ShootTrigger(0.75), 0.5);

    // // shoot balls
    addParallel(new ShootTrigger(0.75), 2.0);
    addSequential(new Belt(0.7), 2.0);

    // turn left
    //addSequential(new DriveManual(0.0, -0.6), 2.0);

    // move forward
    // addSequential(new DriveManual(0.5, 0.5), 3.0);

    // // turn left
    // addSequential(new DriveManual(0.6, 0.0), 2.0);

    // // move backwards and start the intake
    // addSequential(new DriveManual(-0.5, -0.5), 3.5);
    // addParallel(new IntakeArmMotor(0.5), 3.5);
  }
}
