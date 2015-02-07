package org.usfirst.frc.team687.articulation;

public class NerdyArtic {
	private static double power;
	private static double height;
	private static int level;
	private static boolean[] hullSensor;
	
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
	
	public static void setHullSensors(boolean[] input)	{
		hullSensor = input;
	}
	
	public static double getPower()	{
		if(!hullSensor[level])	{
			return power;
		}	else	{
			return 0;
		}
	}
}
