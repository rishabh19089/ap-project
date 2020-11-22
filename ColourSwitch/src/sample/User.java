package sample;

import java.io.Serializable;

public class User implements Serializable {
    private double score;
    private String Name;
    private Ball ball;

    public void setScore(double score) {
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