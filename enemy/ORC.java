package enemy;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class ORC extends Entity {
	GamePanel gp;
	public ORC(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type =3;
		name = "orc";
		speed =1;
		maxLife =4;
		life = maxLife;
		
		solidArea.x=4;
		solidArea.y=4;
		solidArea.height=40;
		solidArea.width=44;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		attackArea.height = 48;
		attackArea.width=48;
		getImage();
		getAttackImage();
	}
	public void getImage() {
	      up2= setup("/Enem/boy_up_2",gp.titleSize,gp.titleSize); 
	      up1= setup("/Enem/boy_up_1",gp.titleSize,gp.titleSize); 
	      down1= setup("/Enem/boy_down_1",gp.titleSize,gp.titleSize); 
	      down2= setup("/Enem/boy_down_2",gp.titleSize,gp.titleSize); 
	      left1= setup("/Enem/boy_left_1",gp.titleSize,gp.titleSize); 
	      left2= setup("/Enem/boy_left_2",gp.titleSize,gp.titleSize); 
	      right1= setup("/Enem/boy_right_1",gp.titleSize,gp.titleSize); 
	      right2= setup("/Enem/boy_right_2",gp.titleSize,gp.titleSize);
	}
	public void getAttackImage() {
		  attackUp1 = setup("/Enem/boy_attack_up_1",gp.titleSize,gp.titleSize*2);
		  attackUp2=  setup("/Enem/boy_attack_up_2",gp.titleSize,gp.titleSize*2);   
	      attackDown1= setup("/Enem/boy_attack_down_1",gp.titleSize,gp.titleSize*2); 
	      attackDown2= setup("/Enem/boy_attack_down_2",gp.titleSize,gp.titleSize*2); 
	      attackLeft1= setup("/Enem/boy_attack_left_1",gp.titleSize*2,gp.titleSize); 
	      attackLeft2= setup("/Enem/boy_attack_left_2",gp.titleSize*2,gp.titleSize); 
	      attackRight1= setup("/Enem/boy_attack_right_1",gp.titleSize*2,gp.titleSize); 
	      attackRight2= setup("/Enem/boy_attack_right_2",gp.titleSize*2,gp.titleSize); 
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
		
		if(attacking == false) {
			checkAttackOrNot(30,gp.titleSize*4, gp.titleSize);
		}
     }
	
	public void DamageReaction() {
		
		actionLockCounter =0;
		//direction = gp.Player.direction;
		onPath = true;
	}
}
