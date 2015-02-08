package org.usfirst.frc.team687;

import org.usfirst.frc.team687.articulation.NerdyArtic;
import org.usfirst.frc.team687.articulation.NerdyHallSensor;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TalonSRX;

public class NerdyBot {
	public static IMUAdvanced imu;
	//drive base
	private static TalonSRX ftLeft, ftRight, bkLeft, bkRight;
	//articulation
	private static TalonSRX articulation;
	public static NerdyHallSensor hallSensors;
	
	public static void init()	{
		imu = new IMUAdvanced(new SerialPort(57600,SerialPort.Port.kMXP));
		//drive base
		ftLeft = new TalonSRX(2);
    	ftRight = new TalonSRX(3);
    	bkLeft = new TalonSRX(4);
    	bkRight = new TalonSRX(5);
    	//articulation
    	articulation = new TalonSRX(6);
    	int[] i = {0,1,2,3,4};
    	hallSensors = new NerdyHallSensor(i);
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
	
	//articulation
	public static void setArtic(int level)	{
		if(level != NerdyArtic.getLevel())	{
			NerdyArtic.set(level);
			articulation.set(NerdyArtic.getPower());
		}
	}
	
	//general maintenance
	public static void update()	{
		NerdyArtic.setHallSensors(hallSensors.outputs());
	}
}
