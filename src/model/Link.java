package model;


import behavior.behaviors.Collidable;
import behavior.behaviors.KeyBehavior;
import game.Element;

import java.util.ArrayList;

public class Link extends Element implements Collidable, KeyBehavior {

    private double deltaY;
    private double deltaX;


    public Link() {
        super("/resources/Link.png");
        this.deltaY = 0;
        this.deltaX = 0;
    }


    @Override
    public void handleKeyPresses(ArrayList<String> arrayList) {
        this.deltaX = 0;
        this.deltaY = 0;
        if(arrayList.contains("UP")){
            super.setY(super.getY()-10);
            this.deltaY  = -10;

        }
        else if(arrayList.contains("DOWN")){
            super.setY(super.getY()+10);
            this.deltaY = 10;
        }
        else if (arrayList.contains("RIGHT")){
            super.setX(super.getX()+10);
            this.deltaX = 10;
        }
        else if (arrayList.contains("LEFT")){
            super.setX(super.getX()-10);
            this.deltaX = -10;
        }
    }

    @Override
    public void handleCollision(Collidable collidable) {
        if(collidable instanceof SandTile){
            super.setY(super.getY() - deltaY);
            super.setX(super.getX() - deltaX);
        }
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }
}
