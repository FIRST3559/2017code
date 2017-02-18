package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class fuelLoader extends Subsystem {
	private static Spark feedMotor = new Spark(2);
    private double feedSpeed = 0.7;

    public fuelLoader() {
    super();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intake() {
    	feedMotor.set(feedSpeed);
    }
    
    public void reverse() {
    	feedMotor.set(-feedSpeed);
    }
    
    public void stop() {
    	feedMotor.set(0.0);
    }
}

