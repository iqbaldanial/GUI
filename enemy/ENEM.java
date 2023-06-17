package enemy;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class ENEM extends Entity{
	
	GamePanel gp;
	public ENEM(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type =2;
		name = "Enemy";
		speed =1;
		maxLife =4;
		life = maxLife;
		
		solidArea.x=3;
		solidArea.y=18;
		solidArea.height=30;
		solidArea.width=42;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		getImage();
	}
	public void getImage() {
	    try{
		      up1= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_1.png")) ; 
		      up2= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_2.png")) ; 
		      down1= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_1.png")) ; 
		      down2= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_2.png")) ; 
		      left1= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_1.png")) ; 
		      left2= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_2.png")) ; 
		      right1= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_1.png")) ; 
		      right2= ImageIO.read(getClass().getResourceAsStream("/enemy/greenslime_down_2.png")) ; 
		    }catch(IOException e){
		        e.printStackTrace();
		    }
	}
	public void setAction() {
		
		
		if(onPath == true) {
			
			checkStopChasingOrNot(gp.Player, 20, 100);
			
			searchPath(getGoalCol(gp.Player),getGoalRow(gp.Player));
		}
		else {
			checkStartChasingOrNot(gp.Player,5,100);
			getRandomDirection() ;
		     }
		}
	
	public void DamageReaction() {
		
		actionLockCounter =0;
		//direction = gp.Player.direction;
		onPath = true;
	}
}
