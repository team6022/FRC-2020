/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * This command shoots out the Power Cells at variable speeds
 */

public class ShootTrigger extends Command {

    Double _speed = 0.0;
    XboxController Sarjoy = Robot.OI.getJoystickSar();
    Boolean autoShoot = false;

    public ShootTrigger() {
        requires(Robot.Shoot);
    }

    public ShootTrigger(Double Speed) {
        requires(Robot.Shoot);
        _speed = Speed;
        autoShoot = true;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        // check to see if trigger is held
        if (!autoShoot) {
            if (Sarjoy.getTriggerAxis(Hand.kRight) > 0.8) {
                _speed = 0.9;
            } else if (Sarjoy.getTriggerAxis(Hand.kRight) > 0.03) {
                _speed = 0.75;
            } else {
                _speed = 0.0;
            }
        }


        // run motors
        Robot.Shoot.SetSpeed(_speed);


    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
