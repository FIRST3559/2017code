package org.usfirst.frc.team3559.robot;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team3559.robot.commands.*;

public class OI {
	
	private Joystick gamepad = new Joystick(0);
	Button greenA = new JoystickButton(gamepad, 1);
	Button redB = new JoystickButton(gamepad, 2);
	Button lBumper = new JoystickButton(gamepad, 5);
	Button rBumper = new JoystickButton(gamepad, 6);
	Button lTrigger = new JoystickButton(gamepad, 7);
	Button rTrigger = new JoystickButton(gamepad, 8);
	Button back = new JoystickButton(gamepad, 9);
	Button start = new JoystickButton(gamepad, 10);
	
	public OI() {
		lBumper.whileHeld(new ClimbUp());
		rBumper.whileHeld(new ClimbDown());
		lTrigger.whileHeld(new CollectFuel());
		rTrigger.whileHeld(new ShootFuel());
		greenA.whileHeld(new dropScoop());
		redB.whileHeld(new raiseScoop());
		back.whileHeld(new UnloadFuel());
		start.whileHeld(new ReverseShooter());
		
	}
	
	public Joystick getJoystick() {
		return gamepad;
	}
	
	
}
