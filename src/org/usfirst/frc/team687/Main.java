
package org.usfirst.frc.team687;

import org.usfirst.frc.team687.autonomous.NerdyAutonomous;
import org.usfirst.frc.team687.drive.NerdyDrive;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Joystick leftJoy, rightJoy;
	NerdyArticJoystick articJoy;
	
	//imu calibration
	boolean calibrated = false;
	
	public void disabledPeriodic()	{
		boolean is_calibrating = NerdyBot.imu.isCalibrating();
        if ( !calibrated && !is_calibrating ) {
            Timer.delay( 0.3 );
            NerdyBot.imu.zeroYaw();
            calibrated = true;
        }
	}
	
    public void robotInit() {
    	leftJoy = new Joystick(0);
    	rightJoy = new Joystick(1);
    	articJoy = new NerdyArticJoystick(2);
    	NerdyBot.init();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	NerdyAutonomous.setPing(NerdyBot.ping.get());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	NerdyBot.update();
    	//Start Drive Section
    	NerdyDrive.setHeader(NerdyBot.imu.getYaw());
        boolean beta = rightJoy.getRawButton(4);
        if(beta)	{
        	NerdyDrive.driveBeta(leftJoy.getX(), leftJoy.getY(), rightJoy.getX(), rightJoy.getY());
        }	else	{
        	NerdyDrive.driveAlpha(leftJoy.getX(), leftJoy.getY(), rightJoy.getX());
        }
        
        NerdyBot.drive(NerdyDrive.getDrive());
        //End Drive Section
        
        //Start Artic Section
        NerdyBot.setArtic(articJoy.getLevel());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
}
