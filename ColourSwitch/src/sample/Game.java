package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game implements Serializable {
    private User user;
    private int HEIGHT, WIDTH;
    private double currentScroll, totalScroll;
    private obstacleArray obstArray;
    private boolean gameOver = false;
    private MagicColourBox magicColourBox;

    public Game(String name, int HEIGHT, int WIDTH, int dist){
        currentScroll = 0; totalScroll= 0;
        this.HEIGHT = HEIGHT; this.WIDTH = WIDTH;
        user = new User(name, HEIGHT, dist); }

    public User getUser() {
        return user; }

    public void Loose(){

    }
    public void GameOver(){
        gameOver = true;

    }
    public void menuPause(){

    }

    public List<obj> getObjects() {
        List<obj> objs = new ArrayList<>();

        objs.addAll((Collection<? extends obj>) obstArray.getObstArray());
        objs.add(user.getBall());
        return objs;
    }
    private void checkGameover(){

    }
}
