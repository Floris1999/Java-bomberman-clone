package model;


import behavior.behaviors.Collidable;
import game.Tile;

public class checkTile extends Tile implements Collidable {
	
	private boolean collision = false;
	private Collidable object = null;
	
    public checkTile() {
        super("/resources/checkTile.png");
    }

    @Override
    public void handleCollision(Collidable col) {
    	if(col instanceof gridTile) {
    		collision = true;
    	}
    	if(col instanceof breakingTileNormal) {
    		collision = true;
    		object = col;
    	}
    	else {
    		object = null;
    	}
    }
    
    public Collidable getObject() {
    	return object;
    }
    
    public void setPosition(double x, double y) {
    	super.setX(x + 0.5);
    	super.setY(y + 0.5);
    }
    
    public boolean collision() {
    	return collision;
    }
    
    public void reset() {
    	collision = false;
    	object = null;
    }
}