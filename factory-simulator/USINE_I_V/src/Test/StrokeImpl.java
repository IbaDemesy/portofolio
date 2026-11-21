package Test;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import java.io.Serializable;

class StrokeImpl implements Stroke, Serializable {

	public StrokeImpl(Color colorstroke, float thickness, float[] dashpattern) {
		super();
		this.colorstroke = colorstroke;
		this.thickness = thickness;
		this.dashpattern = dashpattern;
	}
	
	private Color colorstroke;
	private float thickness;
	private float[] dashpattern;
		
	
	@Override
	public Color getColor() {
		return colorstroke;
	}
	@Override
	public float getThickness() {
		return thickness;
	}
	@Override
	public float[] getDashPattern() {
		return dashpattern;
	}

}
