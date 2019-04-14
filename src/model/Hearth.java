package model;

import behavior.behaviors.Collidable;
import engine.Engine;
import game.Element;

import java.util.ArrayList;

public class Hearth extends Element implements Collidable {

    private ArrayList<Hearth> hartenLink = new ArrayList<>();
    private ArrayList<Hearth> hartenPlayer2 = new ArrayList<>();


    private int linkCounter = 0;
    private int player2Counter = 0;


    public Hearth() {
        super("/resources/heart.png");
    }

    public void linkHarten(){
       if(9 == 10){

       }
           else {
           Hearth hart = new Hearth();
           hartenLink.add(hart);
           hart.setX(200);
           hart.setY(200);
      //     Engine.getGameGlobaly().getActiveLevel().getElements().add(hart);
           linkCounter++;
       }
    }

    public void hartenPlayer2(){
        Hearth hart = new Hearth();
        hartenPlayer2.add(hart);
        Engine.getGameGlobaly().getActiveLevel().getElements().add(hartenLink.get(player2Counter));
        player2Counter++;
    }


    @Override
    public void handleCollision(Collidable collidable) {
    }


}
