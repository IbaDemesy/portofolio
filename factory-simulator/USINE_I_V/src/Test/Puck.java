package Test;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Shape;

public class Puck extends MobileComponent {



	

public Puck(String name, int x, int y, Color backgroundColor, Color colorstroke, float thickness,
			float[] dashpattern, int height, int width,Factory factory) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
		// TODO Auto-generated constructor stub
		this.setFactory(factory);
		this.getFactory().addPuck(this);
	}

private Robot porteur;

@Override
public String toString() {
    return "Puck [name=" + getName() + "]";
}

@Override
public Shape getShape() {
	// TODO Auto-generated method stub
	return new OvalShapeImpl(getWidth(),getHeight());
}

@Override
public void behave() {
	if (havePorteur()) {
		this.setxCoordinate(this.getPorteur().getxCoordinate()-3);
		this.setyCoordinate(this.getPorteur().getyCoordinate()-3);
	}

}

public Robot getPorteur() {
	return porteur;
}

public Boolean havePorteur() {
	return porteur != null;
}

public void setPorteur(Robot porteur) {
	this.porteur = porteur;
}

}