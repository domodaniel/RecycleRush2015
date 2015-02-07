package org.usfirst.frc.team687.autonomous;
import org.usfirst.frc.team687.util.USB_FileReader;

public class NerdyAutonomous {
	USB_FileReader fr;
	private static int mode = 1;
	private static String fileName;
	private static boolean init = false;
	
	private static double ftLeft = 0, ftRight = 0, bkLeft = 0, bkRight = 0;
	private static double degrees, distance;
	
	/**
	 * @param modeNumber Finish This Comment Later
	 */
	public static void setMode(int modeNumber)	{
		mode = modeNumber;
	}
	
	private static void file()	{
		switch(mode)	{
			
			
			default:
				fileName = "none.csv";
				break;
		}
		
		init = true;
	}
	
	public static void run()	{
		if(!init)	{
			file();
		}
		
	}
	
	public static void setDegrees(double degree)	{
		degrees = degree;
	}
	
	public static void setDistance(double d)	{
		distance = d;
	}
	
	public static double[] getDrives()	{
		double[] output = {ftLeft, ftRight, bkLeft, bkRight};
		return output;
	}
}
