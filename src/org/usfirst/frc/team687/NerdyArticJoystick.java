package org.usfirst.frc.team687;

import edu.wpi.first.wpilibj.Joystick;

public class NerdyArticJoystick extends Joystick {
	int lastValue = 0;
	public NerdyArticJoystick(int port)	{
		super(port);
	}
	
	public int getLevel()	{
		if(getRawButton(0))	{
			lastValue = 0;
			return 0;
		}	else if(getRawButton(1))	{
			lastValue = 1;
			return 1;
		}	else if(getRawButton(2))	{
			lastValue = 2;
			return 2;
		}	else if(getRawButton(3))	{
			lastValue = 3;
			return 3;
		}	else if(getRawButton(4))	{
			lastValue = 4;
			return 4;
		}	else	{
			return lastValue;
		}
	}
}
