package model;


import behavior.behaviors.Collidable;
import behavior.behaviors.KeyBehavior;
import controller.BombControler;
import game.Element;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import controller.SoundControler;

import java.util.ArrayList;

public class Player1 extends Element implements Collidable, KeyBehavior {

    private double deltaY;
    private double deltaX;
    private int timeToWait = 7;
    private int curTime = 0;
    private int curMovement = 40;
    private boolean up = false;
    private boolean down = false;
    private boolean right = false;
    private boolean left = false;
    private String[] spritesNumber = new String[] {"1", "0", "2", "0"};
    private int curSprite = 1;
    private String spriteDirection = "steve_beneden_";
    private String spriteDir;
    private boolean spaceDown = false;
    private boolean placingBomb = false;
	private static int levensLink = 3;
	private static boolean damaged = false;
	private static int damageTimer;
	private static int bombsPlaced = 0;
	private static int bombTimer;
	private int bombsAmount = 3;
    
    private boolean isLoaded = false;
    
    public Player1() {
        super("/resources/steve_beneden_0.png");
        this.deltaY = 0;
        this.deltaX = 0;
    }
    
    @Override
    public void handleKeyPresses(ArrayList<String> arrayList) {
        handleMovement(arrayList);
//        SoundControler.getSound("footsteps").play();
    }

    @Override
    public void handleCollision(Collidable collidable) {
    	if (isLoaded == false) {
    		setInCentre();
    		isLoaded = true;
    		spriteDir = getClass().getResource("../resources/").toString();

        	spriteDir = spriteDir.replace("\\","/");
        	spriteDir = spriteDir.replace(" ", "%20");
    	}
    	
        if(collidable instanceof SandTile){
            super.setY(super.getY() - deltaY);
            super.setX(super.getX() - deltaX);
        }
        if(collidable instanceof breakingTileNormal && ((breakingTileNormal) collidable).collidable()){
            super.setY(super.getY() - deltaY);
            super.setX(super.getX() - deltaX);
        }
        if(collidable instanceof gridTile){
            super.setY(super.getY() - deltaY);
            super.setX(super.getX() - deltaX);
        }
		if (!damaged){
			if (collidable instanceof ExplosionBottom) {
				damaged = true;
			}
			if (collidable instanceof ExplosionLeft) {
				damaged = true;
			}
			if (collidable instanceof ExplosionMidden) {
				damaged = true;
			}
			if (collidable instanceof ExplosionMiddenHor) {
				damaged = true;
			}
			if (collidable instanceof ExplosionMiddenVert) {
				damaged = true;
			}
		}
    }
    
