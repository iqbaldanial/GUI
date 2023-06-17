package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class particle extends Entity {

	Entity generator;
	Color color;
	int xd,yd,size ;
	
	
	public particle(GamePanel gp,Entity generator,Color color, int size,int speed, int maxLife, int xd, int yd) {
		super(gp);
		
		this.generator=generator;
		this.color=color;
		this.speed=speed;
		this.xd=xd;
		this.yd=yd;
		this.size=size;
		
		int offset = (gp.titleSize/2) - (size/2);
		life = maxLife;
		worldX = generator.worldX + offset;
		worldY = generator.worldY + offset;
	}
	public void update(){
		
		if(life<maxLife/3) {
			yd++;
		}
		life--;
		worldX += xd*speed;
		worldY += yd*speed;
		if(life == 0) {
			alive = false;
		}
	}
	public void draw(Graphics2D g2) {
		
		int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
		int screenY = worldY - gp.Player.worldY + gp.Player.screenY;
		
		g2.setColor(color);
		g2.fillRect(screenX, screenY, size, size);
	}
}


