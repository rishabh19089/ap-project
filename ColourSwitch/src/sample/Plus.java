package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Plus extends Obstacles{
    private double length, center;
    private Rectangle[] rects;

    public Plus(double xpos, double yTop, double yBottom, double thick, double starCenter, double speed, boolean hasStar, boolean rotationClockwise){
        this.yTop = yTop; this.yBottom = yBottom;
        double side = (yBottom - yTop - thick)/2; double ypos = yBottom - thick - side;
        x = starCenter; y = ypos; this.length = side; center = xpos; this.speed = speed;
        clockwiseRotation = rotationClockwise;
        rects = new Rectangle[4];
        this.hasStar = hasStar;
        star = new Star(computeStar());
        double[][] pos = new double[][] {{xpos-thick/2, ypos-side, thick, side}, {xpos, ypos, length, thick}, {xpos-thick/2, ypos+thick, thick, side}, {xpos-side, ypos, side, thick}};
        for (int i = 0; i<4; i++){
            rects[i] = new Rectangle(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
            rects[i].setFill(colors[i]); }
        g = new Group(rects); }

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
        pane.getChildren().add(g);
        if (hasStar) star.draw(pane); }


    @Override
    public void rotate(double t) {
        if (clockwiseRotation) {
            g.setRotate(g.getRotate() + speed * t); }
        else {
            g.setRotate(g.getRotate() - speed * t); } }

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
