package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    public singleCircle(double radius1, double radius2, int height){
        qs1 = new Arc(250, height -220, radius1, radius1, 0, 90);
        qs1.setStroke(Color.AQUAMARINE);
        qs1.setFill(Color.AQUAMARINE);
        qs1.setType(ArcType.ROUND);
        qs2 = new Arc(250, height -220, radius1, radius1, 90 , 90);
        qs2.setStroke(Color.ORANGERED);
        qs2.setFill(Color.ORANGERED);
        qs2.setType(ArcType.ROUND);
        qs3 = new Arc(250, height -220, radius1, radius1, 180 , 90);
        qs3.setStroke(Color.INDIGO);
        qs3.setFill(Color.INDIGO);
        qs3.setType(ArcType.ROUND);
        qs4 = new Arc(250, height -220, radius1, radius1, 270 , 90);
        qs4.setStroke(Color.YELLOW);
        qs4.setFill(Color.YELLOW);
        qs4.setType(ArcType.ROUND);
        fs = new Circle(250, height -220, radius2);
        fs.setFill(Color.BLACK); }

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

    public void draw(Pane rootJeu)  {
            rootJeu.getChildren().addAll(qs1, qs2, qs3, qs4, fs);}




    public void rotate(double timediff){
        qs1.setStartAngle(qs1.getStartAngle()+1);
        qs2.setStartAngle(qs2.getStartAngle()+1);
        qs3.setStartAngle(qs3.getStartAngle()+1);
        qs4.setStartAngle(qs4.getStartAngle()+1); }


}
