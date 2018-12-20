/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2586.robot;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	WPI_TalonSRX left;
	WPI_TalonSRX right;
	String[] motorVals;
	Scanner scan;
	File input;
	int tickNumber = 0;


	public void robotInit() {
		try {
		input = new File("/home/lvuser/autoScripts/OUTPUT.txt");
		left = new WPI_TalonSRX(3);
		right = new WPI_TalonSRX(5);
		scan = new Scanner(input);
		motorVals = new String[1000];
		
		for(int i = 0; i<250; i++) {
		motorVals[i] = scan.nextLine();
		}
		}catch(IOException e) {
			
		}

	}

	public void autonomousInit() {

	}

	public void autonomousPeriodic() {

	}

	public void teleopPeriodic() {
		left.set(Float.parseFloat(motorVals[tickNumber]));
		right.set(Float.parseFloat(motorVals[tickNumber]));
		tickNumber++;
	}

	public void testPeriodic() {
		
	}
}
