package Test;

import fr.tp.inf112.projects.canvas.model.Color;
import java.io.Serializable;
public class ColorImpl implements Color, Serializable {
	
	public ColorImpl(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	private final int red;
	private final int green;
	private final int blue;
	
	
	@Override
	public int getRedComponent() {
		return red;
	}
	@Override
	public int getGreenComponent() {
		return green;
	}
	@Override
	public int getBlueComponent() {
		return blue;
	}

}
