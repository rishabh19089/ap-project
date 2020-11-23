package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Obstacles extends element implements Serializable, Cloneable{
    protected double  colour, dificulty;
    protected double lastTime;
    protected Star star;
    protected double speed; //Angle rotated per second
    public abstract boolean rotation();
    protected ArrayList<javafx.scene.Node> elements;
    protected double sr1 = 20, sr2 = 10;
    protected boolean hasStar;

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

    public abstract void draw(Pane pane);

    public void starCollision(double pos, Pane root){
        if ((hasStar) && (star.present()) && (pos<=y+sr1+10) && (pos>=y-sr1)){
            star.eraseStar(root);
            star.setPresent(false); } }

    public abstract void rotate(double t);

    public abstract boolean collision(Ball ball, double t);

    public double[] computeStar() {
        double[] points = new double[20];
        for (int i=0; i<20; i+=4){
            int t = i/4;
            points[i] = x - sr1*Math.cos(Math.toRadians(90+(72*t)));
            points[i+1] = y - sr1*Math.sin(Math.toRadians(90+(72*t)));
            points[i+2] = x -sr2*Math.cos(Math.toRadians(126+(72*t)));
            points[i+3] = y - sr2*Math.sin(Math.toRadians(126+(72*t))); }
        return points; }
}