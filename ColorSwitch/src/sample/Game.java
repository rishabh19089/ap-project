package sample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game implements Serializable {
    private User user;
    private obstacleArray obstArray;
    private boolean gameover;
    private MagicColourBox magicColourBox;

    public Game(){

    }
    public void Loose(){

    }
    public void GameOver(){

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
