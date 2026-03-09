package Test;

import fr.tp.inf112.projects.canvas.model.OvalShape;
import java.io.Serializable;
public class OvalShapeImpl  extends ShapeImpl implements OvalShape , Serializable{
    private int width;
    private int height;

    public OvalShapeImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
