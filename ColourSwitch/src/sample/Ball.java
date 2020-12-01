package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.Serializable;
import java.util.Random;

public class Ball extends obj implements Serializable, Cloneable {
    private double acc, speed;
    private int HEIGHT, boost;
    private transient Circle c;
    private int color;

    public Ball(double acc, int HEIGHT, int boost) {
        y = 510;
        this.acc = acc;
        this.speed = 0;
        this.HEIGHT = HEIGHT;
        this.boost = boost;
        color= new Random().nextInt(4);
    }

    public Circle getCircle() {
        return c;
    }


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
        c.setFill(colors[color]); }

    @Override
    public void move(double t) {
        if (y<=HEIGHT/2) y = HEIGHT/2; }

    @Override
    public void draw(Pane rootJeu){
        Color[] colors = new Color[]{Color.AQUAMARINE, Color.ORANGERED, Color.INDIGO, Color.YELLOW};
        c = new Circle(10);
        c.setCenterX(250);

        c.setFill(colors[color]);
        rootJeu.getChildren().add(c); }

    public void jump(){
        speed = Math.min(speed, 0);
        speed -= boost; }

    public void move(double timediff, boolean started) {
        move(timediff);
        speed = speed + acc*timediff;
        y = y + speed*timediff;
        if (!started)y = Math.min(y, HEIGHT-20);
        speed = Math.min(350, speed); speed = Math.max(-350, speed);
        c.setCenterY(y); }


}