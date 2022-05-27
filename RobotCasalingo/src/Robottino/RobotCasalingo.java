package Robottino;
import java.util.Random;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import liceocuneo.robot.PortaSensore;
import liceocuneo.robot.SensorePressione;
import liceocuneo.robot.Trasmissione;
import liceocuneo.robot.VersoGiro;

public class RobotCasalingo implements SensorPortListener {

	private  Trasmissione t;
	DifferentialPilot pilota;
	private SensorePressione s= null;
	
	public RobotCasalingo() {
		s = new SensorePressione(PortaSensore.PORTA_S1);
		s.getMioNxt().addSensorPortListener(this);
	}
	public void gira() {
	
		t.avanti();
		long StartTime = System.currentTimeMillis();
		long elapsedTime =0;
		
		do {
			elapsedTime = System.currentTimeMillis()-StartTime;
			if(s.isPressed()==true) {
				t.stop();
				t.indietro(20);
				t.gira(VersoGiro.DESTRA, 900);
				t.avanti();
			}
		}while(elapsedTime<=300000);
	
		
	}
	     
	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		System.out.println(aOldValue+"-"+aNewValue);
		
	}
	
	public static void main (String []args) {
		
		RobotCasalingo tino = new RobotCasalingo();
		tino.pilota = new DifferentialPilot(2.25f, 2.25f, Motor.A, Motor.B);
		
		tino.gira();
		
	}

	
}
