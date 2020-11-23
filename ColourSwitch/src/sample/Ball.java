package sample;

import com.sun.prism.Graphics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Ball extends obj implements Serializable, Cloneable {
    private double upSpeed, downSpeed;
    private int HEIGHT;
    private Circle c;
    private int color = 1;

    public Ball(double downSpeed, int HEIGHT) {
        this.downSpeed = downSpeed;
        this.HEIGHT = HEIGHT;
        c = new Circle(10);
        c.setCenterX(250);
        c.setFill(Color.ORANGERED);
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

    public double getUpSpeed() {
        return upSpeed;
    }

    public void setUpSpeed(double upSpeed) {
        this.upSpeed = upSpeed;
    }

    public double getDownSpeed() {
        return downSpeed;
    }

    public void setDownSpeed(double downSpeed) {
        this.downSpeed = downSpeed;
    }

    public int getColour() {
        return color;
    }

    public void setColour(int colour) {
        this.color = colour;
        c.setFill(colors[color]);

    }


    public void draw(GraphicsContext context, Pane rootJeu){
        rootJeu.getChildren().add(c);
//        context.setFill(Color.ORANGERED);
//        context.fillOval(250, y, 20, 20);
    }

    public void jump(int dist){
        y-=dist; }

    @Override
    public void move(double timediff) {
        y = Math.min(y + timediff*downSpeed, HEIGHT-20);
        c.setCenterY(y); }


}