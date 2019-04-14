package model;

import behavior.behaviors.Collidable;
import game.Element;

public class ExplosionMiddenHor extends Element implements Collidable {
	
	private boolean collision;
	
	public ExplosionMiddenHor() {
        super("/resources/explosion_zijkant_horizontaal.png");
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