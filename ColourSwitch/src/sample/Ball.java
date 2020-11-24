package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Ball extends obj implements Serializable, Cloneable {
    private double acc, speed;
    private int HEIGHT, boost;
    private Circle c;
    private int color = 1;

    public Ball(double acc, int HEIGHT, int boost) {
        this.acc = acc;
        this.speed = 0;
        this.HEIGHT = HEIGHT;
        this.boost = boost;
        c = new Circle(10);
        c.setCenterX(250);
        c.setFill(Color.ORANGERED);
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
        this.color = colour;
        c.setFill(colors[color]); }

    @Override
    public void draw(Pane rootJeu){
        rootJeu.getChildren().add(c); }

    public void jump(){
        speed = Math.min(speed, 0);
        speed -= boost; }

    @Override
    public void move(double timediff) {
        speed = speed + acc*timediff;
        y = y + speed*timediff;
        y = Math.min(y, HEIGHT-20);
        speed = Math.min(250, speed);
        speed = Math.max(-250, speed);
        c.setCenterY(y); }


}