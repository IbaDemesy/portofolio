package Test;

import java.io.IOException;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;
import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;

public class ManagerImpl extends AbstractCanvasPersistenceManager {

	public ManagerImpl(CanvasChooser canvasChooser) {
		super(canvasChooser);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Canvas read(String canvasId) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Canvas canvasModel) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(Canvas canvasModel) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
