package org.usfirst.frc.team687.util;

public class NerdyIntegrator {
	private double kI = 0;
	private double error = 0, lastError = 0;
	private long time = 0, lastTime = -9001;
	private double integration = 0;
	
	
	public NerdyIntegrator(double i)	{
		kI = i;
	}
	
	public void setError(double e, long t)	{
		lastError = error;
		error = e;
		if(lastTime < 0)	{
			lastTime = t;
		}	else	{
			lastTime = time;
		}
		time = t;
	}
	
	public void perform()	{
		integration += ((error + lastError)/2)*.02;
	}
	
	public void reset()	{
		integration = 0;
	}
	
	public double getI()	{
		return kI*integration;
	}
}
