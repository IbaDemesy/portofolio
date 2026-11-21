package Test;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Shape;




public class Door extends Component {
	private Boolean open;
	private  Boolean horizontal;
	
	public Door(String name, int x, int y, Color backgroundColor, Color colorstroke, float thickness,
			float[] dashpattern, int height, int width,Boolean open,Boolean horizontal) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
		this.setOpen(open);
		this.setHorizontal(horizontal);
	}


   

	
@Override
public String toString() {
    return "Door [name=" + getName() + "]";
}

@Override
public Shape getShape() {
	// TODO Auto-generated method stub
	return null;
}





public Boolean getHorizontal() {
	return horizontal;
}





public void setHorizontal(Boolean horizontal) {
	getFactory().notifyObservers();
	this.horizontal = horizontal;
}





public Boolean getOpen() {
	return open;
}





public void setOpen(Boolean open) {
	getFactory().notifyObservers();
	this.open = open;
}





@Override
public void behave() {
	// TODO Auto-generated method stub
	
}
}