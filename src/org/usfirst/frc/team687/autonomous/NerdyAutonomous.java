package org.usfirst.frc.team687.autonomous;
import java.io.IOException;

import org.usfirst.frc.team687.util.USB_FileReader;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NerdyAutonomous {
	private static USB_FileReader fr;
	private static int mode = 0;
	private static String fileName;
	private static boolean ini = false;
	
	private static double[][] file;
	
	private static double ftLeft = 0, ftRight = 0, bkLeft = 0, bkRight = 0;
	private static double degrees = 0, xpos = 0, ypos = 0;
	
	private static double[] action;
	private static boolean running = false;
	
	private static double ping = 0;
	
	
	/**
	 * @param modeNumber Finish This Comment Later
	 */
	public static void setMode(int modeNumber)	{
		mode = modeNumber;
	}
	//put in disabled
	public static void init()	{
		String dev = "/sdb1";
		if(!ini)	{
			USB_FileReader.setDefaultDir("/media");
			USB_FileReader.setDefaultMediaDevice(dev);
			USB_FileReader.setDefaultDelimiter("\t");
			fileName = "Autonomous" + mode + ".csv";
			
			try {
				fr = new USB_FileReader(fileName);
				ini = true;
				String[][] input = fr.read();
				for(int i = 0; i < input.length; i++)	{
					for(int j = 0; j < input[0].length; j++)	{
						file[i][j] = Double.parseDouble(input[i][j]);
					}
				}
				SmartDashboard.putString("Autonomous File Error: ", "No error");
			} catch (IOException e) {
				if(dev.equals("/sdb1"))	{
					dev = "/sda1";
				}	else if(dev.equals("/sda1"))	{
					dev = "/sdb1";
				}
				SmartDashboard.putString("Autonomous File Error: ", e.toString());
			}
		}
	}
	//use with a thread
	public static void run()	{
		if(!ini)	{
			init();
		}
		
	}
	
	public static void setPing(double p)	{
		ping = p;
	}
	
	public static void setDegrees(double degree)	{
		degrees = degree;
	}
	
	public static double[] getDrives()	{
		double[] output = {ftLeft, ftRight, bkLeft, bkRight};
		return output;
	}
}
