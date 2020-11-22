package sample;

import java.io.Serializable;

public class Ball extends obj implements Serializable, Cloneable {
    private double upSpeed, downSpeed, colour;

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

    public double getColour() {
        return colour;
    }

    public void setColour(double colour) {
        this.colour = colour;
    }

    public void jump(){

    }

    @Override
    public void move(double t) {

    }
}