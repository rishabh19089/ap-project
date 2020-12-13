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
            addObstacle(game, true, new Pane(),new ArrayList<obj>() ); } }

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
        int t = new Random().nextInt(17);
        return t; }

    public MagicColourBox createColourBox(double y, double space){
        return new MagicColourBox(250,y-space); }

    public void addObstacle(Game game, boolean started, Pane root, ArrayList<obj> objs){
        double yTop = 630;
        if (started) {
            yTop = obbbb.yTop; }
        int score = game.getUser().getLastColorBox();
        Ball ball = game.getUser().getBall();
        double difficulty;
        if (score < 5){
            difficulty =1; }
        else if (score < 10) {
            difficulty = 1.2;
            ball.setAcc(650); }
        else if (score < 15) {
            difficulty = 1.4;
            ball.setAcc(700); }
        else {
            difficulty = 1.7;
            ball.setAcc(750); }
        if(game.isCheat()) difficulty = 1;
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
        double radius = 170/difficulty;
        double side = 280/difficulty;
        double side1 = 280/difficulty;
        double radius1 = 170/(difficulty- 0.1);
        double side2 = 160/(difficulty-0.1);
        double width = 15*difficulty;
        ArrayList<Obstacles> oArr= new ArrayList<>();
        switch (type){
            case 0:
                oArr.add(new singleCircle(250,yBottom-2*radius , yBottom, 20, speed, true, rot));
                break;
            case 1:
                oArr.add(new Square(250 - side/2,yBottom-side , yBottom, 20, true, speed, rot));
                break;
            case 2:
                oArr.add(new Plus(260-side1/2, yBottom-side1, yBottom, 20, 250, speed, true, rot));
                break;
            case 3:
                oArr.add(new horizontalBar(yBottom-width-70, 500, yBottom, 240*difficulty, 50, true));
                break;
            case 4:
                double side4= 220/difficulty;
                oArr.add(new Rect(250 - side1/2,yBottom-side4 , yBottom, 20, side1,true, speed, rot));
                break;
            case 5:
                oArr.add(new singleCircle(250,yBottom-2*radius1 , yBottom, 20, speed, false, rot));
                oArr.add(new Plus(260-side2/2, yBottom-side2/2-radius1, yBottom- radius1+ side2/2, 20, 250, speed/(difficulty+0.2), true, false));
                break;
            case 6:
                double side3= 140/(difficulty);
                double side5= 300/difficulty;
                oArr.add(new Square(250 - side5/2,yBottom-side5 , yBottom, 20, false, speed, rot));
                oArr.add(new Plus(260-side3/2, yBottom-side3/2-(side5/2), yBottom- (side5/2)+ side3/2, 20, 250, speed, true, false));
                break;
            case 7:
                double radius2 =(radius - 40);
                oArr.add(new singleCircle(250,yBottom-2*radius , yBottom, 20, speed, false, rot));
                oArr.add(new singleCircle(250,yBottom- 20 -(2*radius2) , yBottom, 20, speed, true, rot));
                break;
            case 8:
                oArr.add(new singleCircle(250,yBottom-2*radius , yBottom, 20, speed, false, true));
                oArr.add(new singleCircle(250,yBottom + 30 -(2*radius) , yBottom-30, 20, speed, true, true));
                break;
            case 9:
                double side7=240/difficulty;
                double side6 = 180/difficulty;
                oArr.add(new Plus((260 - side7/2), yBottom-side7, yBottom, 20, 250, speed, true, true));
                oArr.add(new Plus((250 + side6)-side6/2, yBottom-(side7/2)-(side6/2), yBottom-(side7/2)+(side6/2), 20, 250, speed, false, false));
                break;
            case 10:
                double radius3 = 200/(difficulty- 0.1);
                oArr.add(new singleCircle(250,yBottom-2*radius3 , yBottom, 20, speed, false, true));
                oArr.add(new singleCircle(250,yBottom + 30 -(2*radius3) , yBottom-30, 20, speed, false, true));
                oArr.add(new singleCircle(250,yBottom + 60 -(2*radius3) , yBottom-60, 20, speed, true, true));
                break;
            case 11:
                oArr.add(new horizontalBar(yBottom- 300-width-70, 500, yBottom- 300, 240*difficulty, 50, true));
                oArr.add(new horizontalBar(yBottom- 150-width-70, 500, yBottom- 150, 240*difficulty, 50, true));
                oArr.add(new horizontalBar(yBottom -width-70, 500, yBottom, 240*difficulty, 50, true));
                break;
            case 12:
                oArr.add(new horizontalBar(yBottom- 150-width-70, 500, yBottom- 150, 240*difficulty, 50, true));
                oArr.add(new horizontalBar(yBottom -width-70, 500, yBottom, 240*difficulty, 50, true));
                break;
            case 13:
                double side8 = 260/difficulty;
                side = 300/difficulty;
                oArr.add(new Square(250 - side/2,yBottom-side , yBottom, 20, false, speed, true));
                oArr.add(new Square(250 - side8/2,yBottom-side8/2-side/2, yBottom-side/2+side8/2, 20, true, speed, false));
                break;
            case 14:
                difficulty = Math.min(difficulty, 1.7);
                double side9 = 220/difficulty;
                side = 300/difficulty;
                oArr.add(new Square(250 - side/2,yBottom-side , yBottom, 20, false, speed, true));
                oArr.add(new Square(250 - side9/2,yBottom-side9/2-side/2, yBottom-side/2+side9/2, 20, true, speed, true));
                break;
            case 15:
                difficulty = Math.min(difficulty, 1.2);
                side1 = 300/difficulty;
                double side0= 220/difficulty;
                double spaced =34/difficulty;
                double s = side0/2-30-spaced;
                oArr.add(new Rect(250 - side1/2,yBottom-side0, yBottom, 20, side1,false, speed, rot));
                oArr.add(new Plus(260-s,yBottom-side0+20+spaced,yBottom-20-spaced,20, 250, speed, true, false));
                break;
            case 16:
                side = 320/difficulty;
                oArr.add(new Square(250 - side/2,yBottom-side , yBottom, 20, false, 120, true));
                oArr.add(new singleCircle(250,yBottom-side+35, yBottom-35, 20, 120, true, false));
                break;
            default:
                System.out.println("Reached Default in createObstacle");
                oArr.add(new singleCircle(250, -1050, -890, 65, 90, true, true));}
        obbbb = oArr.get(0);

        return oArr; }}
