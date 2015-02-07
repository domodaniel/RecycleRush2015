package org.usfirst.frc.team687.articulation;

public class NerdyArtic {
	private static double power;
	private static double height;
	private static double level;
	
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
	
	public static double getLevel()	{
		return level;
	}
	
	public static double getPower()	{
		return NerdyArticPID.getPower();
	}
}
