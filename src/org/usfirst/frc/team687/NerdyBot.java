package org.usfirst.frc.team687;

import org.usfirst.frc.team687.articulation.NerdyArtic;
import org.usfirst.frc.team687.articulation.NerdyHallSensor;
import org.usfirst.frc.team687.autonomous.NerdyUltrasonic;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;

public class NerdyBot {
	public static IMUAdvanced imu;
	//drive base
	private static VictorSP ftLeft, ftRight, bkLeft, bkRight;
	private static double fl, fr, bl, br;
	//articulation
	private static TalonSRX articulation;
	public static NerdyHallSensor hallSensors;
	public static NerdyUltrasonic ping;
	
	private static double articPower = 0;
	private static boolean articOverride = false;
	
	public static void init()	{
		imu = new IMUAdvanced(new SerialPort(57600,SerialPort.Port.kMXP));
		//drive base
		ftLeft = new VictorSP(2);
    	ftRight = new VictorSP(3);
    	bkLeft = new VictorSP(4);
    	bkRight = new VictorSP(5);
    	//articulation
    	articulation = new TalonSRX(6);
    	int[] i = {0,1,2,3,4};
    	hallSensors = new NerdyHallSensor(i);
    	ping = new NerdyUltrasonic(0,1);
	}
	
	
	/**
	 * @param input {ftLeft, ftRight, bkLeft, bkRight}
	 */
	public static void drive(double[] input)	{
		fl = input[0];
        fr = input[1];
        bl = input[2];
        br = input[3];
	}
	
	public static void drive(double ftl, double ftr, double bkl, double bkr)	{
		fl = ftl;
        fr = ftr;
        bl = bkl;
        br = bkr;
	}
	
	//articulation
	public static void setArticLevel(int level)	{
		if(level != NerdyArtic.getLevel() && !articOverride)	{
			NerdyArtic.set(level);
			articPower = NerdyArtic.getPower();
		}
	}
	
	public static void setArticOverride(double power)	{
		if(power != 0)	{
			articOverride = true;
			articPower = power;
		}	else	{
			articOverride = false;
		}
	}
	
	//general maintenance
	public static void run()	{
		NerdyArtic.setHallSensors(hallSensors.outputs());
		ftLeft.set(fl);
		ftRight.set(fr);
		bkLeft.set(bl);
		bkRight.set(br);
		articulation.set(articPower);
	}
}
