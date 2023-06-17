package entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.keyhandler;

public class player extends Entity {
    GamePanel gp;
    keyhandler keyH;
    
    public final int screenX;
    public final int screenY;
    int standCounter = 0;

public player(GamePanel gp,keyhandler keyH){
	super(gp);
    this.gp=gp;
    this.keyH=keyH;
    
    screenX = gp.screenWidth/2 - (gp.titleSize/2);
    screenY = gp.screenHeight/2 - (gp.titleSize/2);

    
    solidArea = new Rectangle();
    solidArea.x= 5;
    solidArea.y =14;
    solidArea.width=30;
    solidArea.height= 30;
    solidAreaDefaultX = solidArea.x;
    solidAreaDefaultY = solidArea.y;
    
    attackArea.width = 36;
    attackArea.height = 36;
    
    setDefaultValue();
    getPlayerImage();
    getPlayerAttackImage();
    
}

public void setDefaultValue(){
    worldX= gp.titleSize* 8;
    worldY=gp.titleSize * 8;
    speed =4;
    direction="down";
    
    //PLAYER STATUS
    maxLife =6;
    life = maxLife;
}
public void getPlayerImage(){
      up2= setup("/player/boy_up_2",gp.titleSize,gp.titleSize); 
      up1= setup("/player/boy_up_1",gp.titleSize,gp.titleSize); 
      down1= setup("/player/boy_down_1",gp.titleSize,gp.titleSize); 
      down2= setup("/player/boy_down_2",gp.titleSize,gp.titleSize); 
      left1= setup("/player/boy_left_1",gp.titleSize,gp.titleSize); 
      left2= setup("/player/boy_left_2",gp.titleSize,gp.titleSize); 
      right1= setup("/player/boy_right_1",gp.titleSize,gp.titleSize); 
      right2= setup("/player/boy_right_2",gp.titleSize,gp.titleSize);
        
}
public void getPlayerAttackImage() {
	
		  attackUp1 = setup("/player/boy_attack_up_1",gp.titleSize,gp.titleSize*2);
		  attackUp2=  setup("/player/boy_attack_up_2",gp.titleSize,gp.titleSize*2);   
	      attackDown1= setup("/player/boy_attack_down_1",gp.titleSize,gp.titleSize*2); 
	      attackDown2= setup("/player/boy_attack_down_2",gp.titleSize,gp.titleSize*2); 
	      attackLeft1= setup("/player/boy_attack_left_1",gp.titleSize*2,gp.titleSize); 
	      attackLeft2= setup("/player/boy_attack_left_2",gp.titleSize*2,gp.titleSize); 
	      attackRight1= setup("/player/boy_attack_right_1",gp.titleSize*2,gp.titleSize); 
	      attackRight2= setup("/player/boy_attack_right_2",gp.titleSize*2,gp.titleSize); 
	    }

public void update(){
	setAction();
		if(attacking == true) {
			attacking();
		}
		else if(keyH.up==true || keyH.down == true || keyH.left == true || keyH.right == true || keyH.enter ==true ) {
		if(keyH.up==true){
	         direction = "up";     
	    }
	    else if(keyH.down == true){
	         direction = "down";
	    }
	    else if(keyH.left == true){
	         direction = "left";
	    }
	    else if(keyH.right == true){
	         direction = "right";
	    }
		// checking tile collision
		collisionOn = false;
		gp.checker.checkTile(this);
		
		//checking npc collision
//		int npcIndex = gp.checker.checkEntity(this, gp.npc);
//		interactNPC(npcIndex);
		
		//checking enemy collision
		int enemyIndex = gp.checker.checkEntity(this, gp.enemy);
		contactEnemy(enemyIndex);
		interactNPC(enemyIndex);
		
		//check inteructive tile collision
		int iTileIndex = gp.checker.checkEntity(this, gp.iTile);
		
		gp.keyH.enter = false;
		
		//if collision if false, player can move
		if(collisionOn == false && keyH.enter ==false) {
			
			switch(direction) {
			case "up":
				worldY -= speed; 
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX+= speed;
				break;
			}
		}
	     spriteCounter++;
	     if(spriteCounter >12) {
	    	 if(spriteNum==1) {
	    		 spriteNum=2;
	    	 }
	    	 else if(spriteNum==2) {
	    		 spriteNum=1;
	    	 }
	    	 spriteCounter =0;
	     }
		}
		
     
}



public void damageInteracTile(int i) {
	if(i !=999 && gp.iTile[i].destructive == true) {
		//generate particle
		generateParticle(gp.iTile[i],gp.iTile[i]);
		
		gp.iTile[i] = gp.iTile[i].getDestroyedForm();
		

	}
	
}

public void interactNPC(int i) {
	if(gp.keyH.enter == true) {
		if(i!=999) {
			System.out.println("you're hitting an npc !");
		}
		else {	
				attacking = true;
		}
	}

}

public void contactEnemy(int i) {
	if( i!= 999) {
		if(invisible == false) {
			invisible = true;
		}
	}
}
public void damageEnemy(int i) {
	if(i !=999) {
	
		if(gp.enemy[i].invisible == false) {
			gp.enemy[i].life -=1;
			gp.enemy[i].invisible = true;
			gp.enemy[i].DamageReaction();
			
			if(gp.enemy[i].life <=0) {
				gp.enemy[i].die = true;
			}
		}
	}
}
public void draw(Graphics2D g2){
    
    BufferedImage image =null;
    int tempScreenX = screenX;
    int tempScreenY = screenY;
    switch(direction){
        case "up":
        	if(attacking == false) {
        		if(spriteNum ==1) {
            		image =up1;
            	}
        	
                if(spriteNum==2) {
                	image = up2;
                }
        	}
             if(attacking == true) {
            	 tempScreenY = screenY - gp.titleSize;
            	 if(spriteNum ==1) {
             		image =attackUp1;
             	}
                 if(spriteNum==2) {
                 	image = attackUp2;
                 }
                }
            break;
        case "down":
        	if(attacking == false) {
        		if(spriteNum ==1) {
            		image=down1;
            	}
                if(spriteNum==2) {
                	image = down2;
                }
        	}
        	if(attacking == true) {
        		if(spriteNum ==1) {
            		image=attackDown1;
            	}
                if(spriteNum==2) {
                	image = attackDown2;
                }
        	}
        
            break;
        case "left":
        	if(attacking == false) {
        		if(spriteNum ==1) {
            		image=left1;
            	}
                if(spriteNum==2) {
                	image=left2;
                }
        	}
        	if(attacking == true) {
        		tempScreenX = screenX - gp.titleSize;
        		if(spriteNum ==1) {
            		image=attackLeft1;
            	}
                if(spriteNum==2) {
                	image=attackLeft2;
                }
        	}
        	
            break;
        case "right":
        	if(attacking == false) {
        		if(spriteNum ==1) {
           		 image=right1;
           	}
               if(spriteNum==2) {
               	 image=right2;
               } 	
        	}
        	if(attacking == true) {
        		if(spriteNum ==1) {
           		 image=attackRight1;
           	}
               if(spriteNum==2) {
               	 image=attackRight2;
               } 
        	}
        	         
            break;
    }
    	
    	int x = screenX;
    	int y= screenY;
    	
    	if(screenX > worldX) {
    		x = worldX;
    	}
    	if(screenY > worldY) {
    		y = worldY;
    	}
		int rightOffset = gp.screenWidth - screenX;
		if(rightOffset > gp.WorldWidth - worldX) {
			x = gp.screenWidth-(gp.WorldWidth-worldX);
		}
		int bottomOffset = gp.screenHeight - screenY;
		
		if(bottomOffset > gp.WorldHeight - worldY) {
			y = gp.screenHeight-(gp.WorldHeight - worldY);
		}

    g2.drawImage(image, tempScreenX, tempScreenY, null);
    
   
        }
}
