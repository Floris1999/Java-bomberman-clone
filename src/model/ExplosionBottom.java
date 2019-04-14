package model;

import behavior.behaviors.Collidable;
import game.Element;

public class ExplosionBottom extends Element implements Collidable {
	
	private boolean collision;
	
	public ExplosionBottom() {
        super("/resources/explosion_eind_onder.png");
        collision = false;
    }

	@Override
	public void handleCollision(Collidable col) {
		if(col instanceof gridTile){
            collision = true;
        }
	}
	
	public boolean getCollision() {
		return collision;
	}
	
	public void setPosition(double x, double y) {
    	super.setX(x);
    	super.setY(y);
    }
}
