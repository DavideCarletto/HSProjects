package liceocuneo.robot;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public abstract class Sensore extends Componente {

	private PortaSensore porta;
	private SensorPort mioNxt;
	
	public PortaSensore getPorta() {
		return porta;

	}
	

	public SensorPort getMioNxt() {
		return mioNxt;
	}


	public Sensore (PortaSensore porta) {
		
		this.porta = porta;
		switch(porta) {
		case PORTA_S1:
			mioNxt = SensorPort.S1;
			break;
		case PORTA_S2:
			mioNxt = SensorPort.S2;
			break;
		case PORTA_S3:
			mioNxt = SensorPort.S3;
			break;
		case PORTA_S4:
			mioNxt = SensorPort.S4;
			break;
		}
	}
	
	
}
