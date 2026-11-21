package Test;
import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.Shape;

public class BandConveyer extends Area {

    public BandConveyer(String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
			float[] dashpattern, int height, int width, ArrayList<Robot> robots,int speed,boolean direction, boolean state, int commande) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width, robots);
		this.speed = speed;
        this.direction = direction;
        this.state = state;
        this.commande = commande;
        this.recu = 0;
        this.pucks = new ArrayList<Puck>();
	}

	private  int speed;
    private boolean direction;
    private boolean state;
    private final int commande;
    private int recu;
    private ArrayList<Puck> pucks;
    
    //On considère que le Conveyer envoie les pucks vers l'extérieurs
    // il devrait faire glisser les pucks mais ici il se contente de les récupérer
 



    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;

    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;

    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;

    }

@Override
public String toString() {
    return "BandConveyer [name=" + getName() + "]";
}
@Override
public Shape getShape() {
	return new RectangleShapeImpl(getWidth(), getHeight());
}

@Override
public void action() {
	for (Robot elem : this.robots) {
		if (this.recu < this.commande) {
			if (!elem.getLoad().isEmpty()) {
				this.pucks.add(elem.getLoad().get(elem.getLoad().size()-1));
				elem.getLoad().get(elem.getLoad().size()-1).setxCoordinate(this.getxCoordinate());
				elem.getLoad().get(elem.getLoad().size()-1).setyCoordinate(this.getyCoordinate());
				elem.removePuck();
			}
		}
	}

	if (this.pucks != null) {
		for (Puck e : this.pucks) {
			if ((isDirection()==true) && ((Math.abs(e.getxCoordinate()-this.getxCoordinate())<100)) ) {
				e.setxCoordinate(e.getxCoordinate()+ this.speed);
			}
			if ((isDirection()==false) && ((Math.abs(e.getyCoordinate()-this.getyCoordinate())<50))) {
				e.setyCoordinate(e.getyCoordinate()+ this.speed);
			}
		}
	}
	
}
}