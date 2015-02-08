package org.usfirst.frc.team687.util;

import org.usfirst.frc.team687.autonomous.NerdyAutonomous;

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
		}
	}
	
	public void start()	{
		if(t == null)	{
			t = new Thread(this, name);
			t.start();
		}
	}
}
