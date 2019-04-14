package model;


import behavior.behaviors.Collidable;
import game.Tile;

public class gridTile extends Tile implements Collidable {
    public gridTile() {
        super("/resources/gridTile.png");
    }

    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}