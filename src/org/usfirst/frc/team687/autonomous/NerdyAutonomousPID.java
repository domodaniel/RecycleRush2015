package org.usfirst.frc.team687.autonomous;

import org.usfirst.frc.team687.util.NerdyIntegrator;

public class NerdyAutonomousPID {
	private static double desired = 0;
	private final static double kP = 0.16, kI = 0.0016;
	private static double distance = 0, error;
	private static double tolerance = 4;
	private static NerdyIntegrator integrator;
	private static boolean ini = false;
	private static double pid = 0;
	
	public static void init()	{
		integrator = new NerdyIntegrator(kI);
		ini = true;
	}
	
	public static void setTolerance(double t)	{
		tolerance = t;
	}
	
	public static void setDistance(double d)	{
		distance = d;
	}
	
	public static void setDesired(double d)	{
		desired = d;
	}
	
	public static void resetIntegration()	{
		integrator.reset();
	}
	
	public static void preformDistanceFrom()	{
		if(!ini)	{
			init();
		}
		
		error = desired-distance;
		double p = kP * error;
		integrator.setError(error);
		integrator.perform();
		double i = integrator.getI();
		pid = (p+i);
	}
	
	public static void preformDistanceTo()	{
		
	}
	
	public static double getPID()	{
		return pid;
	}
}
