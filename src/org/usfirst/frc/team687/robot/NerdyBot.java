package org.usfirst.frc.team687.robot;

import com.kauailabs.nav6.frc.IMUAdvanced;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TalonSRX;

public class NerdyBot {
	public static IMUAdvanced imu;
	private static TalonSRX ftLeft, ftRight, bkLeft, bkRight;
	
	public static void init()	{
		imu = new IMUAdvanced(new SerialPort(57600,SerialPort.Port.kMXP));
		ftLeft = new TalonSRX(2);
    	ftRight = new TalonSRX(3);
    	bkLeft = new TalonSRX(4);
    	bkRight = new TalonSRX(5);
	}
	
	
	/**
	 * @param input {ftLeft, ftRight, bkLeft, bkRight}
	 */
	public static void drive(double[] input)	{
		ftLeft.set(input[0]);
        ftRight.set(input[1]);
        bkLeft.set(input[2]);
        bkRight.set(input[3]);
	}
	
	public static void drive(double fl, double fr, double bl, double br)	{
		ftLeft.set(fl);
        ftRight.set(fr);
        bkLeft.set(bl);
        bkRight.set(br);
	}
}
