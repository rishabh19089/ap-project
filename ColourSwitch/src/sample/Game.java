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
    private Pane root;
    private Scene scene;

    public Game(String name, int HEIGHT, int WIDTH, int dist, Pane root, Scene scene){
        this.HEIGHT = HEIGHT; this.WIDTH = WIDTH;
        user = new User(name, HEIGHT, dist);
        this.root = root; this.scene = scene;
        obstArray = new obstacleArray();
        currentScroll = 0; totalScroll= 0;
        ball = user.getBall();
        MagicColourBox mcb = new MagicColourBox(250, 300);
        MagicColourBox mcb1 = new MagicColourBox(250, -90);
        MagicColourBox mcb2 = new MagicColourBox(250, -400);
        MagicColourBox mcb3 = new MagicColourBox(250, -780);
        boxes.addAll(List.of(mcb, mcb1, mcb2, mcb3));}

    public obstacleArray getObstArray(){
        return obstArray; }

    public ArrayList<MagicColourBox> getBoxes(){
        return boxes; }

    public void draw(){
        obstArray.getObstArray().forEach(e -> e.draw(root));
        boxes.forEach(e -> e.draw(root));
        ball.draw(root);
    }

    public User getUser() {
        return user; }

    public void Loose(){

    }
    public void GameOver(){
        gameOver = true;

    }
    public void menuPause(){

    }

    private void addMCB(){

    }

    public ArrayList<obj> getObjects() {
        ArrayList<obj> objs = new ArrayList<>();

        objs.addAll(obstArray.getObstArray());
        objs.addAll(boxes);
        return objs; }

    private void checkGameover(){

    }

}
