package entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;
import tile.Tile;

public class Entity {
	
    public int worldX,worldY;
    public int speed;
    GamePanel gp; 
    public BufferedImage up1, up2, down1, down2, left1, left2, right1,right2;
    public BufferedImage attackUp1, attackUp2, attackDown1, 
    attackDown2, attackLeft1,attackLeft2, attackRight1, attackRight2;
    public String direction = "down";
    public int solidAreaDefaultX, solidAreaDefaultY; 
    public int spriteCounter =0;
    public int spriteNum = 1;   
    public  Rectangle solidArea = new Rectangle(5,14,30,30);  
    public boolean collisionOn = false;
    public int actionLockCounter =0;
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public boolean invisible = false;
    public int invisibleCounter =0;
    public int dyingCounter =0;
    public int hpBarCounter =0;
    public boolean attacking = false;
    public boolean alive = true;
    public boolean die = false;
    public boolean HPBar = false;
    public boolean onPath =false;
  
    
    
    //character
    public int type;
    public int maxLife;
    public int life;
    public String name;
    public Entity(GamePanel gp) {
    	this.gp = gp;
    }
    public int getXDistance(Entity entity) {
    	int xDistance = Math.abs(worldX - entity.worldX);
    	return xDistance;
    }
    public int getYDistance(Entity entity) {
    	int yDistance = Math.abs(worldY - entity.worldY);
    	return yDistance;
    }
    public int getTileDistance(Entity target) {
    	int tileDistance = (getXDistance(target) + getYDistance(target))/gp.titleSize;
    	return tileDistance;
    }
    public  int getGoalCol(Entity entity) {
    	int goalCol = (entity.worldX + entity.solidArea.x)/gp.titleSize;
    	return goalCol;
    }
    public int getGoalRow(Entity entity) {
    	int goalRow = (entity.worldY + entity.solidArea.y)/gp.titleSize;
    	return goalRow;
    }
    public void setAction() {
    	
    }
    
