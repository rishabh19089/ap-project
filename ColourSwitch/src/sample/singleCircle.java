package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;


public class singleCircle extends Obstacles{

    private Circle fs;
    private Arc[] arcs;
    private double r1, r2;

    public singleCircle(double xCenter, double yTop, double yBottom, double radius2, double speed, boolean hasStar){
        this.yTop = yTop; this.yBottom = yBottom; x = xCenter; y = (yTop+yBottom)/2;
        arcs = new Arc[4];
        r1 = yBottom-y; r2 = radius2;
        this.speed = speed;
        for (int i=0; i<4; i++){
            arcs[i] = new Arc(x, y, r1, r1, 90*i, 90);
            arcs[i].setStroke(colors[i]);
            arcs[i].setFill(colors[i]);
            arcs[i].setType(ArcType.ROUND); }
        fs = new Circle(x, y, radius2);
        fs.setFill(Color.BLACK);
        star = new Star(computeStar());
        this.hasStar = hasStar; }

    public double getSpeed() {
        return speed; }

    public void setSpeed(double speed) {
        this.speed = speed; }

    public Star getStar() {
        return star; }

    @Override
    public boolean rotation() {
        return false; }

    @Override
    public double rotationSpeed() {
        return 0; }

    @Override
    public void hitObstacle() {
    }

    @Override
    public double time() {
        return 0; }

    @Override
    public double place() {
        return 0; }

    @Override
    public void move(double scroll) {
        y+=scroll; yTop+=scroll; yBottom+=scroll;
        if (hasStar) star.move(scroll);
        for (Arc arc: arcs){
            arc.setCenterY(arc.getCenterY()+scroll); }
        fs.setCenterY(fs.getCenterY()+scroll);}


    @Override
    public void draw(Pane rootJeu)  {
        rootJeu.getChildren().addAll(arcs);
        rootJeu.getChildren().add(fs);
        if (hasStar) star.draw(rootJeu);}


    public void rotate(double timediff){
        for (int i=0; i<4; i++){
            arcs[i].setStartAngle(arcs[i].getStartAngle()+speed*timediff);
        } }


    public boolean collision(Ball ball, double timeSinceStart){
        double yball = ball.getY();
        int rotated = (int)(timeSinceStart*speed)%360;
        int bottomColor = (6-(rotated/90))%4;
        int topColor = (4-(rotated/90))%4;
        if ((yball>=y+r2) && (yball<=y+r1)){
            return ball.getColor() != bottomColor; }
        else if ((yball<=y-r2) && (yball>=y-r1)){
            return ball.getColor() != topColor; }
        return false; }


}
