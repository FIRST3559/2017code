package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class Shooter extends Subsystem {
	private static Spark feedMotor = new Spark(2);
    private double feedSpeed = 0.7;

    public Shooter() {
    	super();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot() {
    	feedMotor.set(feedSpeed);
    }
    
    public void reverse() {
    	feedMotor.set(-0.2 * feedSpeed);
    }
    
    public void stop() {
    	feedMotor.set(0.0);
    }
}

