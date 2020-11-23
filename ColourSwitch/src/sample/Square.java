package sample;

import javafx.fxml.FXML;
import javafx.scene.shape.*;

public class Square extends Obstacles{
    private double length, Ypos;
    @FXML
    private Rectangle s2;

    @FXML
    private Rectangle s4;

    @FXML
    private Rectangle s3;

    @FXML
    private Rectangle s1;

    public Square(double side){
        s1.setWidth(side);
        s2.setWidth(side);
        s3.setWidth(side);
        s4.setWidth(side);

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
    public double[] computeStar(double radius1, double radius2) {
        return new double[0];
    }


}
