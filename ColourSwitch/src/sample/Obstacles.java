package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Obstacles extends element implements Serializable, Cloneable{
    protected double  colour, dificulty;
    protected double lastTime;
    protected Star star;
    public abstract boolean rotation();
    protected ArrayList<javafx.scene.Node> elements;
    protected double sr1 = 20, sr2 = 10;

//    public Obstacles() {
//        this.elements = new ArrayList<>(); }

    public ArrayList<Node> getElements() {
        return elements;
    }

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

    public abstract double[] computeStar(double radius1, double radius2);
}