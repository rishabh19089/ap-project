package sample;

import java.io.Serializable;

public class User implements Serializable {
    private int score;
    private String Name;
    private Ball ball;

    public User(String name, int HEIGHT, int dist) {
        this.score = 0;
        Name = name;
        this.ball = new Ball(420, HEIGHT, dist);
        ball.setY(HEIGHT-50);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return Name;
    }

    public Ball getBall() {
        return ball;
    }
}