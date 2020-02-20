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
  Button JoyRed = new JoystickButton(Branjoy, 2);
  Button JoyBlue = new JoystickButton(Branjoy, 3);
  Button JoyYellow = new JoystickButton(Branjoy, 4);
  Button JoyGreen = new JoystickButton(Branjoy, 1);
  Button JoyLB = new JoystickButton(Branjoy, 5);
  Button JoyRB = new JoystickButton(Branjoy, 6);
  Button JoyBack = new JoystickButton(Branjoy, 7);
  Button JoyStart = new JoystickButton(Branjoy, 8);
  Button JoyL3 = new JoystickButton(Branjoy, 9);
  Button JoyR3 = new JoystickButton(Branjoy, 10);
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

    // shoot
    // XBoxRT.whileHeld(new Shoot(0.8));
    // XBoxRT.whenReleased(new Shoot(0.0));

    // belt
    XBoxLB.whileHeld(new Belt(0.7));
    XBoxLB.whenReleased(new Belt(0.0));

    // belt back
    XBoxBack.whileHeld(new Belt(-0.4));
    XBoxBack.whenReleased(new Belt(0.0));

    // wheel
    XBoxB.whileHeld(new Wheel(0.15, colorStop));
    XBoxB.whenReleased(new Wheel(0.0, "Unknown"));

    // liftarm
    XBoxRB.whileHeld(new LiftColorArm());

    // intake
    JoyYellow.whileHeld(new Intake(0.5));
    JoyYellow.whenReleased(new Intake(0.0));

    // intakearm
    XBoxDPadDown.whenPressed(new IntakeArm());


    // Branjoy Input ===============================================================


    // colors
    JoyGreen.whileHeld(new Wheel(0.15, "G"));
    JoyGreen.whenReleased(new Wheel(0.0, "Unknown"));
    JoyRed.whileHeld(new Wheel(0.15, "R"));
    JoyRed.whenReleased(new Wheel(0.0, "Unknown"));
    JoyBlue.whileHeld(new Wheel(0.15, "B"));
    JoyBlue.whenReleased(new Wheel(0.0, "Unknown"));
    JoyYellow.whileHeld(new Wheel(0.15, "Y"));
    JoyYellow.whenReleased(new Wheel(0.0, "Unknown"));

    // elevatearm
    JoyDPadUp.whileHeld(new ElevateArm(0.5));
    JoyDPadUp.whenReleased(new ElevateArm(0.0));
    JoyDPadDown.whileHeld(new ElevateArm(-0.5));
    JoyDPadDown.whenReleased(new ElevateArm(0.0));

  }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
