package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class wench extends Subsystem {
    private static Spark wenchMotor;
    private static DigitalInput limit;
    private double wenchSpeed;
    
    public wench() {
    	 super();
         wenchMotor = new Spark(1);
         limit = new DigitalInput(1);
         wenchSpeed = 0.8;
     }
    
    
    public void initDefaultCommand() {}
        
    public void windIn() {
    	wenchMotor.set(wenchSpeed);
    }
    
    public void windOut() {
    	wenchMotor.set(-wenchSpeed);
    }
    
    public void wenchStop() {
    	wenchMotor.set(0);
    }
    
    public boolean atLimit() {
    	return limit.get();
    }
}

