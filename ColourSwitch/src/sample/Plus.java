package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Plus extends Obstacles{
    private double length, center;
    private transient Rectangle[] rects;

    public Plus(double xpos, double yTop, double yBottom, double thick, double starCenter, double speed, boolean hasStar, boolean rotationClockwise){
        this.yTop = yTop; this.yBottom = yBottom; this.thick = thick;
        double side = (yBottom - yTop - thick)/2; double ypos = yBottom - thick - side;
        x = starCenter; y = ypos; this.length = side; center = xpos; this.speed = speed;
        clockwiseRotation = rotationClockwise;
        star = new Star(computeStar());
        this.hasStar = hasStar; }

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
        rects = new Rectangle[4];
        double[][] pos = new double[][] {{center-thick/2, y-length, thick, length}, {center, y, length, thick}, {center-thick/2, y+thick, thick, length}, {center-length, y, length, thick}};
        star.setPoints(computeStar());
        for (int i = 0; i<4; i++){
            rects[i] = new Rectangle(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
            rects[i].setFill(colors[i]); }
        g = new Group(rects);
        g.setRotate(angle);
        pane.getChildren().add(g);
        if (hasStar) star.draw(pane); }


    @Override
    public void rotate(double t) {
        if (clockwiseRotation) {
            angle = (angle+speed*t)%360;
            g.setRotate(angle); }
        else {
            angle = (angle-speed*t)%360;
            g.setRotate(angle); } }

    @Override
    public boolean collision(Ball ball, double t) {
        Circle c = ball.getCircle();
        boolean collision = false;
        for (int i=0; i<4; i++){
            Shape intersect = Shape.intersect(rects[i], c);
            if ((intersect.getBoundsInLocal().getWidth() != -1) && (i!=ball.getColor())){
                collision = true; } }
        return collision; }




}
