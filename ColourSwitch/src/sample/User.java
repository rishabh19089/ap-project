package sample;

import java.io.Serializable;

public class User implements Serializable {
    private int score;
    private String Name;
    private Ball ball;

    public User(String name, int HEIGHT, int dist) {
        this.score = 0;
        Name = name;
        this.ball = new Ball(600, HEIGHT, dist);
        ball.setY(HEIGHT-70);
    }

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

    public void setScore(int score) {
        this.score = score;
    }
}