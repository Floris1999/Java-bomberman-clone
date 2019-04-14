package model;

import behavior.behaviors.Collidable;
import game.Element;

public class Camera extends Element implements Collidable{

	private static double[] posPlayer1 = {0, 0};
	private static double[] posPlayer2 = {0, 0};
	public static double rightScreen = 1040;
	public static double leftScreen;
	public static double bottomScreen = 800;
	public static double topScreen;
	private static double widthScreen = 1040;
	private static double heightScreen = 800;
	private static int widthMap = 80*15;
	private static int heightMap = 80*15;
	private boolean initialize = true;
	
	public Camera() {
		super("/resources/checkTile.png");
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setPosition(int x, int y) {
		super.setX(x);
		super.setY(y);
	}
	
	public static void posPlayer1(double[] pos) {
		posPlayer1 = pos;
	}
	
	public static void posPlayer2(double[] pos) {
		posPlayer2 = pos;
	}
	
	public void setCameraPos() {
		int tileSize = 80;
		double x = (posPlayer1[0] + posPlayer2[0]) /2;
		double y = (posPlayer1[1] + posPlayer2[1]) /2;
		if(initialize) {
			super.setX(x);
			super.setY(y);
			initialize = false;
		}
		double deltaX = x - super.getX();
		double deltaY = y - super.getY();
		super.setX(x);
		super.setY(y);
		
		if(x > rightScreen - 8.5*tileSize && x < rightScreen - 4.5*tileSize) {
			if(rightScreen > widthMap) {
				rightScreen = widthMap;
			}
			if(rightScreen < 1040) {
				rightScreen = 1040;
			}
		}
		else {
			if(rightScreen >= 1040 && rightScreen <= widthMap) {
				System.out.println(rightScreen);
				rightScreen += deltaX;
			}
		}
	
		if(y > bottomScreen - 6.5*tileSize && y < bottomScreen - 3.5*tileSize) {
			if(bottomScreen > heightMap) {
				bottomScreen = heightMap;
			}
			if(bottomScreen < 800) {
				bottomScreen = 800;
			}
		}
		else {
			if(bottomScreen >= 800 && bottomScreen <= heightMap) {
				System.out.println(bottomScreen);
				bottomScreen +=deltaY;
			}
		}
		leftScreen = rightScreen - widthScreen;
		topScreen = bottomScreen - heightScreen;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

	@Override
	public void handleCollision(Collidable arg0) {
		setCameraPos();
	}

}
