package org.usfirst.frc.team687.articulation;

public class NerdyArtic {
	private static double power;
	private static double height;
	private static int level;
	private static boolean[] hallSensor;
	
	public static void setHeight(double h)	{
		height = h;
		NerdyArticPID.setHeight(height);
	}
	
	public static double getHeight()	{
		return height;
	}
	
	public static void set(int l)	{
		NerdyArticPID.pid(l);
		level = l;
	}
	
	public static int getLevel()	{
		return level;
	}
	
	public static void setHallSensors(boolean[] input)	{
		hallSensor = input;
	}
	
	public static double getPower()	{
		if(!hallSensor[level])	{
			return power;
		}	else	{
			return 0;
		}
	}
}
