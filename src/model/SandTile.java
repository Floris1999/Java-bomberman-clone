package model;


import behavior.behaviors.Collidable;
import game.Tile;

public class SandTile extends Tile implements Collidable {
    public SandTile() {
        super("/resources/SandTile.png");
    }

    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}
