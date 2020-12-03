package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Game implements Serializable {
    private User user;
    private Ball ball;
    private int HEIGHT, WIDTH;
    private double currentScroll, totalScroll;
    private obstacleArray obstArray;
    private boolean gameOver = false;
    private ArrayList<MagicColourBox> boxes = new ArrayList<>();
    private double handY = 660;

    public Game(String name, int HEIGHT, int WIDTH, int dist){
        this.HEIGHT = HEIGHT; this.WIDTH = WIDTH;
        user = new User(name, HEIGHT, dist);
        obstArray = new obstacleArray(this);
        currentScroll = 0; totalScroll= 0;
        ball = user.getBall();
//        MagicColourBox mcb = new MagicColourBox(250, 300);
//        MagicColourBox mcb1 = new MagicColourBox(250, -90);
//        MagicColourBox mcb2 = new MagicColourBox(250, -400);
//        MagicColourBox mcb3 = new MagicColourBox(250, -780);
//        boxes.addAll(List.of(mcb, mcb1, mcb2, mcb3));
        }

    public obstacleArray getObstArray(){
        return obstArray; }

    public ArrayList<MagicColourBox> getBoxes(){
        return boxes; }

    public void draw(Pane root){
        obstArray.getObstArray().forEach(e -> e.draw(root));
        boxes.forEach(e -> e.draw(root));
        ball.draw(root);
    }

    public void createObstacles(Pane root){
        obstArray.addObstacle(this, true, root); }

    public void scrollHand(double scroll){
        handY += scroll; }

    public double getHandY() {
        return handY; }

    public User getUser() {
        return user; }

    public void Loose(){

    }
    public void GameOver(){
        gameOver = true;

    }
    public void menuPause(){

    }

    public void addMCB(MagicColourBox box, Pane root){
        boxes.add(box);
        box.draw(root); }

    public ArrayList<obj> getObjects() {
        ArrayList<obj> objs = new ArrayList<>();

        objs.addAll(obstArray.getObstArray());
        objs.addAll(boxes);
        return objs; }

    private void checkGameover(){

    }

}