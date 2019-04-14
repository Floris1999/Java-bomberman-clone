package model;

import behavior.behaviors.Collidable;
import engine.Engine;
import game.Element;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class Bomb extends Element implements Collidable {


	private ArrayList<checkTile> checkTilesUp = new ArrayList<checkTile>();
	private ArrayList<checkTile> checkTilesDown = new ArrayList<checkTile>();
	private ArrayList<checkTile> checkTilesRight = new ArrayList<checkTile>();
	private ArrayList<checkTile> checkTilesLeft = new ArrayList<checkTile>();
	private static ArrayList<ExplosionLeft> leftExplosion = new ArrayList<ExplosionLeft>();
	private static ArrayList<ExplosionBottom> downExplosion = new ArrayList<ExplosionBottom>();
	private static ArrayList<ExplosionRight> rightExplosion = new ArrayList<ExplosionRight>();
	private static ArrayList<ExplosionTop> topExplosion = new ArrayList<ExplosionTop>();
	private static ArrayList<ExplosionMiddenHor> horExplosion = new ArrayList<ExplosionMiddenHor>();
	private static ArrayList<ExplosionMiddenVert> vertExplosion = new ArrayList<ExplosionMiddenVert>();
	private static ArrayList<ExplosionMidden> midExplosion = new ArrayList<ExplosionMidden>();
	
	
	private ArrayList<Element> GameElements = Engine.getGameGlobaly().getActiveLevel().getElements();
    private int explosionTimer = 0;
    private int curTimer = 0;
    private int explosionRadius;
    private boolean checked = false;
    private boolean exploding = false;
    private boolean exploded = false;

    public Bomb(int radius) {
        super("/resources/apple_1.gif");
        this.explosionRadius = radius;
    }
    
    public int getRadius() {
    	return explosionRadius;
    }

    public void incrCurTimer() {
    	curTimer++;
    }
    
    public void setRadius(int radius) {
    	explosionRadius = radius;
    }
    
    public void resetTimer() {
    	curTimer = 0;
    	exploded = false;
    }
    
    public boolean exploding() {
    	return exploding;
    }
    
    public boolean exploded() {
    	return exploded;
    }
    

    @Override
    public void handleCollision(Collidable collidable) {
    }
    
    public void setPosition(double x, double y) {
    	System.out.println("bomb placed at: x " + x +" and y " + y);
    	System.out.println("");
    	super.setX(x);
    	super.setY(y);
    	System.out.println("----- checkTiles info ----");
    	System.out.println("size of using: " + (checkTilesUp.size() + checkTilesDown.size() + checkTilesRight.size() + checkTilesLeft.size()));
    	System.out.println("size of stored: " + (objectsManager.checkTilesUpR.size() + objectsManager.checkTilesDownR.size() + objectsManager.checkTilesRightR.size() + objectsManager.checkTilesLeftR.size()));
    	System.out.println("");
    	System.out.println("----- Explosions info ----");
    	System.out.println("size of using: " + (horExplosion.size() + vertExplosion.size() + rightExplosion.size() + leftExplosion.size() + downExplosion.size() + topExplosion.size() + midExplosion.size()));
    	System.out.println("size of stored: " + (objectsManager.horExplosionR.size() + objectsManager.vertExplosionR.size() + objectsManager.rightExplosionR.size() + objectsManager.leftExplosionR.size() + objectsManager.downExplosionR.size() + objectsManager.topExplosionR.size() + objectsManager.midExplosionR.size()));;
    	
    }
    
    public int getCurTimer() {
    	return curTimer;
    }
    
    public double[] getPosition() {
    	double[] position = {super.getX(), super.getY()};
    	return position;
    	
    }
    
    public boolean checked() {
    	return checked;
    }
    
    public void checkTilesInRadius() throws ConcurrentModificationException {
    	for (int i = 0; i < getRadius(); i++) {
			System.out.println("placing checkTiles on radius: " + (i + 1) + "...");
			
			checkTile check1;
			if(objectsManager.checkTilesUpR.size() > 0) {
				check1 = objectsManager.checkTilesUpR.remove(0);
				check1.reset();
				checkTilesUp.add(check1);
			}
			else {
				check1 = new checkTile();
				checkTilesUp.add(check1);
				GameElements.add(check1);
			}		
			check1.setPosition(super.getX(), super.getY() - 40 - 40*i);
			
			checkTile check2;
			if(objectsManager.checkTilesDownR.size() > 0) {
				check2 = objectsManager.checkTilesDownR.remove(0);
				check2.reset();
				checkTilesDown.add(check2);
			}
			else {
				check2 = new checkTile();
				checkTilesDown.add(check2);
				GameElements.add(check2);
			}	
			check2.setPosition(super.getX(), super.getY() + 40 + 40*i);
			
			checkTile check3;
			if(objectsManager.checkTilesRightR.size() > 0) {
				check3 = objectsManager.checkTilesRightR.remove(0);
				check3.reset();
				checkTilesRight.add(check3);
			}
			else {
				check3 = new checkTile();
				checkTilesRight.add(check3);
				GameElements.add(check3);
			}	
			check3.setPosition(super.getX() + 40 + 40*i, super.getY());
			
			checkTile check4;
			if(objectsManager.checkTilesLeftR.size() > 0) {
				check4 = objectsManager.checkTilesLeftR.remove(0);
				check4.reset();
				checkTilesLeft.add(check4);
			}
			else {
				check4 = new checkTile();
				checkTilesLeft.add(check4);
				GameElements.add(check4);
			}		
			check4.setPosition(super.getX() - 40 - 40*i, super.getY());
		}
    	checked = true;
	}
    
    public void explode() throws ConcurrentModificationException {
    	int tilesUp = 0;
    	int tilesDown = 0;
    	int tilesRight = 0;
    	int tilesLeft = 0;
    	
    	exploding = true;
    	System.out.println("");
    	for(checkTile check : checkTilesUp) {
    		if(check.getObject() instanceof breakingTileNormal) {
    			if(!((breakingTileNormal) check.getObject()).collidable()) {
    				tilesUp++;
    			}
    			else {
    				breakingTileNormal tile = (breakingTileNormal) check.getObject();
    				check.setPosition(10000, 10000);
        			System.out.println("collision found for Up, amount of sprites to place: " + tilesUp);
					tile.destroy();
					break;
    			}
    		}
    		else if(!check.collision()) {
    			tilesUp++;
    		}
    		else {
    			check.setPosition(10000, 10000);
    			System.out.println("collision found for Up, amount of sprites to place: " + tilesUp);
    			break;
    		}
    		check.setPosition(10000, 10000);
    	}
    	
    	for(checkTile check : checkTilesDown) {
    		if(check.getObject() instanceof breakingTileNormal) {
    			System.out.println("ja");
    			if(!((breakingTileNormal) check.getObject()).collidable()) {
    				tilesDown++;
    			}
    			else {
    				breakingTileNormal tile = (breakingTileNormal) check.getObject();
    				check.setPosition(10000, 10000);
        			System.out.println("collision found for Down, amount of sprites to place: " + tilesDown);
					tile.destroy();
					break;
    			}
    		}
    		else if(!check.collision()) {
    			tilesDown++;
    		}
    		else {
    			check.setPosition(10000, 10000);
    			System.out.println("collision found for Down, amount of sprites to place: " + tilesDown);
    			break;
    		}
    		check.setPosition(10000, 10000);
    	}
    	for(checkTile check : checkTilesRight) {
    		if(check.getObject() instanceof breakingTileNormal) {
    			if(!((breakingTileNormal) check.getObject()).collidable()) {
    				tilesRight++;
    			}
    			else {
    				breakingTileNormal tile = (breakingTileNormal) check.getObject();
    				check.setPosition(10000, 10000);
        			System.out.println("collision found for Right, amount of sprites to place: " + tilesRight);
					tile.destroy();
					break;
    			}
    		}
    		else if(!check.collision()) {
    			tilesRight++;
    		}
    		else {
    			check.setPosition(10000, 10000);
    			System.out.println("collision found for Left, amount of sprites to place: " + tilesRight);
    			break;
    		}
    		check.setPosition(10000, 10000);
    	}
    	for(checkTile check : checkTilesLeft) {
    		if(!check.collision()) {
    			tilesLeft++;
    		}
    		else {
    			if(check.getObject() instanceof breakingTileNormal) {
        			if(!((breakingTileNormal) check.getObject()).collidable()) {
        				tilesLeft++;
        			}
        			else {
        				breakingTileNormal tile = (breakingTileNormal) check.getObject();
        				check.setPosition(10000, 10000);
            			System.out.println("collision found for Left, amount of sprites to place: " + tilesLeft);
    					tile.destroy();
    					break;
        			}
        		}
    			else {
	    			check.setPosition(10000, 10000);
	    			System.out.println("collision found for right, amount of sprites to place: " + tilesLeft);
	    			break;
    			}
    		}
    		check.setPosition(10000, 10000);
    	}
    	
    	objectsManager.checkTilesLeftR.addAll(checkTilesLeft);
    	checkTilesLeft.clear();
    	objectsManager.checkTilesRightR.addAll(checkTilesRight);
    	checkTilesRight.clear();
    	objectsManager.checkTilesDownR.addAll(checkTilesDown);
    	checkTilesDown.clear();
    	objectsManager.checkTilesUpR.addAll(checkTilesUp);
    	checkTilesUp.clear();
    	
    	System.out.println("");
    	System.out.println("placing " + (tilesUp + tilesDown + tilesRight + tilesLeft + 1) + " sprites...");
    	System.out.println("");
    	
    	ExplosionMidden spriteMid = new ExplosionMidden();
		midExplosion.add(spriteMid);
		GameElements.add(spriteMid);
		midExplosion.get(midExplosion.size()-1).setPosition(super.getX() + 1, super.getY() + 1);
    	
    	for(int i = 0; i < tilesUp; i++) {
    		if(i == tilesUp - 1) {
    			ExplosionTop sprite;
    			if(objectsManager.topExplosionR.size() > 0) {
    				sprite = objectsManager.topExplosionR.remove(0);
    				topExplosion.add(sprite);
    			}
    			else {
    				sprite = new ExplosionTop();
    				topExplosion.add(sprite);
    	    		GameElements.add(sprite);
    			}
	    		sprite.setPosition(super.getX() + 5, super.getY() - 39 - 40*i);
    		}
    		else {
    			ExplosionMiddenVert sprite;
    			if(objectsManager.vertExplosionR.size() > 0) {
    				sprite = objectsManager.vertExplosionR.remove(0);
    				vertExplosion.add(sprite);
    			}
    			else {
	    		sprite = new ExplosionMiddenVert();
				vertExplosion.add(sprite);
	    		GameElements.add(sprite);
    			}
	    		vertExplosion.get(vertExplosion.size()-1).setPosition(super.getX() + 5, super.getY() - 39 - 40*i);
    		}
    	}
    	
    	for(int i = 0; i < tilesDown; i++) {
    		if(i == tilesDown - 1) {
    			ExplosionBottom sprite;
    			if(objectsManager.downExplosionR.size() > 0) {
    				sprite = objectsManager.downExplosionR.remove(0);
    				downExplosion.add(sprite);
    			}
    			else {
		    		sprite = new ExplosionBottom();
					downExplosion.add(sprite);
		    		GameElements.add(sprite);
    			}
	    		downExplosion.get(downExplosion.size()-1).setPosition(super.getX() + 5, super.getY() + 79 + 40*i);
    		}
    		else {
    			ExplosionMiddenVert sprite;
    			if(objectsManager.vertExplosionR.size() > 0) {
    				sprite = objectsManager.vertExplosionR.remove(0);
    				vertExplosion.add(sprite);
    			}
    			else {
		    		sprite = new ExplosionMiddenVert();
					vertExplosion.add(sprite);
		    		GameElements.add(sprite);
    			}
	    		vertExplosion.get(vertExplosion.size()-1).setPosition(super.getX() + 5, super.getY() + 79 + 40*i);
    		}
    	}
    	
    	for(int i = 0; i < tilesRight; i++) {
    		if(i == tilesRight - 1) {
    			ExplosionRight sprite;
    			if(objectsManager.rightExplosionR.size() > 0) {
    				sprite = objectsManager.rightExplosionR.remove(0);
    				rightExplosion.add(sprite);
    			}
    			else {
		    		sprite = new ExplosionRight();
					rightExplosion.add(sprite);
		    		GameElements.add(sprite);
    			}
	    		rightExplosion.get(rightExplosion.size()-1).setPosition(super.getX() + 79 + 40*i, super.getY() + 5);
    		}
    		else {
    			ExplosionMiddenHor sprite;
    			if(objectsManager.horExplosionR.size() > 0) {
    				sprite = objectsManager.horExplosionR.remove(0);
    				horExplosion.add(sprite);
    			}
    			else {
		    		sprite = new ExplosionMiddenHor();
					horExplosion.add(sprite);
		    		GameElements.add(sprite);
    			}
	    		horExplosion.get(horExplosion.size()-1).setPosition(super.getX() + 79 + 40*i, super.getY() + 5);
    		}
    	}
    	
    	for(int i = 0; i < tilesLeft; i++) {
    		if(i == tilesLeft - 1) {
    			ExplosionLeft sprite;
    			if(objectsManager.leftExplosionR.size() > 0) {
    				sprite = objectsManager.leftExplosionR.remove(0);
    				leftExplosion.add(sprite);
    			}
    			else {
		    		sprite = new ExplosionLeft();
					leftExplosion.add(sprite);
		    		GameElements.add(sprite);
    			}
	    		leftExplosion.get(leftExplosion.size()-1).setPosition(super.getX() - 39 - 40*i, super.getY() + 5);
    		}
    		else {
    			ExplosionMiddenHor sprite;
    			if(objectsManager.horExplosionR.size() > 0) {
    				sprite = objectsManager.horExplosionR.remove(0);
    				horExplosion.add(sprite);
    			}
    			else {
		    		sprite = new ExplosionMiddenHor();
					horExplosion.add(sprite);
		    		GameElements.add(sprite);
    			}
	    		horExplosion.get(horExplosion.size()-1).setPosition(super.getX() - 39 - 40*i, super.getY() + 5);
    		}
    	}
    }
    
    public void incrExplosionTimer() {
    	explosionTimer++;
    	if(explosionTimer == 4) {
    		removeSprites();
    		exploding = false;
    	}
    }
    
    public void removeSprites() {
    	
    	exploded = true;
    	
    	for(ExplosionLeft sprite : leftExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	for(ExplosionRight sprite : rightExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	for(ExplosionTop sprite : topExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	for(ExplosionBottom sprite : downExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	for(ExplosionMiddenHor sprite : horExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	for(ExplosionMiddenVert sprite : vertExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	for(ExplosionMidden sprite : midExplosion) {
    		sprite.setPosition(10000,10000);
    	}
    	
    	objectsManager.downExplosionR.addAll(downExplosion);
    	objectsManager.topExplosionR.addAll(topExplosion);
    	objectsManager.rightExplosionR.addAll(rightExplosion);
    	objectsManager.leftExplosionR.addAll(leftExplosion);
    	objectsManager.horExplosionR.addAll(horExplosion);
    	objectsManager.vertExplosionR.addAll(vertExplosion);
    	objectsManager.midExplosionR.addAll(midExplosion);
    	downExplosion.clear();
    	topExplosion.clear();
    	leftExplosion.clear();
    	rightExplosion.clear();
    	vertExplosion.clear();
    	horExplosion.clear();
    	midExplosion.clear();
    	
    	
    }
    
    public void reset() {
    	checked = false;
    	explosionTimer = 0;
    
    }
}
