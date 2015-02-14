package org.usfirst.frc.team687.util;

import org.usfirst.frc.team687.articulation.NerdyArtic;
import org.usfirst.frc.team687.autonomous.NerdyAutonomous;

import edu.wpi.first.wpilibj.RobotState;

public class NerdyThread extends Thread {
	private Thread t;
	private String name;
	private int mode = 0;
	
	public NerdyThread(String threadName, int m)	{
		name = threadName;
		mode = m;
	}
	
	public void run()	{
		switch (mode)	{
		
		case 0:
			NerdyAutonomous.run();
			break;
			
		case 1:
			while(RobotState.isEnabled())	{
				NerdyArtic.run();
			}
			while(!RobotState.isEnabled())	{}
			this.run();
			break;
		}
	}
	
	public void start()	{
		if(t == null)	{
			t = new Thread(this, name);
			t.start();
		}
	}
	
	public void interrupt()	{
		t.interrupt();
	}
}
