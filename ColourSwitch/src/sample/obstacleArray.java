package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class obstacleArray implements Serializable {
    private ArrayList<Obstacles> obstArray = new ArrayList<>();
    private int[] dificultyArr, Xarr;
    private double space;

    public obstacleArray() {
        singleCircle circle = new singleCircle(250, -1050, -890, 65, 90, true, true);
        singleCircle circle1 = new singleCircle(250,-30, 230, 105, 90, false, false);
        singleCircle circle2 = new singleCircle(250,10, 190, 70, 90, true, false);
        Square square = new Square(175 , 380, 530, 20, true, 90);
        horizontalBar bar = new horizontalBar(-270, 500, -185, 200, 50, true);
        Plus plus = new Plus(120, -710, -475, 15, 255, 90, true, true);
        Plus plus1 = new Plus(390, -710, -475, 15, 255, 90, false, false);
        obstArray.addAll(List.of(circle, circle1, circle2, square, bar, plus, plus1));
    }

    public ArrayList<Obstacles> getObstArray() {
        return obstArray;
    }

    public double getSpace() {
        return space;
    }

    public void nextLevel(double spaceReduced, double level){

    }
    public int typeObstacle(){
        //which type of obstacle is next
        return 0;
    }
    public MagicColourBox createColourBox(double y, double space){

        return new MagicColourBox(1,2);
    }
    public Obstacles createObstacle(double y, double space, double level){
        typeObstacle();
        createColourBox( y,space);
        return (Obstacles) new Object();
    }

}
