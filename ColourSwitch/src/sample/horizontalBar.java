package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class horizontalBar extends Obstacles{
    private Rectangle[] rects;
    private double dist, WIDTH;

    public horizontalBar(double y, double WIDTH, double thick, double speed, double starDist){
        x = WIDTH/2; this.y = y - starDist; this.WIDTH = WIDTH;
        hasStar = true;
        this.speed = speed; //Distance travelled in a second
        rects = new Rectangle[8];
        for (int i=0; i<8; i++){
            rects[i] = new Rectangle(-WIDTH+(WIDTH/4)*i, y, WIDTH/4, thick);
            rects[i].setFill(colors[i%4]); }
        g = new Group(rects);
        star = new Star(computeStar()); }

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

    public double getColour() {
        return colour;
    }

    @Override
    public void draw(Pane pane) {
        pane.getChildren().add(g);
        star.draw(pane);}


    @Override
    public void rotate(double t) {
        for (int i=0; i<8; i++){
            rects[i].setX(rects[i].getX()+speed*t);}
        if (rects[0].getX()>=0){
            for (int i=0; i<8; i++){
                rects[i].setX(-WIDTH+(WIDTH/4)*i);} }}

    @Override
    public boolean collision(Ball ball, double t) {
        Circle c = ball.getCircle();
        boolean collision = false;
        for (int i=0; i<8; i++){
            Shape intersect = Shape.intersect(rects[i], c);
            if ((intersect.getBoundsInLocal().getWidth() != -1) && ((i%4)!=ball.getColor())){
                collision = true; } }
        return collision;
    }


    public void setColour(double colour) {
        this.colour = colour;
    }


}
