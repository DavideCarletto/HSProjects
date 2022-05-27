package liceocuneo.robot;


import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class SensorePressione extends Sensore{

	TouchSensor sens ;
	
	public SensorePressione(PortaSensore porta) {
		super(porta);
		sens = new TouchSensor(getMioNxt());
		// TODO Auto-generated constructor stub
	}
	public boolean isPressed() {
		return sens.isPressed();
	}
	
}
	
