package sample;

import java.io.Serializable;

public class User implements Serializable {
    private int score;
    private String Name;
    private Ball ball;
    private int savedGames;

    public User(String name, int HEIGHT, int dist) {
        this.score = 0;
        Name = name;
        this.ball = new Ball(600, HEIGHT, dist);
        ball.setY(HEIGHT-70);
    }

    public int getSavedGames() {
        return savedGames; }


    public void setSavedGames(int savedGames) {
        this.savedGames = savedGames;
    }

    public void incrementSaved() {
        savedGames++; }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return Name;
    }

    public Ball getBall() {
        return ball;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}