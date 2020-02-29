/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autonomous.auto1;

/**
 * Set SmartDashboard Defaults
 */
public class SmartDashboardInit {

    public SmartDashboardInit() {


        // SmartDashboard inputs for driving, shooting, and ColorWheel motors
        SmartDashboard.setDefaultNumber("TalonFX/leftMaster", 0);
        SmartDashboard.setDefaultNumber("TalonFX/leftSlave", 0);
        SmartDashboard.setDefaultNumber("TalonFX/rightMaster", 0);
        SmartDashboard.setDefaultNumber("TalonFX/rightSlave", 0);
        SmartDashboard.setDefaultBoolean("ElevateArmReleasePiston", false);
        SmartDashboard.setDefaultNumber("IntakeArmMotor", 0);
        SmartDashboard.setDefaultNumber("ElevateArm", 0);
        SmartDashboard.setDefaultNumber("BeltMotor", 0);
        SmartDashboard.setDefaultBoolean("IntakeArmPiston", false);
        SmartDashboard.setDefaultNumber("Shoot/shootMaster", 0);
        SmartDashboard.setDefaultNumber("Shoot/shootSlave", 0);
        SmartDashboard.setDefaultNumber("WheelMotor", 0);
        SmartDashboard.setDefaultBoolean("WheelPiston", false);

        // NetworkTable.initialize();
        // autoChooser = new SendableChooser();
        // autoChooser.addDefault("Default program", new auto1());
        // SmartDashboard.putData("Autonomous mode chooser", autoChooser);

    }

}
