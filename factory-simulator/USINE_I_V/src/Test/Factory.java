package Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.tp.inf112.projects.canvas.controller.Observable;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.*;

public class Factory extends Component implements Canvas, Observable, Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private  String name;
    private ArrayList<Room> rooms;
    private ArrayList<Robot> robots;
    private ArrayList<ChargingPoint> chargingPoints;
    private ArrayList<Area> areas;
    private Collection<Figure> components;
    private transient List<Observer> observers;
    private boolean simulationStarted;

    public Factory( String name, int x, int y, ColorImpl backgroundColor, ColorImpl colorstroke, float thickness,
            float[] dashpattern, int height, int width, boolean simulationStarted) {
        super(name, x, y, backgroundColor, colorstroke, thickness, dashpattern, height, width);
        this.rooms = new ArrayList<>();
        this.robots = new ArrayList<>();
        this.chargingPoints = new ArrayList<>();
        this.areas = new ArrayList<>();
        this.components = new ArrayList<>();
        this.setSimulationStarted(simulationStarted);
    }

    public void addRoom(Room room) {
        rooms.add(room);
        components.add(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public void addPuck(Component component) {
        components.add(component);
    }

    public void addRobot(Robot robot) {
        if (checkRobotName(robot.getName())) {
            robots.add(robot);
            components.add(robot);
        }
    }

    public void addArea(Area area) {
        areas.add(area);
        components.add(area);
    }

    public void addChargingPoint(ChargingPoint chargingpoint) {
        chargingPoints.add(chargingpoint);
        components.add(chargingpoint);
    }

    public void addRooms(Room room) {
        rooms.add(room);
        components.add(room);
    }

    private boolean checkRobotName(String name) {
        for (Robot robot : robots) {
            if (robot.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Factory [name=" + name + "]\n");
        sb.append("Rooms:\n");
        for (Room room : rooms) {
            sb.append(room).append("\n");
        }
        sb.append("Robots:\n");
        for (Robot robot : robots) {
            sb.append(robot).append("\n");
        }
        sb.append("Areas:\n");
        for (Area area : areas) {
            sb.append(area).append("\n");
        }
        sb.append("Charging Points:\n");
        for (ChargingPoint chargingPoint : chargingPoints) {
            sb.append(chargingPoint).append("\n");
        }
        return sb.toString();
    }

    public void behave() {
        for (int i = 0; i < components.size(); i++) {
            Component component = (Component) ((ArrayList<Figure>) components).get(i);
            component.behave();
        }
    }

    @Override
    public Collection<Figure> getFigures() {
        return components;
    }

    @Override
    public Shape getShape() {
        return new RectangleShapeImpl(getWidth(), getHeight());
    }

    @Override
    public boolean addObserver(Observer observer) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers != null && observers.remove(observer);
    }

    public void notifyObservers() {
        if (observers != null) {
            for (Observer observer : observers) {
                observer.modelChanged();
            }
        }
    }

    public void startSimulation() {
        this.simulationStarted = true;
        notifyObservers();
    }

    public void stopSimulation() {
        this.simulationStarted = false;
        notifyObservers();
    }

    public boolean isSimulationStarted() {
        return simulationStarted;
    }

    public void setSimulationStarted(boolean simulationStarted) {
        this.simulationStarted = simulationStarted;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
 
     
 }



