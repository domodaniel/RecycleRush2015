package org.usfirst.frc.team687.autonomous;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;

public class NerdyUltrasonic extends Ultrasonic{

	public NerdyUltrasonic(int pingChannel, int echoChannel) {
		super(new DigitalOutput(pingChannel), new DigitalInput(echoChannel));
		setEnabled(true);
		setAutomaticMode(true);
	}
	
	public double get()	{
		return getRangeInches();
	}
}
