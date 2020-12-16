package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.io.Serializable;
import java.util.Random;

public class Ball extends obj implements Serializable, Cloneable {
    private double acc, speed;
    private int HEIGHT, boost, type;
    private transient Circle c;
    private transient Rectangle sq;
    private transient Rectangle square;
    private int shape;
    private int color;

    public Ball(double acc, int HEIGHT, int boost) {
        this.acc = acc;
        this.speed = 0;
        this.HEIGHT = HEIGHT;
        this.boost = boost;
        color= new Random().nextInt(4);
        type= new Random().nextInt(2);
    }

    public Shape getCircle() {
        if(type == 0) return c;
        else return sq;
    }
    public Rectangle getSqBall(){return sq;}
    public void setBoost(int dist) {
        this.boost = dist;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double upper_Ypos(){
        return 0;
    }
    public double lower_Ypos(){
        return 0;
    }

    public void invincible(){
        c.setFill(Color.WHITE); }

    public void setAcc(double acc) {
        this.acc = acc; }

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int colour) {
        Color[] colors = new Color[]{Color.AQUAMARINE, Color.ORANGERED, Color.INDIGO, Color.YELLOW};
        this.color = colour;
        if(type == 0) c.setFill(colors[color]);
        else sq.setFill(colors[color]);
    }
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void move(double t) {
        if (y<=HEIGHT/2) y = HEIGHT/2; }

    @Override
    public void draw(Pane rootJeu){
        Color[] colors = new Color[]{Color.AQUAMARINE, Color.ORANGERED, Color.INDIGO, Color.YELLOW};
        if (type == 0){
            c = new Circle(10);
            rootJeu.getChildren().remove(sq);
            c.setCenterX(250); c.setCenterY(y);c.setFill(colors[color]);
            rootJeu.getChildren().add(c);}
        else {
            rootJeu.getChildren().remove(c);
            sq= new Rectangle(240, y- 10, 20,20);
            sq.setFill(colors[color]);
            rootJeu.getChildren().add(sq);
         }
    }

    public int getType() {
        return type;
    }

    public void jump(){
        speed = Math.min(speed, 0);
        speed -= boost; }

    public void move(double timediff, boolean started) {
        move(timediff);
        double r= y;
        speed = speed + acc*timediff;
        y = y + speed*timediff;
        if (!started)y = r;
        speed = Math.min(350, speed); speed = Math.max(-350, speed);
        if(type == 0) c.setCenterY(y);
        else sq.setY(y);
    }


}