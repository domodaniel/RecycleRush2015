package org.usfirst.frc.team687;

import org.usfirst.frc.team687.articulation.NerdyArtic;

import edu.wpi.first.wpilibj.Joystick;

public class NerdyArticJoystick extends Joystick {
	public NerdyArticJoystick(int port)	{
		super(port);
	}
	
	public int getLevel()	{
		if(getRawButton(0))	{
			return 0;
		}	else if(getRawButton(1))	{
			return 1;
		}	else if(getRawButton(2))	{
			return 2;
		}	else if(getRawButton(3))	{
			return 3;
		}	else if(getRawButton(4))	{
			return 4;
		}	else	{
			return NerdyArtic.getLevel();
		}
	}
}
