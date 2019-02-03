// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc293.Drivetrain2019.subsystems;


import org.usfirst.frc293.Drivetrain2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc293.Drivetrain2019.Robot;
/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX leftTalonSRX1;
    private WPI_TalonSRX leftTalonSRX2;
    private WPI_TalonSRX rightTalonSRX3;
    private WPI_TalonSRX rightTalonSRX4;
    private PigeonIMU iMU;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private double speed = 1.0;
    private double maxRPM = 740;
    //TODO get the actual max RPM
    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftTalonSRX1 = new WPI_TalonSRX(2);
        
        
        
        leftTalonSRX2 = new WPI_TalonSRX(3);
        
        
        
        rightTalonSRX3 = new WPI_TalonSRX(4);
        
        
        
        rightTalonSRX4 = new WPI_TalonSRX(5);
        
        
        
        iMU = new PigeonIMU(15);
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    leftTalonSRX1.setSensorPhase(true);
    leftTalonSRX1.clearStickyFaults();
    leftTalonSRX1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,4000);
    leftTalonSRX1.config_kF(0, 1.6, 10);
    leftTalonSRX1.config_kP(0,.2,10);
    leftTalonSRX1.config_kI(0,0,10);
    leftTalonSRX1.config_kD(0,0,10);
    
    leftTalonSRX2.follow(leftTalonSRX1);
        
    rightTalonSRX3.setSensorPhase(true);
    rightTalonSRX3.clearStickyFaults();
    rightTalonSRX3.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,4000);
    rightTalonSRX3.config_kF(0, 1.6, 10);
    rightTalonSRX3.config_kP(0,.2,10);
    rightTalonSRX3.config_kI(0,0,10);
    rightTalonSRX3.config_kD(0,0,10);

    rightTalonSRX4.follow(rightTalonSRX3);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveWJoysticks());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        if(Robot.oi.getLeftJoystick().getTrigger()||Robot.oi.getRightJoystick().getTrigger()){
            speed = 0.25;
        }
        else{
            speed = 1.0;
        }
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void velocityDrive(Joystick left, Joystick right){
        double leftSetpoint = left.getY() * maxRPM * speed;
        double rightSetpoint = right.getY() * maxRPM * speed;
        leftTalonSRX1.set(ControlMode.Velocity, -leftSetpoint);
        rightTalonSRX3.set(ControlMode.Velocity, rightSetpoint);
    }
    public void distance(double leftRotations, double rightRotations){
        leftTalonSRX1.set(ControlMode.Position,leftRotations);
        rightTalonSRX3.set(ControlMode.Position,rightRotations);
    }
    public void stop(){
        leftTalonSRX1.set(ControlMode.PercentOutput,0);
        rightTalonSRX3.set(ControlMode.PercentOutput,0);
    }
    public void full(){
        leftTalonSRX1.set(ControlMode.PercentOutput,100);
        rightTalonSRX3.set(ControlMode.PercentOutput,100);
    }
}