    public void handleMovement(ArrayList<String> arrayList) {
    	this.deltaX = 0;
        this.deltaY = 0;
        int tileSize = 80;
        int moveSpeed = 5;
        
        setCameraPosition();
        
        if(curTime > 0) {
        	curTime--;
        }
        
        if (arrayList.contains("SPACE")){

			if(!spaceDown) {
				spaceDown = true;
				placingBomb = true;
			}
    	
        }
        else {
        	spaceDown = false;
        }
        
        if (curMovement == tileSize/2) {
        	if(curSprite == 3) {
        		curSprite = 0;
        	}
        	if(curSprite == 1) {
        		curSprite = 2;
        	}
        	up = false;
            down = false;
            right = false;
            left = false;
        
	        if(arrayList.contains("UP")){
	        	if(curTime == 0) {
	        		up = true;
	        		curMovement = 0;
	        		curTime = timeToWait;
	        	}
	        }
	        else if(arrayList.contains("DOWN")){
	        	if(curTime == 0) {
	        		down = true;
	        		curMovement = 0;
	        		curTime = timeToWait;
	        	}
	        }
	        else if (arrayList.contains("RIGHT")){
	        	if(curTime == 0) {
	        		right = true;
	        		curMovement = 0;
	        		curTime = timeToWait;
	        	}
	        }
	        else if (arrayList.contains("LEFT")){
	        	if(curTime == 0) {
	        		left = true;
	        		curMovement = 0;
	        		curTime = timeToWait;
	        	}
	        }
	        else {
	        	SoundControler.getSound("footsteps").stop();
	        }
	        
	        if(placingBomb && bombsPlaced < bombsAmount) {
	        	BombControler.placeBombs(super.getX(), super.getY());
	        	bombsPlaced++;
	        }
	        placingBomb = false;
        
        }
        else {
			SoundControler.getSound("footsteps").play();
        	if(up) {
        		spriteDirection = "steve_boven_";
        		super.setY(super.getY() - moveSpeed);
        		curMovement += moveSpeed;
        		deltaY -= moveSpeed;
        		
        	}
        	if(down) {
        		spriteDirection = "steve_beneden_";
        		super.setY(super.getY() + moveSpeed);
        		curMovement += moveSpeed;
        		deltaY += moveSpeed;
        	}
        	if(right) {
        		spriteDirection = "steve_rechts_";
        		super.setX(super.getX() + moveSpeed);
        		curMovement += moveSpeed;
        		deltaX += moveSpeed;
        	}
        	if(left) {
        		spriteDirection = "steve_links_";
        		super.setX(super.getX() - moveSpeed);
        		curMovement += moveSpeed;
        		deltaX -= moveSpeed;
        	}
        	if(curMovement % 20 == 0) {
    			super.setImage(new Image(spriteDir + spriteDirection + spritesNumber[curSprite] + ".png"));
				curSprite++;
    			if(curSprite == 4) {
    				curSprite = 0;
    			}
    		} 	
        	setConstraints();
        }
        if(damaged) {
	        if((damageTimer - 1) % 2 == 0) {
	    		super.setImage(new Image(spriteDir + "checkTile" + ".png"));
	    	}
	    	else {
	    		super.setImage(new Image(spriteDir + spriteDirection + spritesNumber[curSprite] + ".png"));
	    	}
        }
    }
    
    public void setCameraPosition() {
    	double[] position = {super.getX(), super.getY()};
    	Camera.posPlayer1(position);
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
    
    public void setInCentre() {
    	super.setY(super.getY() + 1);
		super.setX(super.getX() + 1);
    }
    
    public void setConstraints() {
    	int constraintRight = (int) (Camera.rightScreen - (Camera.rightScreen % 40)); 
    	int constraintLeft = (int) (Camera.leftScreen - (Camera.leftScreen % 40)); 
    	int constraintBottom = (int) (Camera.bottomScreen - (Camera.bottomScreen % 40)); 
    	int constraintTop = (int) (Camera.topScreen - (Camera.topScreen % 40)); 
    	
    	if(super.getX() + 79 > constraintRight || super.getX() < constraintLeft) {
    		super.setX(super.getX() - deltaX);
    	}
    	
    	if(super.getY() + 79 > constraintBottom || super.getY() < constraintTop) {
    		super.setY(super.getY() - deltaY);
    	}
    }
    
    public static void checkBombs() {
    	if(bombsPlaced > 0) {
    		bombTimer++;
    		if(bombTimer == 7) {
    			bombTimer = 0;
    			bombsPlaced--;
    		}
    	}
    }
    
	public static void checkDamaged(){
		if(damaged){
			damageTimer++;
			if(damageTimer == 9){
				damaged = false;
				levensLink--;
				wieWint(levensLink);
				damageTimer = 0;
			}
		}
	}

	static impl.Highscores highscore = new impl.Highscores();
	public static void wieWint(int levenLink){
		if(levenLink == 0){
			System.out.println("Player 2 heeft gewonnen");

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Player 1 wins!!!   met een score van :" + Timer.getTotalTime());
			alert.show();

			//highscore.setHighscores(Timer.getTotalTime(),"player 1");
			highscore.setHighscores(Timer.getTotalTime(),"player 1");
			alert.show();

		}else{
			System.out.println("Leven player 2: "+ levenLink);
		}
	}
}

