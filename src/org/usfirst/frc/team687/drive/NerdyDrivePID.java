package org.usfirst.frc.team687.drive;

import org.usfirst.frc.team687.util.NerdyIntegrator;


/**
 *
 * @author Wesley
 */
public class NerdyDrivePID {
	private static NerdyIntegrator integrator;
    private static double kP = 0.00444444;
    private static double heading = 0;
    private static double error = 0;
    private static double tolerance = 2;
    private static boolean init = false;
    private static long time;
    
    public static void setTolerance(double t)   {
        tolerance = t;
    }
    
    public static void setHeading(double head, long t)   {
        heading = (head+360.0)%360;
        time = t;
    }
    
    public static void setKP(double p)  {
        kP = p;
    }
    
    private static double shortestRotation(double desired)  {
        double e = heading - desired;
        if(e > 180)    {
            e = -(Math.abs(360 - e)%180);
        }   else if(e < -180)   {
            e = Math.abs(360 + e)%180;
        }
        
        return e;
    }
    
    public static double getPID(double desired) {
    	if(!init)	{
    	    integrator = new NerdyIntegrator(0.0000444444);
    	    init = true;
    	}
        error = shortestRotation(desired);
        double p = error * kP;
        integrator.setError(error, time);
        integrator.perform();
        double i = integrator.getI();
        
        if(Math.abs(error) < tolerance)   {
            return 0;
        }   else    {
            return p + i;
        }
    }
}

