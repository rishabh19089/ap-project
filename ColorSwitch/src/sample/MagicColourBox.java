package sample;

public class MagicColourBox extends element{
    private double Y_pos;

    public MagicColourBox() {

    }


    public void eraseMagicColourBox(){

    }

    public boolean hitMagicColourBox(){
        return true;
    }
    private double randomColour(){
        return 0;
    }

    public void colourSwitch(){

    }


    @Override
    public void move(double t) {

    }

    @Override
    public boolean intersects(User user) {
        return false;
    }

    @Override
    public void handleCollision(User user) {

    }
}