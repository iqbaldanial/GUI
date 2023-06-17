package main;

import entity.Entity;

public class collision {
	GamePanel gp;
	public collision(GamePanel gp) {
		this.gp=gp;
		
	}
	
	public void checkTile(Entity entity) {
		
		 int entityLeftWorldX = entity.worldX + entity.solidArea.x;	 
		 int entityRightWorldX = entity.worldX + entity.solidArea.x+ entity.solidArea.width;
		 int entityTopWorldY = entity.worldY + entity.solidArea.y; 
		 int entityBottomWorldY = entity.worldY + entity.solidArea.y+ entity.solidArea.height;
		 
		 int entityLeftCol = entityLeftWorldX/gp.titleSize;
		 int entityRightCol = entityRightWorldX/gp.titleSize;
		 int entityTopRow = entityTopWorldY/gp.titleSize;
		 int entityBottomRow = entityBottomWorldY/gp.titleSize;
		 
		 int tileNum1, tileNum2;
		 
		 switch(entity.direction) {
		 
		 case "up":
			 entityTopRow = (entityTopWorldY - entity.speed)/gp.titleSize;
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			 tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn =true;
			 }
			 break;
		 case "down":
			 entityBottomRow = (entityBottomWorldY - entity.speed)/gp.titleSize;
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			 tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn =true;
			 }
			 break;
		 case "left":
			 entityLeftCol = (entityLeftWorldX - entity.speed)/gp.titleSize;
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			 tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn =true;
			 }
			 break;
		 case "right":
			 entityRightCol = (entityRightWorldX + entity.speed)/gp.titleSize;
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			 tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn =true;
			 }
			 break;
		 }
	}
	
	// NPC OR ENEMY
	public int checkEntity(Entity entity, Entity[] target) {
		
		int index = 999;
		for(int i=0; i<target.length;i++) {
			
			if(target[i] != null) {
				
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y =entity.worldY + entity.solidArea.y;
				
				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y= target[i].worldY + target[i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
				}
					if(entity.solidArea.intersects(target[i].solidArea)) {
						if(target[i] != entity) {
							entity.collisionOn = true;										
							index = i;	
						}
											
				}
					
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;
					
			}
		}
		return index;
	}
	
	public boolean checkPlayer(Entity entity) {
		boolean contactPlayer = false;
		entity.solidArea.x = entity.worldX + entity.solidArea.x;
		entity.solidArea.y =entity.worldY + entity.solidArea.y;
		
		gp.Player.solidArea.x = gp.Player.worldX + gp.Player.solidArea.x;
		gp.Player.solidArea.y= gp.Player.worldY + gp.Player.solidArea.y;
		
		switch(entity.direction) {
		case "up":
			entity.solidArea.y -= entity.speed;
			if(entity.solidArea.intersects(gp.Player.solidArea)) {
					entity.collisionOn = true;		
					 contactPlayer = true;
											
			}
			break;
		case "down":
			entity.solidArea.y += entity.speed;
			if(entity.solidArea.intersects(gp.Player.solidArea)) {
				entity.collisionOn = true;
				contactPlayer = true;
									
			}
			break;
		case "left":
			entity.solidArea.x -= entity.speed;
			if(entity.solidArea.intersects(gp.Player.solidArea)) {
				entity.collisionOn = true;
				contactPlayer = true;
							
			}
			break;
		case "right":
			entity.solidArea.x += entity.speed;
			if(entity.solidArea.intersects(gp.Player.solidArea)) {
				entity.collisionOn = true;
				contactPlayer = true;
			}
			break;
		
		}
		
		entity.solidArea.x = entity.solidAreaDefaultX;
		entity.solidArea.y = entity.solidAreaDefaultY;
		gp.Player.solidArea.x = gp.Player.solidAreaDefaultX;
		gp.Player.solidArea.y = gp.Player.solidAreaDefaultY;
		
		return contactPlayer;
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void CheckTile(Entity entity) {
		 int entityLeftWorldX = entity.worldX + entity.solidArea.x;	 
		 int entityRightWorldX = entity.worldX + entity.solidArea.x+ entity.solidArea.width;
		 int entityTopWorldY = entity.worldY + entity.solidArea.y; 
		 int entityBottomWorldY = entity.worldY + entity.solidArea.y+ entity.solidArea.height;
	
		 int entityLeftCol = entityLeftWorldX/gp.titleSize;
		 int entityRightCol = entityRightWorldX/gp.titleSize;
		 int entityTopRow = entityTopWorldY/gp.titleSize;
		 int entityBottomRow = entityBottomWorldY/gp.titleSize;
		 
		 int tileNum1, tileNum2;
		 
		 switch(entity.direction) {
		 
		 case "up":
			 entityTopRow = (entityTopWorldY - entity.speed)/gp.titleSize;
			 
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			 tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn=true;
			 }
			 break;
		 case "down":
			 entityBottomRow = (entityBottomWorldY - entity.speed)/gp.titleSize;
			 
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			 tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn=true;
			 }
			 break;
		 case "left":
			 entityLeftCol = (entityLeftWorldX - entity.speed)/gp.titleSize;
			 
			 tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			 tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn=true;
			 }
			 break;
		 case "right":
			 entityRightCol = (entityRightWorldX + entity.speed)/gp.titleSize;
			 
			 tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			 tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			 
			 if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				 entity.collisionOn=true;
			 }
			 break;
			 
		 }
	
	
	} */


