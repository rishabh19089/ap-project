package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Obstacles extends element implements Serializable, Cloneable{
    protected double  colour, dificulty;
    protected double yBottom, yTop, thick;
    protected Star star;
    protected double speed; //Angle rotated per second
    public abstract boolean rotation();
    protected double sr1 = 20, sr2 = 10;
    protected boolean hasStar;
    protected boolean clockwiseRotation;
    protected transient Group g;
    protected double angle = 180;

    public Obstacles() {
         }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public abstract double rotationSpeed();

    public abstract void hitObstacle();
    public abstract double time();
    public abstract double place();

    public double bottomColour(){
        return 0;
    }



    public double getColour() {
        return colour; }
        
    @Override
    public void move(double scroll) {
        y+=scroll; yBottom+=scroll; yTop+=scroll;
        g.setTranslateY(g.getTranslateY()+scroll);
        if (hasStar) star.move(scroll);}

    @Override
    public boolean intersects(User user) {
        return false;
    }

    @Override
    public void handleCollision(User user, Pane pane) {

    }

    public double getyBottom() {
        return yBottom;
    }

    public void setyBottom(double yBottom) {
        this.yBottom = yBottom;
    }

    public double getyTop() {
        return yTop;
    }

    public void setyTop(double yTop) {
        this.yTop = yTop;
    }

    public abstract void draw(Pane pane);

    public void starCollision(User user, Pane root){
        double pos = user.getBall().getY();
        if ((hasStar) && (star.present()) && (pos<=y+sr1+10) && (pos>=y-sr1)){
            user.incrementScore();
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