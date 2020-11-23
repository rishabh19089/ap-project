package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class singleCircle extends Obstacles{

    private Circle fs;
    private Arc[] arcs;
    private double speed; //Angle rotated per second
    private double r1, r2;

    public singleCircle(double radius1, double radius2, int height, double speed){
        x = 250;
        y = height - 220;
        arcs = new Arc[4];
        r1 = radius1; r2 = radius2;
        this.speed = speed;
        for (int i=0; i<4; i++){
            arcs[i] = new Arc(x, y, radius1, radius1, 90*i, 90);
            arcs[i].setStroke(colors[i]);
            arcs[i].setFill(colors[i]);
            arcs[i].setType(ArcType.ROUND); }
        fs = new Circle(250, height -220, radius2);
        fs.setFill(Color.BLACK);
        double[] points = computeStar(sr1, sr2);
        star = new Star(points);}

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
    public double[] computeStar(double radius1, double radius2) {
        double[] points = new double[20];
        for (int i=0; i<20; i+=4){
            int t = i/4;
            points[i] = x - radius1*Math.cos(Math.toRadians(90+(72*t)));
            points[i+1] = y - radius1*Math.sin(Math.toRadians(90+(72*t)));
            points[i+2] = x - radius2*Math.cos(Math.toRadians(126+(72*t)));
            points[i+3] = y - radius2*Math.sin(Math.toRadians(126+(72*t))); }
        return points; }

    public void draw(Pane rootJeu)  {
        rootJeu.getChildren().addAll(arcs);
        rootJeu.getChildren().addAll(fs, star.get());}


    public void rotate(double timediff){
        for (int i=0; i<4; i++){
            arcs[i].setStartAngle(arcs[i].getStartAngle()+speed*timediff); } }

    public void starCollision(double pos, Pane root){
        if ((star.present()) && (pos<=y+sr2) && (pos>=y-sr1)){
            star.eraseStar(root);
            star.setPresent(false); } }

    public boolean collision(Ball ball, double timeSinceStart){
        double yball = ball.getY();
        int rotated = (int)(timeSinceStart*speed)%360;
        int bottomColor = (6-(rotated/90))%4;
        int topColor = (4-(rotated/90))%4;
        if ((yball>=y+r2) && (yball<=y+r1)){
            if (ball.getColour()!=bottomColor){
                return true; } }
        else if ((yball<=y-r2) && (yball>=y-r1)){
            if (ball.getColour()!=topColor){
                System.out.println("Game Over");
                return true; } }
        return false; }


}
