package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.Serializable;

public abstract class obj implements Serializable {
    protected transient Color[] colors = new Color[]{Color.AQUAMARINE, Color.ORANGERED, Color.INDIGO, Color.YELLOW};
    protected double x, y;
    public abstract void move(double t);
    public abstract void draw(Pane pane);

    public double getX() {
        return x; }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y; }

    public void setY(double y) {
        this.y = y; }

}