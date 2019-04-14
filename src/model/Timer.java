package model;

import behavior.behaviors.Collidable;
import game.Element;
import controller.*;

public class Timer extends Element implements Collidable {
	
	private int timer;
	private static int totalTime;
	
	public Timer() {
        super("/resources/gridTile.png");
    }

	@Override
	public void handleCollision(Collidable col) {
		incrTimer();
	}
	
	public void incrTimer() {
    	timer++;
    	setTotalTime(getTotalTime() + 1);
    	if(timer == 60) {
    		timer = 0;
    		BombControler.bombIncrTimer();
			Player2.checkDamaged();
			Player1.checkDamaged();
			Player2.checkBombs();
			Player1.checkBombs();
			BombControler.radiusIncrTimer();
    	}
    }

	public static int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
}