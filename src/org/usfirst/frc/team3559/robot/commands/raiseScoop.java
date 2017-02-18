package org.usfirst.frc.team3559.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3559.robot.Robot;

/**
 *
 */
public class raiseScoop extends Command {

    public raiseScoop() {
        requires(Robot.scoop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.scoop.raiseScoop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.scoop.stopScoop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
