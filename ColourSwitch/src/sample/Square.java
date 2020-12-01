package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Square extends Obstacles{
    private transient Rectangle[] rects;
    private double xpos, side;

    public Square(double xpos, double yTop, double yBottom, double thick, boolean hasStar, double speed){
        this.yBottom = yBottom; this.yTop = yTop;
        double side = yBottom-yTop;
        x = xpos + side/2; y = yTop + side/2;
        this.xpos = xpos; this.side = side; this.thick = thick;
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
        g = new Group();
        star = new Star(computeStar());
        rects = new Rectangle[4];
        double[][] pos = new double[][] {{xpos, yTop, side-thick, thick}, {xpos+side-thick, yTop, thick, side - thick}, {xpos+thick, yTop+side-thick, side - thick, thick}, {xpos, yTop+thick, thick, side-thick}};
        for (int i=0; i<4; i++){
            rects[i] = new Rectangle(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
            rects[i].setFill(colors[i]);
            g.getChildren().add(rects[i]);}
        g.setRotate(angle);
        pane.getChildren().add(g);
        if (hasStar) star.draw(pane); }


    @Override
    public void rotate(double t) {
        angle = (angle+speed*t)%360;
        g.setRotate(angle);
    }

    @Override
    public boolean collision(Ball ball, double timeSinceStart) {
        Circle c = ball.getCircle();
        boolean collision = false;
        for (int i=0; i<4; i++){
            Shape intersect = Shape.intersect(rects[i], c);
            if ((intersect.getBoundsInLocal().getWidth() != -1) && (i!=ball.getColor())){
                collision = true; } }
        return collision; }




}
