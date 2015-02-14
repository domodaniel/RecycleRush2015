package org.usfirst.frc.team687.articulation;

public class NerdyArtic {
	private static double power;
	private static double height;
	private final static double inches = 12.5;
	private static int desiredLevel;
	private static int level;
	private static boolean[] hallSensor;
	private static long time;
	
	public static void setHeight(double h, long t)	{
		height = h;
		NerdyArticPID.setHeight(height);
		time = t;
	}
	
	public static double getHeight()	{
		return height;
	}
	
	public static double getLevel()	{
		double i = height/inches;
		level = (int) Math.floor(i);
		return level;
	}
	
	public static boolean isDone()	{
		if(Math.abs(height - (desiredLevel * inches)) < .05)	{
			return true;
		}
		return false;
	}
	
	public static void set(int l)	{
		NerdyArticPID.pid(l);
		desiredLevel = l;
		NerdyArticPID.resetIntegration();
	}
	
	public static int getDesiredLevel()	{
		return desiredLevel;
	}
	
	public static void setHallSensors(boolean[] input)	{
		hallSensor = input;
	}
	
	public static void run()	{
		NerdyArticPID.setError(desiredLevel * height, time);
		NerdyArticPID.pid(desiredLevel);
		if(isDone())	{
			power = 0;
		}	else	{
			power = NerdyArticPID.getPower();
		}
	}
		
	public static double getPower()	{
		if(!hallSensor[desiredLevel])	{
			return power;
		}	else	{
			return 0;
		}
	}
}
