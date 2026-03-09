package Test;

import java.util.ArrayList;

public class ProductionUnit extends Area {
	
	public ProductionUnit(String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
			float[] dashpattern, int height, int width, ArrayList<Robot> robots,int productionRate,Factory factory) {
		super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width, robots);
		this.productionRate = productionRate;
		this.puckproduced = new ArrayList<Puck>();
		this.factory = factory;
	}
	
	private Factory factory;


	private int productionRate;
	private ArrayList<Puck> puckproduced;



	    @Override
	    public String toString() {
	        return "ProductionUnit [name=" + getName() + "]";
	    }



		public int getProductionRate() {
			return productionRate;
		}



		@Override
		public void action() {
			float[] dashPattern = {1.0f, 2.0f};
			for (int i = 0; i < 10; i++) {
				Puck puck = new Puck("puck" + i, this.getxCoordinate() + i, this.getyCoordinate() + i, new ColorImpl(0, 0, 250),
						new ColorImpl(0, 0, 0), 1.5f, dashPattern, 5, 5,factory);
			}
			
		
			for (Robot elem : robots) {
				for (Puck elem1 : puckproduced) {
					elem.addPuck(elem1);
					elem1.setPorteur(elem);
			
			puckproduced.clear();
				}
				
				
			
		
	}
			}
}
