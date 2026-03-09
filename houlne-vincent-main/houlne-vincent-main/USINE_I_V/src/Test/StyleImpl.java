/**
 * 
 */
package Test;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.Style;
import java.io.Serializable;
/**
 * 
 */
class StyleImpl implements Style, Serializable {
	
	public StyleImpl(Color backgroundcolor, Stroke stroke) {
		super();
		this.backgroundcolor = backgroundcolor;
		this.stroke = stroke;
	}

	private Color backgroundcolor;
	private Stroke stroke;

	
	@Override
	public Color getBackgroundColor() {
		return backgroundcolor;
	}

	@Override
	public Stroke getStroke() {
		return stroke;
	}

}
