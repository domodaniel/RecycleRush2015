package org.usfirst.frc.team687.util;

public class NerdyIntegrator {
	private double kI = 0;
	private double error = 0, lastError = 0;
	private double integration = 0;
	
	
	public NerdyIntegrator(double i)	{
		kI = i;
	}
	
	public void setError(double e)	{
		lastError = error;
		error = e;
	}
	
	public void perform()	{
		integration += ((error + lastError)/2)*.02;
	}
	
	public double getI()	{
		return kI*integration;
	}
}
