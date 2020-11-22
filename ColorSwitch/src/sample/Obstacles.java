package sample;

import java.io.Serializable;

public abstract class Obstacles extends element implements Serializable, Cloneable{
    protected double  colour, dificulty;
    protected double lastTime;
    protected Star star;
    public abstract boolean rotation();

    public abstract double rotationSpeed();

    public abstract void hitObstacle();
    public abstract double time();
    public abstract double place();

    public double bottomColour(){
        return 0;
    }


    public double getColour() {
        return colour;
    }
    @Override
    public void move(double t) {

    }
    @Override
    public boolean intersects(User user) {
        return false;
    }

    @Override
    public void handleCollision(User user) {

    }
}