package tile_interac;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class drytree extends interacTile {

	GamePanel gp;
	public drytree(GamePanel gp, int col, int row) {
		super(gp,col,row);
		this.gp =gp;
		
		this.worldX = gp.titleSize *col;
		this.worldY = gp.titleSize *row;
		down1 = setup("/tile_inteructive/drytree",gp.titleSize,gp.titleSize);
		destructive = true;
		
	}
	public interacTile getDestroyedForm() {
		interacTile tile = new itTruk(gp,worldX/gp.titleSize, worldY/gp.titleSize);
		return tile;
	}

	public Color getParticleColor() {
		Color color = new Color(65,50,30);
		return color;
	}
	public int getParticleSize() {
		int size=6;
		return size;
	}
	
	public int getParticleSpeed() {
		int speed =1;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}

}
