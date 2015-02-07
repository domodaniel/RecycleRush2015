package org.usfirst.frc.team687.articulation;

import org.usfirst.frc.team687.util.NerdyIntegrator;

public class NerdyArticPID {
	private static NerdyIntegrator integrator;
	private static boolean ini = false;
	private final static double kP = 0.1, kI = 0.01;
	private final static double inches = 5;
	private static double height = 0;
	private static double power = 0;
	
	public static void init()	{
		integrator = new NerdyIntegrator(kI);
		ini = true;
	}
	
	public static void setHeight(double h)	{
		height = h;
	}
	
	public static void pid(int level)	{
		if(!ini)	{
			init();
		}
		double desired = level * inches;
		double error = desired-height;
		double p = kP * error;
		integrator.setError(error);
		integrator.perform();
		double i = integrator.getI();
		power = (p+i);
	}
	
	public static double getPower()	{
		return power;
	}
}
