package sample;

import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class singleCircle extends Obstacles{


    @FXML
    private Arc qs1;

    @FXML
    private Arc qs2;

    @FXML
    private Arc qs3;

    @FXML
    private Arc qs4;

    @FXML
    private Circle fs;

    public singleCircle(double radius1, double radius2){
        qs1.setRadiusX(radius1);
        qs1.setRadiusY(radius1);
        qs2.setRadiusX(radius1);
        qs2.setRadiusY(radius1);
        qs3.setRadiusX(radius1);
        qs3.setRadiusY(radius1);
        qs4.setRadiusX(radius1);
        qs4.setRadiusY(radius1);
        fs.setRadius(radius2);
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


}
