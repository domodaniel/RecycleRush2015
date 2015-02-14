package org.usfirst.frc.team687.articulation;

public class NerdyArtic {
	private static double power;
	private static double height;
	private final static double inches = 12.5;
	private static int desiredLevel;
	private static int level;
	private static boolean[] hallSensor;
	
	public static void setHeight(double h)	{
		height = h;
		NerdyArticPID.setHeight(height);
	}
	
	public static double getHeight()	{
		return height;
	}
	
	public static double getLevel()	{
		double i = height/inches;
		level = (int) Math.floor(i);
		return level;
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
		NerdyArticPID.pid(desiredLevel);
		power = NerdyArticPID.getPower();
	}
	
	public static double getPower()	{
		if(!hallSensor[desiredLevel])	{
			return power;
		}	else	{
			return 0;
		}
	}
}
