package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class Square extends Obstacles{

    private int length;
    private Rectangle[] rects;

    public Square(int xpos, int ypos, int side, int thick, boolean hasStar, double speed){
        rects = new Rectangle[4]; length = side;
        x = xpos + (double)side/2; y = ypos + (double) side/2;
        yBottom = ypos+side; yTop = ypos;
        this.hasStar = hasStar;
        this.speed = speed;
        star = new Star(computeStar());
        g = new Group();
        int[][] pos = new int[][] {{xpos, ypos, side-thick, thick}, {xpos+side-thick, ypos, thick, side - thick}, {xpos+thick, ypos+side-thick, side - thick, thick}, {xpos, ypos+thick, thick, side-thick}};
        for (int i=0; i<4; i++){
            rects[i] = new Rectangle(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
            rects[i].setFill(colors[i]);
            g.getChildren().add(rects[i]);} }

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
        g.setRotate(g.getRotate()+speed*t);
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
