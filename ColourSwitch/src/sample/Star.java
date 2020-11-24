package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

public class Star extends element{
    Polygon star;
    private boolean present;

    public Star(double[] points) {
        star = new Polygon(points);
        star.setFill(Color.GOLD);
        present = true; }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Polygon get() {
        return star;
    }

    public void eraseStar(Pane rootJeu){
        rootJeu.getChildren().remove(star);
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
    public void draw(Pane pane) {
        pane.getChildren().addAll(star);
    }

    public boolean present(){
        return present;

    }


    @Override
    public boolean intersects(User user) {
        return false;
    }

    @Override
    public void handleCollision(User user, Pane pane) {

    }
}