    public void DamageReaction () {
    	
    }
    public void checkCollision() {
    	collisionOn = false;
    	gp.checker.checkPlayer(this);
    	gp.checker.checkTile(this);
    	gp.checker.checkEntity(this, gp.npc);
    	gp.checker.checkEntity(this, gp.enemy);
    	
    }
    public void checkStartChasingOrNot(Entity target, int distance, int rate) {
    	
    	if(getTileDistance(target) < distance) {
    		int i = new Random().nextInt(rate);
    		if(i ==0) {
    			onPath = true;
    		}
    	}
    }
    public void attacking() {
    	spriteCounter++;
    	
    	if(spriteCounter <=5) {
    		spriteNum = 1;
    	}
    	if(spriteCounter > 5 && spriteCounter <= 25) {
    		spriteNum =2;
    		
    		
    		int currentWorldX = worldX;
    		int currentWorldY = worldY;
    		int solidAreaWidth = solidArea.width;
    		int solidAreaHeight = solidArea.height;
    		switch(direction) {
    		
    		case "up":
    			worldY -= attackArea.height;
    			break;
    		case "down":
    			worldX += attackArea.height;
    			break;
    		case "left":
    			worldX -= attackArea.height;
    			break;
    		case "right":
    			worldX += attackArea.height;
    			break;
    		}
    		solidArea.width = attackArea.width;
    		solidArea.height = attackArea.height;
    		
    		if(type == 3) {
    			if(gp.checker.checkPlayer(this)== true) {
    				
    			}
    		}
    		else {
    	  		int enemyIndex = gp.checker.checkEntity(this, gp.enemy);
        		gp.Player.damageEnemy(enemyIndex);
        		
        		int iTileIndex = gp.checker.checkEntity(this, gp.iTile);
        		gp.Player.damageInteracTile(iTileIndex);
    		}
  
    		worldX = currentWorldX;
    		worldY = currentWorldY;
    		solidArea.width = solidAreaWidth;
    		solidArea.height = solidAreaHeight;
    		
    		
    	}
    	if(spriteCounter >25) {
    		spriteNum = 1;
    		spriteCounter =0;
    		attacking = false;
    	}
    	
    }
    public void checkAttackOrNot(int rate, int straight, int horizontal) {
    	
    	boolean targetInRange = false;
    	int xDistance = getXDistance(gp.Player);
    	int yDistance = getYDistance(gp.Player);
    	
    	switch(direction) {
    	case "up":
    		if(gp.Player.worldY < worldY && yDistance < straight && xDistance < horizontal) {
    			
    			targetInRange = true;
    		}
    		break;
    		
      	case "down":
    		if(gp.Player.worldY > worldY && yDistance < straight && xDistance < horizontal) {
    			
    			targetInRange = true;
    		}
    		break;
      	case "left":
    		if(gp.Player.worldX < worldX && xDistance < straight && yDistance < horizontal) {
    			
    			targetInRange = true;
    		}
    		break;
      	case "right":
    		if(gp.Player.worldX > worldX && xDistance < straight && yDistance < horizontal) {
    			
    			targetInRange = true;
    		}
    		break;
    	}
    	
    	if(targetInRange == true) {
    		
    		int i = new Random().nextInt(rate);
    		if(i ==0) {
    			attacking = true;
    			spriteNum = 1;
    			spriteCounter =0;
    			
    		}
    	}
    }
    public void getRandomDirection() {
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random rand = new Random();
			int i = rand.nextInt(100)+1;
			
			if(i<=25) {
				direction = "up";		
			}
			if(i>25 && i<=50) {
				direction = "down";
			}
			if(i>50 && i<=75) {
				direction = "left";
			}
			if(i>75 && i<=100) {
				direction = "right";
			}
			actionLockCounter=0;
		}
    }
    
    public void checkStopChasingOrNot(Entity target, int distance, int rate) {
    	
    	if(getTileDistance(target) > distance) {
    		int i = new Random().nextInt(rate);
    		if(i ==0) {
    			onPath = false;
    		}
    	}
    }
    public void update() {
    	if(attacking ==true) {
    		attacking();
    	}
    	else {
    		setAction();
        	checkCollision();
        	boolean contactPlayer = gp.checker.checkPlayer(this);
        	
        	if(this.type ==2 && contactPlayer == true) {
        		if(gp.Player.invisible == false) {
        			
        			gp.Player.invisible = true;
        		}
        	}
    		//if collision if false, player can move
    		if(collisionOn == false) {
    			
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
	     if(invisible ==true) {
	    	 invisibleCounter++;
	    	 if(invisibleCounter >40) {
	    		 invisible = false;
	    		 invisibleCounter =0;
	    	 }
	     }
    	
    }
	public Color getParticleColor() {
		Color color = null;
		return color;
	}
	public int getParticleSize() {
		int size=0;
		return size;
	}
	
	public int getParticleSpeed() {
		int speed =0;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 0;
		return maxLife;
	}
    
	public void generateParticle(Entity generator, Entity target) {
		Color color = generator.getParticleColor();
		int size = generator.getParticleSize();
		int speed = generator.getParticleSpeed();
		int maxLife = generator.getParticleMaxLife();
		
		particle p1 = new particle(gp,target, color, size,speed,maxLife,-2,-1);
		particle p2 = new particle(gp,target, color, size,speed,maxLife,2,-1);
		particle p3 = new particle(gp,target, color, size,speed,maxLife,-2,1);
		particle p4 = new particle(gp,target, color, size,speed,maxLife,2,1);
		
		gp.particleList.add(p1);
		gp.particleList.add(p2);
		gp.particleList.add(p3);
		gp.particleList.add(p4);
	}
    
    public void draw(Graphics2D g2) {
    	BufferedImage image =null;
		int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
		int screenY = worldY - gp.Player.worldY + gp.Player.screenY;

		//STOP THE CAMERA FROM MOVING AT THE EDGE
		if(gp.Player.screenX >gp.Player.worldX) {
			screenX = worldX;
		}
		if(gp.Player.screenY > gp.Player.worldY) {
			screenY = worldY;
		}
		int rightOffset = gp.screenWidth - gp.Player.screenX;
		if(rightOffset > gp.WorldWidth - gp.Player.worldX) {
			screenX = gp.screenWidth-(gp.WorldWidth-worldX);
		}
		int bottomOffset = gp.screenHeight - gp.Player.screenY;
		
		if(bottomOffset > gp.WorldHeight - gp.Player.worldY) {
			screenY = gp.screenHeight-(gp.WorldHeight - worldY);
		}
		if(worldX + gp.titleSize > gp.Player.worldX - gp.Player.screenX && 
				worldX - gp.titleSize <gp.Player.worldX + gp.Player.screenX &&
				worldY + gp.titleSize > gp.Player.worldY - gp.Player.screenY &&
				worldY - gp.titleSize < gp.Player.worldY + gp.Player.screenY) {
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
		    
		    if(type ==3 && HPBar == true) {
		    	double oneScale = (double)gp.titleSize/maxLife;
		    	double hpBarVal = oneScale*life;
		    	g2.setColor(new Color(35,35,35));
		    	g2.fillRect(screenX-1, screenY-16, gp.titleSize+2, 12);
		    	
		    	
		    	g2.setColor(new Color(255,0,30));
			    g2.fillRect(screenX, screenY -15,(int) hpBarVal, 10);
			    
			    hpBarCounter ++;
			    if(hpBarCounter > 600) {
			    	hpBarCounter =0;
			    	HPBar = false;
			    }
		    }
		    
			
		    if(invisible == true) {
		    	HPBar = true;
		    	hpBarCounter =0;
		    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.4f));
		    }
		    if(die == true) {
		    	dyingAnimation(g2);
		    }
		    g2.drawImage(image, tempScreenX, tempScreenY,null);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
			
			
			
		}
    }
    
    private void dyingAnimation(Graphics2D g2) {
		
    	dyingCounter++;
    	if(dyingCounter <= 5) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));
    	}
    	if(dyingCounter > 5 && dyingCounter <=10 ) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    	}
    	if(dyingCounter > 15 && dyingCounter <=20 ) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));
    	}
    	if(dyingCounter > 20 && dyingCounter <=25 ) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    	}
    	if(dyingCounter > 25 && dyingCounter <=30 ) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));
    	}
    	if(dyingCounter > 30 && dyingCounter <=35 ) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    	}
    	if(dyingCounter > 35 && dyingCounter <=40 ) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0f));
    	}
		if(dyingCounter > 40) {
			die = false;
			alive = false;
		}
		
	}

	public BufferedImage setup(String imagePath, int width, int height) {

		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			image= ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = uTool.scaleImage(image, width, height);
		}catch(IOException e){
			e.printStackTrace();
		}
		return image;
	}

	public void searchPath(int col,int row) {
		int startCol = (worldX + solidArea.x)/gp.titleSize;
		int startRow = (worldY + solidArea.y)/gp.titleSize;
		
		gp.pFinder.setNodes(startCol, startRow, col, row, this);
		
		if(gp.pFinder.search() == true) {
			
			int nextX = gp.pFinder.pathList.get(0).col * gp.titleSize;
			int nextY = gp.pFinder.pathList.get(0).row * gp.titleSize;
			
			int enLeftX = worldX + solidArea.x;
			int enRightX = worldX + solidArea.x + solidArea.width;
			int enTopY = worldY + solidArea.y;
			int enBottomY = worldY + solidArea.y + solidArea.height;
			
			if(enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.titleSize) {
				
				direction = "up";
			}
			else if(enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.titleSize) {
				direction = "down";
			}
			else if(enTopY >= nextY && enBottomY < nextY + gp.titleSize) {
				
				if(enLeftX > nextX) {
					direction = "left";
				}
				if(enLeftX < nextX) {
					direction = "right";
				}
			}
			
			else if(enTopY > nextY && enLeftX > nextX) {
				
				direction = "up";
				checkCollision();
				if(collisionOn == true) {
					direction = "left";
				}
			}
			else if(enTopY > nextY && enLeftX < nextX) {
				
				direction = "up";
				checkCollision();
				if(collisionOn == true) {
					direction = "right";
				}
			}
		else if(enTopY < nextY && enLeftX > nextX) {
				
				direction = "down";
				checkCollision();
				if(collisionOn == true) {
					direction = "left";
				}
			}
		else if(enTopY < nextY && enLeftX < nextX) {
			
			direction = "down";
			checkCollision();
			if(collisionOn == true) {
				direction = "right";
			}
		}
			
//			int nextCol = gp.pFinder.pathList.get(0).col ;
//			int nextRow = gp.pFinder.pathList.get(0).row ;
//			
//			if(nextCol == col && nextRow == row) {
//				onPath = false;
//				
//			}
		}
	}
}


