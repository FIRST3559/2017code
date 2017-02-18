package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import org.usfirst.frc.team3559.robot.commands.TankDriveWithGamepad;



/**
 *
 */
public class DriveBase extends Subsystem {
	private CANTalon leftMotor, rightMotor;
	private CANTalon leftSlave, rightSlave;
	private RobotDrive drive;
	private boolean brake = true;
	private double speedModifier = 0.90;
	
	public DriveBase(){
		super();
		// Left Side
		leftMotor = new CANTalon(3);
		leftMotor.enableBrakeMode(brake);
		leftSlave = new CANTalon(4);
		leftSlave.enableBrakeMode(brake);
		leftSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftSlave.set(leftMotor.getDeviceID());
		leftMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		leftMotor.reverseSensor(false);
		// Right Side
		rightMotor = new CANTalon(1);
		rightMotor.enableBrakeMode(brake);
		rightSlave = new CANTalon(2);
		rightSlave.enableBrakeMode(brake);
		rightSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightSlave.set(rightMotor.getDeviceID());
		rightMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rightMotor.reverseSensor(false);
		
		drive = new RobotDrive(leftMotor, rightMotor);
		drive.setSafetyEnabled(false);
		
		// Send data to LiveWindow
		LiveWindow.addActuator("Drive Base", "Left Motor", leftMotor);
		LiveWindow.addSensor("Drive Base", "Left Motor", leftMotor);
		LiveWindow.addActuator("Drive Base", "Right Motor", rightMotor);
		LiveWindow.addSensor("Drive Base", "Right Motor", rightMotor);
	}
	
	

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveWithGamepad());
    }
    
    public void log(){
    	SmartDashboard.putNumber("Left Distance", leftMotor.getPosition());
    	SmartDashboard.putNumber("right Distance", rightMotor.getPosition());
    	SmartDashboard.putNumber("Left Speed", leftMotor.getSpeed());
    	SmartDashboard.putNumber("Right Speed",  rightMotor.getSpeed());
    	SmartDashboard.putNumber("Speed Modifier", speedModifier);
    }
    public void drive(double left, double right){
    	drive.tankDrive(left,  right);
    }
    /**
     * @param gamepad The Logitech style Gamepad to use to drive tank style.
     */
    public void drive(Joystick gamepad){
    	leftMotor.changeControlMode(TalonControlMode.PercentVbus);
    	leftMotor.setVoltageRampRate(0);
    	leftMotor.setPID(0.0, 0.0, 0.0);
    	leftMotor.enableControl();
    	rightMotor.changeControlMode(TalonControlMode.PercentVbus);
    	rightMotor.setVoltageRampRate(0);
    	rightMotor.setPID(0.0, 0.0, 0.0);
    	rightMotor.enableControl();
    	drive(speedModifier*gamepad.getY(), speedModifier*gamepad.getRawAxis(3));
    }
    
    public void moveAhead(int count){
    	leftMotor.setVoltageRampRate(2);
    	rightMotor.setVoltageRampRate(2);
    	leftMotor.changeControlMode(TalonControlMode.Position);
    	leftMotor.setPID(0.06, 0.0, 0.0);
    	leftMotor.enableControl();
    	leftMotor.reverseOutput(true);
    	rightMotor.reverseOutput(false);
    	rightMotor.changeControlMode(TalonControlMode.Position);
    	rightMotor.setPID(0.06, 0.0, 0.0);
    	rightMotor.enableControl();
    	rightMotor.set(count);
    	leftMotor.set(count);
    	
    }
    public void turnRight(int count){
    	leftMotor.setVoltageRampRate(2);
    	leftMotor.changeControlMode(TalonControlMode.Position);
    	leftMotor.setPID(0.06, 0.0, 0.0);
    	leftMotor.enableControl();
    	leftMotor.reverseOutput(true);
    	leftMotor.set(count);
    }
    
    public void turnLeft(int count) {
    	rightMotor.setVoltageRampRate(2);
    	rightMotor.changeControlMode(TalonControlMode.Position);
    	rightMotor.setPID(0.06, 0.0, 0.0);
    	rightMotor.enableControl();
    	rightMotor.reverseOutput(false);
    	rightMotor.set(count);
    }
    
    public void stop() {
    	this.drive(0.0, 0.0);
    }
    
    /**
     * Reset the robots sensors to the zero states.
     */
    public void reset(){
    	leftMotor.setEncPosition(0);
    	rightMotor.setEncPosition(0);
    	leftMotor.setPosition(0.0);
    	rightMotor.setPosition(0.0);
    }
    
    /**
     *   This is a modifier to change the rate of the gamepad inputs.
     */
    public void modifySpeed(double newSpeed){
    	this.speedModifier = newSpeed;
    }
}


