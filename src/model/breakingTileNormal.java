package model;


import behavior.behaviors.Collidable;
import game.Tile;
import javafx.scene.image.Image;

public class breakingTileNormal extends Tile implements Collidable {
	
	private boolean collidable = true;
	
    public breakingTileNormal() {
        super("/resources/breakAble_breaking3.png");
    }

    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
    
    public void destroy() {
    	System.out.println("desroying tile");
    	String curDir = "file:/" + System.getProperty("user.dir") + "/src/resources/";
    	curDir = curDir.replace("\\","/");
    	curDir = curDir.replace(" ", "%20");
    	super.setImage(new Image(curDir + "grassTile2.png"));
    	collidable = false;
    }
    
    public boolean collidable() {
    	return collidable;
    }
}