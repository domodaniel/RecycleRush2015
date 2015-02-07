package org.usfirst.frc.team687.articulation;

import edu.wpi.first.wpilibj.DigitalInput;

public class NerdyHallSensor {
	DigitalInput[] sensors;
	public NerdyHallSensor(int[] channels) {
		sensors = new DigitalInput[channels.length];
		for(int i = 0; i < channels.length; i++)	{
			sensors[i] = new DigitalInput(channels[i]);
		}
	}
	
	public boolean getOutput(int i)	{
		return sensors[i].get();
	}
	
	public boolean[] outputs()	{
		boolean[] out = new boolean[sensors.length];
		for(int i = 0; i < sensors.length; i++)	{
			out[i] = sensors[i].get();
		}
		return out;
	}
}
