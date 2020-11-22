package sample;

public class Star extends element{

    public Star() {

    }

    public void eraseStar(){

    }

    public void increaseScore(){

    }

    public boolean hitStar(){
        return true;
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
