package sample;

import javafx.scene.layout.Pane;

public class horizontalBar extends Obstacles{
    private double Ypos, colour;

    public horizontalBar(){

    }

    @Override
    public boolean rotation() {
        return false;
    }

    @Override
    public double rotationSpeed() {
        return 0;
    }

    @Override
    public void hitObstacle() {

    }
    @Override
    public double time() {
        return 0;
    }

    @Override
    public double place() {
        return 0;
    }

    public double getColour() {
        return colour;
    }

    @Override
    public void draw(Pane pane) {

    }


    @Override
    public void rotate(double t) {

    }

    @Override
    public boolean collision(Ball ball, double t) {
        return false;
    }


    public void setColour(double colour) {
        this.colour = colour;
    }


}
