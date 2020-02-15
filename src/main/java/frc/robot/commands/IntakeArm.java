package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**
 * Puts the intake down.
 */
public class IntakeArm extends Command {
  public IntakeArm() {
    // Use requires() here to declare subsystem dependencies
    // requires(Robot.m_subsystem);
   // requires(Robot.IntakeArm);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

        Robot.Piston.Active(Robot.OI.getJoystickSar());
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
