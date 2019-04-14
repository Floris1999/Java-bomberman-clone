package controller;

import engine.Engine;
import model.*;

import java.util.ArrayList;


public class BombControler {
	private static ArrayList<Bomb> bommen = new ArrayList<Bomb>();
	private static ArrayList<Bomb> bommenTemp = new ArrayList<Bomb>();
	private static ArrayList<Bomb> usedBommen = new ArrayList<Bomb>();
	private static int explosionRadius = 2;
	private static int radiusTimer = 0;
	
	public static void placeBombs(double x, double y){
		Bomb bomb;
		if(usedBommen.size() > 0 && !usedBommen.get(0).exploding())  {
			bomb = usedBommen.remove(0);
			bomb.reset();
			bomb.resetTimer();
			bommen.add(bomb);
		}
		else {
			bomb = new Bomb(explosionRadius);
			bommen.add(bomb);
			Engine.getGameGlobaly().getActiveLevel().getElements().add(bommen.get(bommen.size()-1));
		}
		bommen.get(bommen.size() - 1).setPosition(x, y);
	}
	
	public static void radiusIncrTimer() {
		radiusTimer++;
		if(radiusTimer == 100) {
			radiusTimer = 0;
			explosionRadius++;
		}
	}
	
	
	public static void bombIncrTimer() {
		for(Bomb bomb : bommen) {
			if(bomb.getCurTimer() != 7) {
				bomb.incrCurTimer();
				System.out.println(bomb.getCurTimer());
			}
			else {
				if(bomb.checked()) {
					bomb.explode();
					bomb.reset();
					bomb.setPosition(10000, 10000);
					bommenTemp.add(bomb);
					usedBommen.add(bomb);
				}
				else {
					bomb.checkTilesInRadius();
				}
			}
			if(bomb.exploding()) {
				bomb.incrExplosionTimer();
			}
		}
		for(Bomb bomb : bommenTemp) {
			bommen.remove(bomb);
		}
		bommenTemp.clear();
		for(Bomb bomb : usedBommen) {
			bomb.setRadius(explosionRadius);
			if(bomb.exploding()) {
				bomb.incrExplosionTimer();
			}
			else {
				bomb.reset();
			}
		}
	}
}



