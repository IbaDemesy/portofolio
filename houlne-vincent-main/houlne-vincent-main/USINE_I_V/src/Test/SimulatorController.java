package Test;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;



public class SimulatorController implements CanvasViewerController {
    
    private Factory factoryModel;
    private boolean animationRunning;
    private Canvas canvasModel;
    private transient Thread animationThread;

    public SimulatorController(Factory factoryModel) {
        this.factoryModel = factoryModel;
        this.animationRunning = factoryModel.isSimulationStarted();
    }

    @Override
    public Canvas getCanvas() {
        return factoryModel;  // Retourner l'usine comme le canvas actuel
    }


    public void startAnimation() {
        if (animationRunning) {
            return; // Ne démarre pas une nouvelle animation si elle est déjà en cours
        }
        animationRunning = true;
        factoryModel.startSimulation();
        
        animationThread = new Thread(() -> {
            while (animationRunning) {
                factoryModel.behave();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        animationThread.start();
    }

    @Override
    public void stopAnimation() {
        animationRunning = false;
        factoryModel.stopSimulation();
        try {
            if (animationThread != null) {
                animationThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAnimationRunning() {
        return animationRunning;
    }

    @Override
    public boolean addObserver(Observer observer) {
        return factoryModel.addObserver(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return factoryModel.removeObserver(observer);
    }

    @Override
    public CanvasPersistenceManager getPersistenceManager() {
        return new CanvasPersistenceManagerImpl();
    }

    @Override
    public void setCanvas(Canvas canvasModel) {
        if (canvasModel == null) {
            throw new IllegalArgumentException("Canvas model cannot be null");
        }
        this.canvasModel = canvasModel;
        if (canvasModel instanceof Factory) {
            this.factoryModel = (Factory) canvasModel;
            this.animationRunning = factoryModel.isSimulationStarted(); // Restauration de l'état de l'animation
        }
}}
