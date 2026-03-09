package Test;

import java.util.ArrayList;
import fr.tp.inf112.projects.canvas.model.*;





public abstract class Area extends StaticComponent {
	
    public Area(String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
			float[] dashpattern, int height, int width,ArrayList<Robot> robots) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
		this.robots=robots;
	}


	protected ArrayList<Robot> robots;
	private Factory factory;

    public void addRobot(Robot robot) {
        robots.add(robot);
        getFactory().notifyObservers();
    }

    public void removeRobot(Robot robot) {
        robots.remove(robot);
        getFactory().notifyObservers();
    }

    public ArrayList<Robot> getAllRobots() {
        return robots;
    }

    @Override
    public String toString() {
        return "Area [name=" + getName() + ", x=" + getxCoordinate() + ", y=" + getyCoordinate() + "]";
    }

	public void addProductionUnit(ProductionUnit productionUnit) {
		// TODO Auto-generated method stub
		
	}
	public abstract void action();
	

	public Shape getShape() {
		return new RectangleShapeImpl(getWidth(), getHeight());
}

	@Override
	public void behave() {
		 ArrayList<Robot> robotusine = this.factory.getRobots();
		 robots.clear();
		 for (Robot elem :robotusine) {
			 int xe = elem.getxCoordinate();
		     int ye = elem.getyCoordinate();
		     int xa = this.getxCoordinate();
		     int ya = this.getyCoordinate();
		     if ((Math.abs(xe-xa)<= this.getWidth()/4) && (Math.abs(ye-ya)<= this.getHeight()/4)) {
		    	 robots.add(elem);
		     }
		 }
		 //on vient de voir quels robots sont dans l'area
		 //maintenant, on leur fait faire l'action de la area:
		 this.action();	
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}


}