package sample;

import javafx.scene.layout.Pane;

public class plus extends Obstacles{
    private double length, Ypos;

    public plus(){

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




}
