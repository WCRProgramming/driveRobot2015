
package org.usfirst.frc.team5492.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
    RobotDrive chassis;
    Joystick leftStick;
    Joystick rightStick;

    public Robot() {
        chassis = new RobotDrive(0, 1);
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
    }

    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
    }

    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
        chassis.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	//Right Handed
        	double speedControl = 1;
        	
        	double gamepadLeftY = leftStick.getRawAxis(2)*speedControl; //get left gamepad control for acceleration
        	double gamepadXBOXLeftY = leftStick.getRawAxis(1)*speedControl;
        	double gamepadRightX = leftStick.getRawAxis(4)*-1*speedControl; //get right gamepad control for driving
        	double gamepadTrigger = leftStick.getRawAxis(5)*speedControl;//get gamepad trigger for acceleration
        	double gamepadXBOXTrigger = (leftStick.getRawAxis(2)-leftStick.getRawAxis(3))*speedControl;
        	double joystickLeftY = leftStick.getY()*speedControl; //get left joystick y axis for acceleration
        	double joystickLeftX = leftStick.getX()*-1*speedControl; //get left joystick x for driving
        	double joystickRightX = rightStick.getX()*-1*speedControl; //get right joystick x axis for driving
        				//A Challenger Approaches!\\
        	/*-----------------Tank Drive-----------------*/
        	//chassis.tankDrive(leftStick, rightStick, true); //use two joysticks to TANK drive
        	/*------------Arcade Drive Gamepad------------*/
        	//chassis.arcadeDrive(gamepadXBOXLeftY, gamepadRightX, true); //use gamepad to ARCADE drive with joysticks
        	/*------------Arcade Drive XBOX Gamepad------------*/
        	//chassis.arcadeDrive(gamepadLeftY, gamepadRightX, true); //use gamepad to ARCADE drive with joysticks
        	/*-----Arcade Drive Gamepad with Trigger------*/
        	chassis.arcadeDrive(gamepadXBOXTrigger, gamepadRightX, true); //use gamepad to ARCADE drive with right joystick & trigger
        	/*--------Arcade Drive Two Joystick(s)--------*/
        	//chassis.arcadeDrive(joystickLeftY, joystickRightX, true); //use two joysticks to ARCADE drive
        	/*--------Arcade Drive One Joystick(s)--------*/
        	//chassis.arcadeDrive(joystickLeftY, joystickLeftX, true); //use left joystick to ARCADE drive
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
