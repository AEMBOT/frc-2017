package org.usfirst.frc.falcons6443.robot.hardware;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;

/**
 * A Maxbotix I2C Ultrasonic Rangefinder Device.
 * Part No.: <a href="http://www.maxbotix.com/Ultrasonic_Sensors/MB1222.htm"> MB1222
I2CXL-MaxSonar-EZ2</a>
 * @author Patrick Higgins
 *
 */
public class UltrasonicSensor extends I2C {

	private int deviceAddress; //deviceAddress = write register, deviceAddress + 1 = read register
	private PIDSourceType pidSourceType;

	/**
	 * Initializes a new Ultrasonic Sensor via the onboard I2C bus.
	 * Before initializing sensors on a bus, it is highly recommended that you set each address individually.
	 * @param deviceAddress the address location of the sensor on the bus. Default address is 224.
	 */
	public UltrasonicSensor (int deviceAddress) {
		
		//to initialize via navx bus, replace kOnboard with kMXP
		super(Port.kOnboard, deviceAddress);
		
		pidSourceType = PIDSourceType.kDisplacement;
		this.deviceAddress = deviceAddress;
	}
	
	public void ping () {
		//command the sensor to measure range
		write(deviceAddress, 81);
		Timer.delay(1);
	}
	
	public int readLow () {
		byte[] buffer = new byte[1]; 

		//read the first byte from the sensor, range-low
		read(deviceAddress + 1, 1, buffer);
		return buffer[0];
	}
	
	public String read (boolean somethung) {
        byte[] buffer = new byte[2];

        //read the two bytes from the sensor, range-low and range-high
        read(deviceAddress + 1, 2, buffer);

        Byte lowByte = new Byte(buffer[1]);
        Byte highByte = new Byte(buffer[0]);
        String combinedBytes = highByte.toString().concat(lowByte.toString());

        return String.format("%16s", Integer.toBinaryString((short) ((highByte << 9) | (lowByte)) & 0xFFFF)).replace(' ', '0');
        //return Byte.valueOf(combinedBytes);
	}

	public double read() {
		return 0;
	}
//	public double readInches () {
//		//multiply return by cm:inch ratio
//		return read() * 0.393700787402;
//	}
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
