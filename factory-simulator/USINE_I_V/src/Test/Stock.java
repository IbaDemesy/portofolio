package Test;

import java.util.ArrayList;

public class Stock extends Area {
	
	public Stock(String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
			float[] dashpattern, int height, int width, ArrayList<Robot> robots, ArrayList<Puck> pucks) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width, robots);
		this.setPucks(pucks);
	}


	private ArrayList<Puck> pucks;
	

	    @Override
	    public String toString() {
	        return "Stock [name=" + getName() + "]";
	    }


		public ArrayList<Puck> getPucks() {
			return pucks;
		}


		public void setPucks(ArrayList<Puck> pucks) {
			this.pucks = pucks;
		}


		@Override
		public void action() {
			for (Robot elem : robots) {
				if(!elem.getLoad().isEmpty()) {
					this.pucks.add(elem.getLoad().get(elem.getLoad().size()-1));
					elem.getLoad().get(elem.getLoad().size()-1).setxCoordinate(this.getxCoordinate());
					elem.getLoad().get(elem.getLoad().size()-1).setyCoordinate(this.getyCoordinate());
					elem.removePuck();
				}
			}
			
		}
	}
