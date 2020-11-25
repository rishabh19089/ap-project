package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class obstacleArray implements Serializable {
    private ArrayList<Obstacles> obstArray = new ArrayList<>();
    private int[] dificultyArr, Xarr;
    private MagicColourBox magicColourBox;
    private double space;

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
