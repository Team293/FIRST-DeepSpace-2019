// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc293.Drivetrain2019;

import org.usfirst.frc293.Drivetrain2019.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc293.Drivetrain2019.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick leftJoystick;
    public Joystick rightJoystick;
    public JoystickButton upArm;
    public JoystickButton downArm;
    public JoystickButton upElevatorB;
    public JoystickButton downElevatorB;
    public Joystick opLeftJoystick;
    public JoystickButton shootB;
    public JoystickButton gripperOpenB;
    public JoystickButton gripperCloseB;
    public Joystick opRightJoy;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        opRightJoy = new Joystick(2);
        
        gripperCloseB = new JoystickButton(opRightJoy, 3);
        gripperCloseB.whenPressed(new GripperClose());
        gripperOpenB = new JoystickButton(opRightJoy, 5);
        gripperOpenB.whenPressed(new GripperOpen());
        shootB = new JoystickButton(opRightJoy, 2);
        shootB.whenPressed(new GripperOpen());
        opLeftJoystick = new Joystick(3);
        
        downElevatorB = new JoystickButton(opLeftJoystick, 4);
        downElevatorB.whenPressed(new ElevatorDown());
        upElevatorB = new JoystickButton(opLeftJoystick, 6);
        upElevatorB.whenPressed(new ElevatorUp());
        downArm = new JoystickButton(opLeftJoystick, 3);
        downArm.whileHeld(new ArmDown());
        upArm = new JoystickButton(opLeftJoystick, 5);
        upArm.whenPressed(new ArmUp());
        rightJoystick = new Joystick(1);
        
        leftJoystick = new Joystick(0);
        


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveWJoysticks", new DriveWJoysticks());
        SmartDashboard.putData("GripperOpen", new GripperOpen());
        SmartDashboard.putData("GripperClose", new GripperClose());
        SmartDashboard.putData("ElevatorPID", new ElevatorPID());
        SmartDashboard.putData("ArmUp", new ArmUp());
        SmartDashboard.putData("ArmDown", new ArmDown());
        SmartDashboard.putData("PusherIn", new PusherIn());
        SmartDashboard.putData("ElevatorUp", new ElevatorUp());
        SmartDashboard.putData("ElevatorDown", new ElevatorDown());
        SmartDashboard.putData("Shoot", new Shoot());
        SmartDashboard.putData("PusherOut", new PusherOut());
        SmartDashboard.putData("ElevatorStop", new ElevatorStop());
        SmartDashboard.putData("AutoGrip", new AutoGrip());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    //shootB.whenPressed(new GripperOpen());
    shootB.whenReleased(new Shoot());
    downElevatorB.whenReleased(new ElevatorStop());
    upElevatorB.whenReleased(new ElevatorStop());
    
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getOpLeftJoystick() {
        return opLeftJoystick;
    }

    public Joystick getOpRightJoy() {
        return opRightJoy;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    
}

