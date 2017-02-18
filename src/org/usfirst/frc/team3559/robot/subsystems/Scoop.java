package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class Scoop extends Subsystem {
	private static Spark scoopMotor = new Spark(3);
    private double scoopSpeed = 0.4;

    public Scoop() {
    	super();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void dropScoop() {
    	scoopMotor.set(scoopSpeed);
    }
    
    public void raiseScoop() {
    	scoopMotor.set(-scoopSpeed);
    }
    
    public void stopScoop() {
    	scoopMotor.set(0.0);
    }
}

