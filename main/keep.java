package main;

public class keep {
//	package entity;
//
//
//
//	import java.io.IOException;
//
//	import javax.imageio.ImageIO;
//	import java.util.*;
//	import main.GamePanel;
//
//
//	public class NPC_1 extends Entity  {
//
//	    
//	    
//	    
//		public NPC_1(GamePanel gp) {
//			super(gp);	
//			direction = "down";
//			speed = 3;
//			getImage();
//			getAttack();
//		
//		}
//		public void getImage(){
//			up2= setup("/npc/boy_up_2",gp.titleSize,gp.titleSize); 
//		      up1= setup("/npc/boy_up_1",gp.titleSize,gp.titleSize); 
//		      down1= setup("/npc/boy_down_1",gp.titleSize,gp.titleSize); 
//		      down2= setup("/npc/boy_down_2",gp.titleSize,gp.titleSize); 
//		      left1= setup("/npc/boy_left_1",gp.titleSize,gp.titleSize); 
//		      left2= setup("/npc/boy_left_2",gp.titleSize,gp.titleSize); 
//		      right1= setup("/npc/boy_right_1",gp.titleSize,gp.titleSize); 
//		      right2= setup("/npc/boy_right_2",gp.titleSize,gp.titleSize);  
//		}
//	public void getAttack() {
//		  attackUp1 = setup("/player/boy_attack_up_1",gp.titleSize,gp.titleSize*2);
//		  attackUp2=  setup("/player/boy_attack_up_2",gp.titleSize,gp.titleSize*2);   
//	    attackDown1= setup("/player/boy_attack_down_1",gp.titleSize,gp.titleSize*2); 
//	    attackDown2= setup("/player/boy_attack_down_2",gp.titleSize,gp.titleSize*2); 
//	    attackLeft1= setup("/player/boy_attack_left_1",gp.titleSize*2,gp.titleSize); 
//	    attackLeft2= setup("/player/boy_attack_left_2",gp.titleSize*2,gp.titleSize); 
//	    attackRight1= setup("/player/boy_attack_right_1",gp.titleSize*2,gp.titleSize); 
//	    attackRight2= setup("/player/boy_attack_right_2",gp.titleSize*2,gp.titleSize); 
//	}
//		
//		public void setAction() {
//				onPath = true;
//				if(onPath == true) {
//					int goalCol = (gp.Player.worldX + gp.Player.solidArea.x)/gp.titleSize;
//					
//					int goalRow = (gp.Player.worldY + gp.Player.solidArea.y)/gp.titleSize;
//					
//					searchPath(goalCol,goalRow);
//				}
//				else {
//					actionLockCounter++;
//					
//					if(actionLockCounter == 120) {
//						Random rand = new Random();
//						int i = rand.nextInt(100)+1;
//						
//						if(i<=25) {
//							direction = "up";
//							
//						}
//						if(i>25 && i<=50) {
//							direction = "down";
//						}
//						if(i>50 && i<=75) {
//							direction = "left";
//						}
//						if(i>75 && i<=100) {
//							direction = "right";
//						}
//						actionLockCounter=0;
//					}
//			   }
//				}
//		}
//

		




}
