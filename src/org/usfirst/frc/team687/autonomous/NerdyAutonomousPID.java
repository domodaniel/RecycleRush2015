package org.usfirst.frc.team687.autonomous;

import org.usfirst.frc.team687.util.NerdyIntegrator;

public class NerdyAutonomousPID {
	private static double desired = 0;
	private final static double kP = 0.16, kI = 0.0016;
	private static double distance = 0, error;
	private static NerdyIntegrator integrator;
	private static boolean ini = false;
	private static double pid = 0;
	private static long time;
	
	public static void init()	{
		integrator = new NerdyIntegrator(kI);
		ini = true;
	}
	
	public static void setDistance(double d, long t)	{
		distance = d;
		time = t;
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
		integrator.setError(error, time);
		integrator.perform();
		double i = integrator.getI();
		pid = (p+i);
	}
	
	public static void preformDistanceTo()	{
		if(!ini)	{
			init();
		}
		
		error = distance - desired;
		double p = kP * error;
		integrator.setError(error, time);
		integrator.perform();
		double i = integrator.getI();
		pid = (p+i);
	}
	
	public static double getPID()	{
		return pid;
	}
}
