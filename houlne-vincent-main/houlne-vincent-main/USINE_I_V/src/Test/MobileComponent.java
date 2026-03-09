package Test;

import fr.tp.inf112.projects.canvas.model.Color;

public abstract class MobileComponent extends Component {


	
public MobileComponent(String name, int x, int y, Color backgroundColor, Color colorstroke, float thickness,
			float[] dashpattern, int height, int width) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
		// TODO Auto-generated constructor stub
	}

@Override
public String toString() {
    return "MobileComponent [name=" + getName() + "]";
}


}

