package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.HashMap;

public class Rect extends Obstacles{
    private transient javafx.scene.shape.Rectangle[] rects;
    private double xpos, side, side2;

    public Rect(double xpos, double yTop, double yBottom, double thick, double side2, boolean hasStar, double speed, boolean clockwise){
        this.yBottom = yBottom; this.yTop = yTop;
        double side = yBottom-yTop;
        this.side2= side2;
        x = xpos + side/2; y = yTop + side2/2;
        this.xpos = xpos; this.side = side; this.thick = thick;
        star = new Star(computeStar());
        clockwiseRotation = clockwise;
        this.hasStar = hasStar;
        this.speed = speed; }

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
    public void draw(Pane pane) {
        Color[] colors = new Color[]{Color.AQUAMARINE, Color.ORANGERED, Color.INDIGO, Color.YELLOW};
        if (!clockwiseRotation) colors = new Color[]{Color.AQUAMARINE, Color.YELLOW, Color.INDIGO, Color.ORANGERED};
        g = new Group();
        rects = new javafx.scene.shape.Rectangle[4];
        double[][] pos = new double[][] {{xpos, yTop, side-thick, thick}, {xpos+side-thick, yTop, thick, side2 - thick}, {xpos+thick, yTop+side2-thick, side - thick, thick}, {xpos, yTop+thick, thick, side2-thick}};
        for (int i=0; i<4; i++){
            rects[i] = new javafx.scene.shape.Rectangle(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
            rects[i].setFill(colors[i]);
            g.getChildren().add(rects[i]);}
        g.setRotate(angle);
        star.setPoints(computeStar());
        pane.getChildren().add(g);
        if (hasStar) star.draw(pane); }


    @Override
    public void rotate(double t) {
        if (clockwiseRotation) {
            angle = (angle+speed*t)%360; }
        else {
            angle = (angle-speed*t)%360; }
        g.setRotate(angle); }

    @Override
    public boolean collision(Ball ball, double timeSinceStart) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        colorMap.put(0,0); colorMap.put(1,3); colorMap.put(2,2); colorMap.put(3,1);
        Circle c = ball.getCircle();
        boolean collision = false;
        for (int i=0; i<4; i++){
            Shape intersect = Shape.intersect(rects[i], c);
            if ((intersect.getBoundsInLocal().getWidth() != -1) && (((clockwiseRotation) && (i!=ball.getColor())) || ((!clockwiseRotation) && (colorMap.get(i)!= ball.getColor())))){
                collision = true; } }
        return collision; }




}