package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;

import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // Controllers
  final XboxController Sarjoy = new XboxController(0);
  final Joystick Branjoy = new Joystick(1);

  // Buttons for Sarjoy
  Button XBoxA = new JoystickButton(Sarjoy, 1);
  Button XBoxB = new JoystickButton(Sarjoy, 2);
  Button XBoxX = new JoystickButton(Sarjoy, 3);
  Button XBoxY = new JoystickButton(Sarjoy, 4);
  Button XBoxLB = new JoystickButton(Sarjoy, 5);
  Button XBoxRB = new JoystickButton(Sarjoy, 6);
  Button XBoxBack = new JoystickButton(Sarjoy, 7);
  Button XBoxStart = new JoystickButton(Sarjoy, 8);
  Button XBoxL3 = new JoystickButton(Sarjoy, 9);
  Button XBoxR3 = new JoystickButton(Sarjoy, 10);
  // Button XBoxLT = new JoystickButton(Sarjoy, 11);
  // Button XBoxRT = new JoystickButton(Sarjoy,12);
  POVButton XBoxDPadUp = new POVButton(Sarjoy, 0);
  POVButton XBoxDPadRight = new POVButton(Sarjoy, 90);
  POVButton XBoxDPadDown = new POVButton(Sarjoy, 180);
  POVButton XBoxDPadLeft = new POVButton(Sarjoy, 270);

  // Buttons for Branjoy
  Button JoyRed = new JoystickButton(Branjoy, 3);
  Button JoyBlue = new JoystickButton(Branjoy, 1);
  Button JoyYellow = new JoystickButton(Branjoy, 4);
  Button JoyGreen = new JoystickButton(Branjoy, 2);
  Button JoyLB = new JoystickButton(Branjoy, 5);
  Button JoyRB = new JoystickButton(Branjoy, 6);
  Button JoyLT = new JoystickButton(Branjoy, 7);
  Button JoyRT = new JoystickButton(Branjoy, 8);
  Button JoyBack = new JoystickButton(Branjoy, 9);
  Button JoyStart = new JoystickButton(Branjoy, 10);
  Button JoyL3 = new JoystickButton(Branjoy, 11);
  Button JoyR3 = new JoystickButton(Branjoy, 12);
  POVButton JoyDPadUp = new POVButton(Branjoy, 0);
  POVButton JoyDPadRight = new POVButton(Branjoy, 90);
  POVButton JoyDPadDown = new POVButton(Branjoy, 180);
  POVButton JoyDPadLeft = new POVButton(Branjoy, 270);

  public XboxController getJoystickSar() {
    return Sarjoy;
  }

  public Joystick getJoystickBran() {
    return Branjoy;
  }

  public OI() {
    // Allows us to receive the randomized color for Position Control.
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    String colorStop = "Unknown";
    if (gameData.length() > 0) {
      switch (gameData.charAt(0)) {
      case 'B':
        colorStop = "Blue";
        break;
      case 'G':
        colorStop = "Green";
        break;
      case 'R':
        colorStop = "Red";
        break;
      case 'Y':
        colorStop = "Yellow";
        break;
      default:
        colorStop = "Unknown";
        break;
      }
    } else {
      colorStop = "Unknown";
    }

    // Sarjoy Input ===============================================================

    // shoot - this has been moved to the trigger
    // XBoxRT.whileHeld(new Shoot(0.8));
    // XBoxRT.whenReleased(new Shoot(0.0));

    // belt - this has been moved to the trigger
    // XBoxLB.whileHeld(new Belt(0.7));
    // XBoxLB.whenReleased(new Belt(0.0));

    XBoxBack.whileHeld(new Belt(RobotConfig.beltBackSpeed));
    XBoxBack.whenReleased(new Belt(0.0));

    // Intake Motor
    XBoxA.whenPressed(new IntakeArmMotor(RobotConfig.intakeMotorSpeed));
    XBoxA.whenReleased(new IntakeArmMotor(0.0));

    // Wheel Piston
    XBoxLB.whenPressed(new WheelPiston(true));
    XBoxLB.whenReleased(new WheelPiston(false));

    // Wheel Motor
    XBoxRB.whileHeld(new WheelMotor(0.3, colorStop));
    XBoxRB.whenReleased(new WheelMotor(0.0, "Unknown"));

    // intake piston
    XBoxDPadUp.whenPressed(new IntakeArmPiston(false));
    XBoxDPadDown.whenPressed(new IntakeArmPiston(true));

    // wheel piston
    XBoxDPadLeft.whenPressed(new WheelPiston(false));
    XBoxDPadRight.whenPressed(new WheelPiston(true));

    // toggle drive direction
    XBoxB.whenReleased(new DriveDirectionToggle());

    // // lift arm release
    XBoxY.whenPressed(new ElevateArmReleasePiston(true));
    XBoxY.whenReleased(new ElevateArmReleasePiston(false));


    // try to align
    // XBoxR3.whenPressed(new LimeLightAuto());

    // run orca
    // XBoxStart.whenPressed(new Orca());

    // Branjoy Input ===============================================================

    // colors
    // JoyGreen.whileHeld(new Wheel(0.15, "G"));
    // JoyGreen.whenReleased(new Wheel(0.0, "Unknown"));
    // JoyRed.whileHeld(new Wheel(0.15, "R"));
    // JoyRed.whenReleased(new Wheel(0.0, "Unknown"));
    // JoyBlue.whileHeld(new Wheel(0.15, "B"));
    // JoyBlue.whenReleased(new Wheel(0.0, "Unknown"));
    // JoyYellow.whileHeld(new Wheel(0.15, "Y"));
    // JoyYellow.whenReleased(new Wheel(0.0, "Unknown"));

    // intake
    JoyYellow.whenPressed(new ElevateArmReleasePiston(true));
    JoyYellow.whenReleased(new ElevateArmReleasePiston(false));

    // elevatearm
    JoyDPadDown.whileHeld(new ElevateArm(RobotConfig.elevateArmLiftSpeed));
    JoyDPadDown.whenReleased(new ElevateArm(0.0));

    JoyBack.whileHeld(new ElevateArm(RobotConfig.elevateArmBackSpeed));
    JoyBack.whenReleased(new ElevateArm(0.0));

    // Intake
    JoyGreen.whileHeld(new IntakeArmMotor(RobotConfig.intakeMotorSpeed));
    JoyGreen.whenReleased(new IntakeArmMotor(0.0));

    JoyRed.whileHeld(new IntakeArmMotor(-RobotConfig.intakeMotorSpeed));
    JoyRed.whenReleased(new IntakeArmMotor(0.0));

    // JoyLB.whenPressed(new IntakePiston(true));
    // JoyLB.whenPressed(new IntakePiston(false));

    // Wheel Piston
    JoyLT.whenPressed(new WheelPiston(true));
    JoyLT.whenReleased(new WheelPiston(false));

    // Wheel Motor
    JoyRT.whileHeld(new WheelMotor(0.4, colorStop));
    JoyRT.whenReleased(new WheelMotor(0.0, "Unknown"));

    // lift arm release
    JoyStart.whenPressed(new ElevateArmReleasePiston(true));
    JoyStart.whenReleased(new ElevateArmReleasePiston(false));

  }

}
