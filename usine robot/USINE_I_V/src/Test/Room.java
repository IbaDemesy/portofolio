package Test;

import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Shape;


public class Room extends StaticComponent {
	
	



	public Room(String name, int x, int y, Color backgroundColor, Color colorstroke, float thickness,
			float[] dashpattern, int height, int width,ArrayList<Door> doors) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
		// TODO Auto-generated constructor stub
		this.doors=doors;
	}
	private final ArrayList<Door> doors;

 
@Override
public String toString() {
    return "Room [name=" + getName() + "]";
}



	public Shape getShape() {
	    return new RectangleShapeImpl(getWidth(), getHeight());
	}
	public ArrayList<Door> getDoors() {
		return doors;
	}



	@Override
	public void behave() {
		// TODO Auto-generated method stub
		
	}
}