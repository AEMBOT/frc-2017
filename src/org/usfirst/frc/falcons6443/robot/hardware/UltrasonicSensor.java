package org.usfirst.frc.falcons6443.robot.hardware;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class UltrasonicSensor extends I2C {

	private int deviceAddress; //deviceAddress = write register, deviceAddress + 1 = read register
	private PIDSourceType pidSourceType;

	public UltrasonicSensor (int deviceAddress) {
		super(Port.kOnboard, deviceAddress);
		pidSourceType = PIDSourceType.kDisplacement;
		this.deviceAddress = deviceAddress;
	}
	
	public void ping () {
		//command the sensor to measure range
		write(deviceAddress, 81);
	}
	
	public int readLow () {
		byte[] buffer = new byte[1]; 

		//read the first byte from the sensor, range-low
		read(deviceAddress + 1, 1, buffer);
		return buffer[0];
	}
	
	public double read () {
		byte[] buffer = new byte[2];

		//read the two bytes from the sensor, range-low and range-high
		read(deviceAddress + 1, 2, buffer);
		return averagedRange(buffer);
	}
	
	private double averagedRange (byte[] values) {
		double average;
		
		if (values.length < 2) {
			average = values[0];
		}
		
		else {
			average = (values[0] + values[1]) / 2;
		}
		
		return average;
	}
}
