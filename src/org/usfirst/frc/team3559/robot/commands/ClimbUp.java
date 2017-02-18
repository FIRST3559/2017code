package org.usfirst.frc.team3559.robot.commands;

import org.usfirst.frc.team3559.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *	ClimbUp is a command to windIn the rope around the wench.
 *	by
 *	Fred Routson
 *	Feb 14, 2017
 */
public class ClimbUp extends Command {

    public ClimbUp() {
    	requires(Robot.wench);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.wench.atLimit()==false){
    		Robot.wench.windIn();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.wench.atLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.wench.wenchStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
