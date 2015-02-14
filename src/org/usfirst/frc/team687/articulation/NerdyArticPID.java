package org.usfirst.frc.team687.articulation;

import org.usfirst.frc.team687.util.NerdyIntegrator;

public class NerdyArticPID {
	private static NerdyIntegrator integrator;
	private static boolean ini = false;
	private final static double kP = 0.1, kI = 0.01, kD = 0;
	private final static double inches = 5;
	private static double height = 0;
	private static double power = 0;
	private static double error = 0, prevError = 0;
	private static long time = 0;
	
	public static void init()	{
		integrator = new NerdyIntegrator(kI);
		ini = true;
	}
	
	public static void setHeight(double h)	{
		height = h;
	}
	
	public static void setError(double e, long t)	{
		error = e;
		time = t;
	}
	
	public static void pid(int level)	{
		if(!ini)	{
			init();
		}
		double desired = level * inches;
		prevError = error;
		error = desired-height;
		double p = kP * error;
		integrator.setError(error, time);
		integrator.perform();
		double i = integrator.getI();
		double d = kD * (error - prevError);
		power = (p+i+d);
	}
	
	public static double getPower()	{
		return power;
	}
	
	public static void resetIntegration()	{
		integrator.reset();
	}
}
