/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.util.Color;

// commands
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.networktables.NetworkTable;
import frc.robot.autonomous.*;
import frc.robot.commands.*;

// subsystems
import frc.robot.subsystems.Shoot;
import frc.robot.subsystems.WheelMotor;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.BeltMotor;
import frc.robot.subsystems.IntakeArmMotor;
import frc.robot.subsystems.IntakeArmPiston;
import frc.robot.subsystems.WheelPiston;
import frc.robot.subsystems.ElevateArm;
import frc.robot.subsystems.ElevateArmReleasePiston;
import frc.robot.subsystems.ShootPiston;

// color sensor
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

// limelight camera to SmartDashboard
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static OI OI;
  public static Shoot Shoot;
  public static WheelMotor WheelMotor;
  public static BeltMotor BeltMotor;
  public static IntakeArmMotor IntakeArmMotor;
  public static IntakeArmPiston IntakeArmPiston;
  public static WheelPiston WheelPiston;
  public static ElevateArm ElevateArm;
  public static ElevateArmReleasePiston ElevateArmReleasePiston;
  public static ShootPiston ShootPiston;
  public static Orca Orca;

  public static Drive driveSubsystem;

  private final I2C.Port i2cPort = I2C.Port.kOnboard;

  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  // camera
  // NetworkTable table = NetworkTable.getTable("limelight");
  // double targetOffsetAngle_Horizontal = table.getNumber("tx", 0);
  // double targetOffsetAngle_Vertical = table.getNumber("ty", 0);
  // double targetArea = table.getNumber("ta", 0);
  // double targetSkew = table.getNumber("ts", 0);

  Command autonomousCommand;
  SendableChooser<Command> chooser;


  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

    // Load SmartDashbaord Defaults
    new SmartDashboardInit();

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    // Loads cameras.
    CameraServer.getInstance().startAutomaticCapture(0);
    CameraServer.getInstance().startAutomaticCapture(1);

    // Loads robots controls.
    WheelMotor = new WheelMotor();
    Shoot = new Shoot();
    driveSubsystem = new Drive(false);
    BeltMotor = new BeltMotor();
    IntakeArmMotor = new IntakeArmMotor();
    IntakeArmPiston = new IntakeArmPiston();
    WheelPiston = new WheelPiston();
    ElevateArm = new ElevateArm();
    ElevateArmReleasePiston = new ElevateArmReleasePiston();
    ShootPiston = new ShootPiston();
    Orca = new Orca();
    OI = new OI(); // Keep OI at the bottom

    // ===========================================================================

    // Set Autonomous Command

    // autonomousCommand = new autoLeft();
    // autonomousCommand = new autoCenter();
    // autonomousCommand = new autoRight();

    // ===========================================================================

    chooser = new SendableChooser<Command>();
    chooser.setDefaultOption("Do Nothing", new doNothing());
    chooser.addOption("Left Side", new autoLeft());
    chooser.addOption("Center", new autoCenter());
    chooser.addOption("Right Side", new autoRight());

    SmartDashboard.putData("Autonomous Mode Chooser", chooser);



  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    /**
     * The method GetColor() returns a normalized color value from the sensor and
     * can be useful if outputting the color to an RGB LED or similar. To read the
     * raw color, use GetRawColor().
     *
     * The color sensor works best when within a few inches from an object in well
     * lit conditions (the built in LED is a big help here!). The farther an object
     * is the more light from the surroundings will bleed into the measurements and
     * make it difficult to accurately determine its color.
     */
    Color detectedColor = m_colorSensor.getColor();

    /**
     * Run the color match algorithm on our detected color
     */
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    // read values periodically
    SmartDashboard.putNumber("LimelightX",  tx.getDouble(0.0));
    SmartDashboard.putNumber("LimelightY", ty.getDouble(0.0));
    SmartDashboard.putNumber("LimelightArea", ta.getDouble(0.0));

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);






  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    // distSens.setEnableddistSens.setEnabled(false);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    autonomousCommand = chooser.getSelected();

    if (autonomousCommand != null) {
      autonomousCommand.start();
    }

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }


  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
