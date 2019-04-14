package model;

import behavior.behaviors.Collidable;
import behavior.behaviors.KeyBehavior;
import game.Element;

import java.util.ArrayList;

public class Centre extends Element implements Collidable, KeyBehavior {

    public Centre(String imagePath) {
		super(imagePath);
	}

	@Override
	public void handleKeyPresses(ArrayList<String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCollision(Collidable arg0) {
		// TODO Auto-generated method stub
		
	}
}

