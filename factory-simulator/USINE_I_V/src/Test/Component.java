package Test;

import fr.tp.inf112.projects.canvas.model.Color;
import java.io.Serializable;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Style;


public abstract class Component implements Figure, Serializable{
	



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String name;
    private int x;
    private int y;
    private final int height;
    private final int width;
    private final Style style;
    private Factory factory; 
    abstract public void behave();
 
    
 


    public Component(String name, int x, int y, Color backgroundColor, Color colorstroke,float thickness,float[] dashpattern, int height, int width) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.style = new StyleImpl(backgroundColor,new StrokeImpl(colorstroke,thickness,dashpattern))   ;
        this.height=height;
        this.width=width;



    }


    public String getName() {
        return name;
    }

    public int getxCoordinate(){
        return x;
    }

    public int getyCoordinate() {
        return y;
    }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
    
    // Méthodes de l'interface Figure
    public abstract Shape getShape() ;  
    
    

    public String toString() {
        return "Component [name=" + name + "]";
    }
@Override
	public Style getStyle() {
		return style;
	}




public void setxCoordinate(int x) {
	this.x = x;
	getFactory().notifyObservers();
}




public void setyCoordinate(int y) {
	this.y = y;
	getFactory().notifyObservers();
}




public Factory getFactory() {
	return factory;
}


public void setFactory(Factory factory) {
	this.factory = factory;
	getFactory().notifyObservers();
}
}
