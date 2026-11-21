package Test;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class SimulatorApplication {

    // Définir un objet de type Logger pour afficher les messages
    private static final Logger LOGGER = Logger.getLogger(SimulatorApplication.class.getName());

    public static void main(String[] args) {
        // Afficher deux messages d’information avec deux niveaux de détail différents
        LOGGER.info("Starting the robot simulator...");
        LOGGER.config("With parameters " + Arrays.toString(args) + ".");

        // Reste de votre code ici
        String name = "MyFactory";
        int x = 0;
        int y = 0;
        ColorImpl backgroundColor = new ColorImpl(200, 200, 200);
        ColorImpl robotcolor = new ColorImpl(250, 0, 0);
        ColorImpl colorStroke = new ColorImpl(0, 0, 0);
        ColorImpl colorCharge = new ColorImpl(190, 230, 190);
        ColorImpl colorArea = new ColorImpl(255, 255, 204);
        ColorImpl colorPuck = new ColorImpl(0, 0, 250);
        ColorImpl colorfond = new ColorImpl(250, 250, 250);
        float thickness = 1.5f;
        float[] dashPattern = {1.0f, 2.0f};
        int factoryHeight = 400;
        int factoryWidth = 600;
        

        Factory factory = new Factory(name, x, y, colorfond, colorStroke, thickness, dashPattern, factoryHeight, factoryWidth, false);
        factory.setId("FactoryCanva"); // Configurez l'ID du canvas ici

        // Ajouter 4 salles      
        Room room1 = new Room("Room1 ",50, 170, backgroundColor, colorStroke, thickness, dashPattern, 200, 200, new ArrayList<Door>());
            room1.setFactory(factory);
            factory.addRoom(room1);
        Room room2 = new Room("Room2 ",50, 30, backgroundColor, colorStroke, thickness, dashPattern, 200, 200, new ArrayList<Door>());
            room2.setFactory(factory);
            factory.addRoom(room2);
        Room room3 = new Room("Room3 ",250, 170, backgroundColor, colorStroke, thickness, dashPattern, 200, 200, new ArrayList<Door>());
            room3.setFactory(factory);
            factory.addRoom(room3);
        Room room4 = new Room("Room4 ",250, 30, backgroundColor, colorStroke, thickness, dashPattern, 200, 200, new ArrayList<Door>());
            room4.setFactory(factory);
            factory.addRoom(room4);       

            
        // Ajouter des stations de recharge
        ChargingPoint chargingPoint1 = new ChargingPoint("Charging Station 1", 150, 250, colorCharge, colorStroke, thickness, dashPattern, 30, 30, new ArrayList<Robot>(), true,50);
        chargingPoint1.setFactory(factory);
        factory.addChargingPoint(chargingPoint1);

        ChargingPoint chargingPoint2 = new ChargingPoint("Charging Station 2", 200, 30, colorCharge, colorStroke, thickness, dashPattern, 30, 30, new ArrayList<Robot>(), true,60);
        chargingPoint2.setFactory(factory);
        factory.addChargingPoint(chargingPoint2);

        ChargingPoint chargingPoint3 = new ChargingPoint("Charging Station 3", 100, 30, colorCharge, colorStroke, thickness, dashPattern, 30, 30, new ArrayList<Robot>(), true,30);
        chargingPoint3.setFactory(factory);
        factory.addChargingPoint(chargingPoint3);
        
        
        //Ajouter un Stock
        Stock stock = new Stock("stockage",350,100,colorArea,colorStroke, thickness, dashPattern, 100, 100,new ArrayList<Robot>(), new ArrayList<Puck>());
        stock.setFactory(factory);
        factory.addArea(stock);
        
        //Ajouter un Band Conveyer
        BandConveyer conveyer = new BandConveyer("conveyer",350,300, colorArea, colorStroke, thickness, dashPattern, 50 ,100, new ArrayList<Robot>(),  3, true, true,4);
        conveyer.setFactory(factory);
        factory.addArea(conveyer);
        
        //production unit
        ProductionUnit production = new ProductionUnit("production",250,300, colorArea, colorStroke, thickness, dashPattern, 50 ,100, new ArrayList<Robot>(),  0,factory);
        production.setFactory(factory);
        factory.addArea(production);       
        
        // Ajouter trois robots
        // /!\ on ajoute directement les pucks au robot parcequ'il n'y a pas de salle de création de puck
        Robot robot = new Robot("Robot 0", 100, 200, robotcolor, colorStroke, thickness, dashPattern, 10, 10, 0, 1000, new ArrayList<Puck>(),new ArrayList<Component>());
        robot.addVisits(conveyer);
        robot.addVisits(production);
        robot.addVisits(chargingPoint1);
        robot.addVisits(production);
        robot.addVisits(chargingPoint2);
        robot.addVisits(production);
        robot.addVisits(chargingPoint3);
        System.out.println(robot.getVisits());
        robot.setFactory(factory);
        robot.setSpeed(3);
        factory.addRobot(robot);  
                 	for (int i = 0; i < 5; i++) { 
        		Puck puck = new Puck("puck" + i, robot.getxCoordinate() + i, robot.getyCoordinate() + i, colorPuck, colorStroke,
                                 thickness, dashPattern, 5, 5,factory);
        		factory.addPuck(puck);
        		puck.setFactory(factory);
        		robot.addPuck(puck);
        	}

        Robot robot1 = new Robot("Robot 1", 80, 150, robotcolor, colorStroke, thickness, dashPattern, 10, 10, 0, 1000, new ArrayList<Puck>(), new ArrayList<Component>());
        robot1.addVisits(chargingPoint2);
        robot1.addVisits(conveyer);
        robot1.addVisits(chargingPoint1);
        robot1.addVisits(production);
        robot1.addVisits(stock);
        System.out.println(robot.getVisits());
        robot1.setFactory(factory);
        robot1.setSpeed(3);
        factory.addRobot(robot1);          
        for (int i = 0; i < 8; i++) { 
       		Puck puck1 = new Puck("puck1" + i, robot1.getxCoordinate() + i, robot1.getyCoordinate() + i, colorPuck, colorStroke,
                                 thickness, dashPattern, 5, 5,factory);
      		factory.addPuck(puck1);
      		puck1.setFactory(factory);
      		robot1.addPuck(puck1);
        }

        Robot robot2 = new Robot("Robot 2", 120, 170, robotcolor, colorStroke, thickness, dashPattern, 10, 10, 0, 1000, new ArrayList<Puck>(), new ArrayList<Component>());
        robot2.addVisits(chargingPoint2);
        robot2.addVisits(production);
        robot2.addVisits(chargingPoint1);
        robot2.addVisits(conveyer);
        robot2.addVisits(stock);
        System.out.println(robot2.getVisits());
        robot2.setFactory(factory);
        robot2.setSpeed(3);
        factory.addRobot(robot2);          
        for (int i = 0; i < 7; i++) { 
       		Puck puck2 = new Puck("puck2" + i, robot2.getxCoordinate() + i, robot2.getyCoordinate() + i, colorPuck, colorStroke,
                                 thickness, dashPattern, 5, 5,factory);
      		factory.addPuck(puck2);
      		puck2.setFactory(factory);
      		robot2.addPuck(puck2);
        }

        // Création du contrôleur
        SimulatorController controller = new SimulatorController(factory);

        // Création du CanvasViewer en utilisant le constructeur qui prend à la fois un Canvas et un contrôleur comme paramètres
        CanvasViewer canvasViewer = new CanvasViewer(controller);

        // Rendre le CanvasViewer visible
        canvasViewer.setVisible(true);
    }
}
