package sample;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameTiles {

    public abstract boolean containsPoint(double x, double y);
    public abstract void write(double x, double y, GraphicsContext gc);
}
