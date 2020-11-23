package sample;

public class plus extends Obstacles{
    private double length, Ypos;

    public plus(){

    }

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

    @Override
    public double[] computeStar(double radius1, double radius2) {
        return new double[0];
    }


}
