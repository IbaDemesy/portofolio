package Test;

import java.io.*;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.view.FileCanvasChooser;

public class CanvasPersistenceManagerImpl extends AbstractCanvasPersistenceManager {

    public CanvasPersistenceManagerImpl() {
        super(new FileCanvasChooser("canvas", "Canvas Document"));
    }

    @Override
    public Canvas read(String canvasId) throws IOException {
        String filePath = getFilePath(canvasId);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Canvas) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Class not found while reading Canvas", e);
        }
    }

    @Override
    public void persist(Canvas canvasModel) throws IOException {
        String filePath = getFilePath(canvasModel.getId());
        // Créer le dossier parent s'il n'existe pas
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new IOException("Failed to create parent directory for file: " + file.getParentFile().getAbsolutePath());
            }
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(canvasModel);
        }
    }

    @Override
    public boolean delete(Canvas canvasModel) throws IOException {
        String filePath = getFilePath(canvasModel.getId());
        File file = new File(filePath);
        return file.delete();
    }

    private String getFilePath(String canvasId) {
        // Si canvasId contient des séparateurs de chemin, nous l'utilisons directement
        if (canvasId.contains(File.separator) || canvasId.contains("/") || canvasId.contains("\\")) {
            return canvasId;
        }
        return "data/" + canvasId + ".canvas";
    }
    
}
