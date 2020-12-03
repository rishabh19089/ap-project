package sample;

import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class obstacleArray implements Serializable {
    private ArrayList<Obstacles> obstArray = new ArrayList<>();
    private int[] dificultyArr, Xarr;
    private double space;
    private Obstacles obbbb;

    public obstacleArray(Game game) {
        addObstacle(game, false, new Pane(),new ArrayList<obj>());
        for (int i=0; i<2; i++){
            addObstacle(game, true, new Pane(),new ArrayList<obj>() ); }
//        singleCircle circle = new singleCircle(250, -1050, -890, 65, 90, true, true);
//        singleCircle circle1 = new singleCircle(250,-30, 230, 105, 90, false, false);
//        singleCircle circle2 = new singleCircle(250,10, 190, 70, 90, true, false);
//        Square square = new Square(175 , 380, 530, 20, true, 90, false);
//        horizontalBar bar = new horizontalBar(-270, 500, -185, 200, 50, true);
//        Plus plus = new Plus(145, -710, -475, 15, 255, 90, true, true);
//        Plus plus1 = new Plus(365, -710, -475, 15, 255, 90, false, false);
//        obstArray.addAll(List.of(circle, circle1, circle2, square, bar, plus, plus1));
    }

    public ArrayList<Obstacles> getObstArray() {
        return obstArray;
    }

    public double getSpace() {
        return space;
    }

    public void nextLevel(double spaceReduced, double level){

    }

    public int typeObstacle(double difficulty){
        //difficulty gives upper bound
        int t = new Random().nextInt(6);
        return t; }

    public MagicColourBox createColourBox(double y, double space){
        return new MagicColourBox(250,y-space); }

    public void addObstacle(Game game, boolean started, Pane root, ArrayList<obj> objs){
        double yTop = 630;
        if (started) {
            yTop = obbbb.yTop; }
        int score = game.getUser().getLastColorBox();
        double difficulty;
        if (score < 3) difficulty =1;
        else if (score < 7) difficulty = 1.2;
        else if (score < 10) difficulty = 1.5;
        else difficulty = 1.7;
        int type = typeObstacle(difficulty);
        double space = 300/difficulty;
        ArrayList<Obstacles> o = createObstacle(type, yTop, space, difficulty);
        o.forEach(ob-> ob.draw(root));
        obstArray.addAll(o);
        MagicColourBox MCB= createColourBox(yTop, space/2);
        objs.addAll(o);objs.add(MCB);
        game.addMCB(MCB, root); }

    public ArrayList<Obstacles> createObstacle(int type, double y, double space, double difficulty){
        double yBottom = y - space;
        double speed = 100*difficulty;
        boolean rot = new Random().nextBoolean();
        ArrayList<Obstacles> oArr= new ArrayList<>();
        switch (type){
            case 0:
                double radius = 150/difficulty;
                oArr.add(new singleCircle(250,yBottom-2*radius , yBottom, 20, speed, true, rot));
                break;
            case 1:
                double side = 250/difficulty;
                oArr.add(new Square(250 - side/2,yBottom-side , yBottom, 20, true, speed, rot));
                break;
            case 2:
                double side1 = 280/difficulty;
                oArr.add(new Plus(260-side1/2, yBottom-side1, yBottom, 20, 250, speed, true, rot));
                break;
            case 3:
                double width = 15*difficulty;
                oArr.add(new horizontalBar(yBottom-width-70, 500, yBottom, 200*difficulty, 50, true));
                break;
            case 4:
                double side3 = 280/difficulty;
                double side4= 220/difficulty;
                oArr.add(new Rect(250 - side3/2,yBottom-side3 , yBottom, 20, side4,true, speed, rot));
                break;
            case 5:
                double radius1 = 170/(difficulty- 0.1);
                double side5 = 160/(difficulty-0.1);
                oArr.add(new singleCircle(250,yBottom-2*radius1 , yBottom, 20, speed, false, rot));
                oArr.add(new Plus(260-side5/2, yBottom-side5/2-radius1, yBottom- radius1+ side5/2, 20, 250, speed, true, false));
                break;
            default:
                System.out.println("Reached Default in createObstacle");
                oArr.add(new singleCircle(250, -1050, -890, 65, 90, true, true));}
        obbbb = oArr.get(0);

        return oArr; }}
