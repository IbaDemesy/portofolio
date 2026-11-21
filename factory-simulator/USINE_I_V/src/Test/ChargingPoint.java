package Test;

import java.util.ArrayList;

public class ChargingPoint extends Area {
    public ChargingPoint(String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
			float[] dashpattern, int height, int width, ArrayList<Robot> robots, boolean occupied,int chargingRate) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width, robots);
		// TODO Auto-generated constructor stub
		this.occupied =occupied;
		this.chargingRate = chargingRate;
	}


	private boolean occupied;
	private final int chargingRate;



    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;

    }


    @Override
    public String toString() {
        return "ChargingPoint [name=" + getName() + ", x=" + getxCoordinate() + ", y=" + getyCoordinate() + ", occupied=" + occupied + "]";
    }

	@Override
	public void action() {
		//la station ne peut charger qu'un robot à la fois
		if (!robots.isEmpty()) {
			Robot robotcharge = robots.get(0);
			if (robotcharge.getBattery()< 1000- this.chargingRate) {
				if (robotcharge.getBattery()< 700) {
					robotcharge.setCharge(true);
				}
				else {
					robotcharge.setCharge(false);
					}
				
				robotcharge.setBattery(robotcharge.getBattery() + this.chargingRate );
			}
			
		}
		getFactory().notifyObservers();		
	}
    
    
}
