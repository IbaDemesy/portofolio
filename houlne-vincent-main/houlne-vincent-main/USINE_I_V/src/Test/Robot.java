package Test;

import java.util.ArrayList;
import fr.tp.inf112.projects.canvas.model.Shape;

public class Robot extends MobileComponent {
    public Robot(String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
			float[] dashpattern, int height, int width,int speed, int battery,ArrayList<Puck> load,ArrayList<Component> visits) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
		this.speed = speed;
		this.battery= battery;
		this.load = load;
		this.visits = visits;
		this.memory = 0;
		
	}
    private boolean charge;
	private int speed;
    private int battery;
    private ArrayList<Puck> load;
    private ArrayList<Component> visits;


@Override
public String toString() {
    return "Robot [name=" + getName() + "]";
}

public void move(Component component){
	//System.out.println(load.get(0).getxCoordinate());
	int xc=component.getxCoordinate();
	int yc=component.getyCoordinate();
	int xl = this.getxCoordinate();
	int yl=this.getyCoordinate();
	if (xc!= xl ){
		if(Math.abs(xc-xl)<=this.getSpeed()) {
			this.setxCoordinate(xc);}
		else {
			int val = getxCoordinate() + Integer.signum(xc-xl)*this.getSpeed();
			this.setxCoordinate(val);
			
		}
	}
	else {
		if(Math.abs(yc-yl)<=this.getSpeed()) {
			this.setyCoordinate(yc);}
		else {
			this.setyCoordinate(getyCoordinate() + Integer.signum(yc-yl)*this.getSpeed());
		}
	}
	
}

	
	




@Override
public Shape getShape() {
	return new OvalShapeImpl(getWidth(), getHeight());
}

public int getSpeed() {
	return speed;
}



public void setSpeed(int speed) {
	getFactory().notifyObservers();
	this.speed = speed;
}



public int getBattery() {
	return battery;
}



public void setBattery(int battery) {
	getFactory().notifyObservers();
	this.battery = battery;
}



public ArrayList<Puck> getLoad() {
	return load;
}

public void addPuck(Puck puck) {
	getFactory().notifyObservers();
	load.add(puck);
	puck.setPorteur(this);
}
public void removePuck() {
	if (load.isEmpty()==false) {
		load.get(load.size()-1).setPorteur(null);
		load.remove(load.size()-1);	}
}

private int memory;

public void behave() {
	
	if (this.isCharge()==false) {
		if (this.getMemory()> this.getVisits().size()-1) {
			this.setMemory(0);
		}
	
		Component obj = this.getVisits().get(this.getMemory());
		if ((this.getxCoordinate()==obj.getxCoordinate()) && (this.getyCoordinate()==obj.getyCoordinate())) {
			if (this.getMemory() != this.getLoad().size()-1) {
				this.setMemory(this.getMemory()+1);
			}
			else {
				this.setMemory(0);
			}
		}
		else {
			this.move(obj);
			this.setBattery(this.getBattery()-50);
			//actuellement, un robot peut avoir une charge négative sahcnt que le max est 1000
		}
	}
	
	
}

public ArrayList<Component> getVisits() {
	return visits;
}

public void setVisits(ArrayList<Component> visits) {
	this.visits = visits;
}
public void addVisits(Component visit) {
	this.visits.add(visit);
}

public int getMemory() {
	return memory;
}

public void setMemory(int memory) {
	this.memory = memory;
}

public boolean isCharge() {
	return charge;
}

public void setCharge(boolean charge) {
	this.charge = charge;
}



}