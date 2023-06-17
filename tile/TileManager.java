package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;
public class TileManager {

	GamePanel gp;
	public Tile [] tile ;
	public int mapTileNum[][];
	boolean drawPath = true;
	
	public TileManager(GamePanel gp) {
		this.gp=gp;
		
		tile = new Tile[50];
		mapTileNum =new int [gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		try {
			tile[0]=new Tile();
			tile[0].image= ImageIO.read(getClass().getResource("/tiles/ground.png"));
			
			tile[1]=new Tile();
			tile[1].image= ImageIO.read(getClass().getResource("/tiles/brick.png"));
			tile[1].collision=true;
			
			tile[2]=new Tile();
			tile[2].image= ImageIO.read(getClass().getResource("/tiles/water.png"));
			tile[2].collision=true;
			
			tile[3]=new Tile();
			tile[3].image= ImageIO.read(getClass().getResource("/tiles/grass.png"));
			
			tile[4]=new Tile();
			tile[4].image= ImageIO.read(getClass().getResource("/tiles/tree.png"));
			tile[4].collision=true;
			
			tile[5]=new Tile();
			tile[5].image= ImageIO.read(getClass().getResource("/tiles/path.png"));
					
			tile[6]=new Tile();
			tile[6].image= ImageIO.read(getClass().getResource("/tiles/enemy_1.png"));
			tile[6].collision=true;
			
			tile[7]=new Tile();
			tile[7].image= ImageIO.read(getClass().getResource("/tiles/enemy_2.png"));
			tile[7].collision=true;
			
			tile[8]=new Tile();
			tile[8].image= ImageIO.read(getClass().getResource("/tiles/enemy_3.png"));
			tile[8].collision=true;
			
			tile[9]=new Tile();
			tile[9].image= ImageIO.read(getClass().getResource("/tiles/enemy_4.png"));
			tile[9].collision=true;
			
			tile[10]=new Tile();
			tile[10].image= ImageIO.read(getClass().getResource("/tiles/enemy_5.png"));
			tile[10].collision=true;
			
			tile[11]=new Tile();
			tile[11].image= ImageIO.read(getClass().getResource("/tiles/enemy_6.png"));
			tile[11].collision=true;
			
			tile[12]=new Tile();
			tile[12].image= ImageIO.read(getClass().getResource("/tiles/enemy_7.png"));
			tile[12].collision=true;
			
			tile[13]=new Tile();
			tile[13].image= ImageIO.read(getClass().getResource("/tiles/enemy_8.png"));
			tile[13].collision=true;
			
			tile[14]=new Tile();
			tile[14].image= ImageIO.read(getClass().getResource("/tiles/gate_1.png"));
			tile[14].collision=true;
			
			tile[15]=new Tile();
			tile[15].image= ImageIO.read(getClass().getResource("/tiles/gate_2.png"));
			tile[15].collision=true;
			
			tile[16]=new Tile();
			tile[16].image= ImageIO.read(getClass().getResource("/tiles/gate_3.png"));
			tile[16].collision=true;
			
			tile[17]=new Tile();
			tile[17].image= ImageIO.read(getClass().getResource("/tiles/house_1.png"));
			tile[17].collision=true;
			
			tile[18]=new Tile();
			tile[18].image= ImageIO.read(getClass().getResource("/tiles/house_2.png"));
			tile[18].collision=true;
			
			tile[19]=new Tile();
			tile[19].image= ImageIO.read(getClass().getResource("/tiles/house_3.png"));
			tile[19].collision=true;
			
			tile[20]=new Tile();
			tile[20].image= ImageIO.read(getClass().getResource("/tiles/house_4.png"));
			tile[20].collision=true;
			
			tile[21]=new Tile();
			tile[21].image= ImageIO.read(getClass().getResource("/tiles/house_5.png"));
			tile[21].collision=true;
			
			tile[22]=new Tile();
			tile[22].image= ImageIO.read(getClass().getResource("/tiles/house_6.png"));
			tile[22].collision=true;
			
			tile[23]=new Tile();
			tile[23].image= ImageIO.read(getClass().getResource("/tiles/house_7.png"));
			tile[23].collision=true;
			
			tile[24]=new Tile();
			tile[24].image= ImageIO.read(getClass().getResource("/tiles/house_8.png"));
			tile[24].collision=true;
			
			tile[25]=new Tile();
			tile[25].image= ImageIO.read(getClass().getResource("/tiles/house_9.png"));
			tile[25].collision=true;
			
			tile[26]=new Tile();
			tile[26].image= ImageIO.read(getClass().getResource("/tiles/house_10.png"));
			tile[26].collision=true;
			
			tile[27]=new Tile();
			tile[27].image= ImageIO.read(getClass().getResource("/tiles/house_11.png"));
			tile[27].collision=true;
			
			tile[28]=new Tile();
			tile[28].image= ImageIO.read(getClass().getResource("/tiles/house_12.png"));
			tile[28].collision=true;
			
			tile[29]=new Tile();
			tile[29].image= ImageIO.read(getClass().getResource("/tiles/small_1.png"));
			tile[29].collision=true;
			
			tile[30]=new Tile();
			tile[30].image= ImageIO.read(getClass().getResource("/tiles/small_2.png"));
			tile[30].collision=true;
		
			tile[31]=new Tile();
			tile[31].image= ImageIO.read(getClass().getResource("/tiles/small_3.png"));
			tile[31].collision=true;
			
			tile[32]=new Tile();
			tile[32].image= ImageIO.read(getClass().getResource("/tiles/small_enemy_1.png"));
			tile[32].collision=true;
			
			tile[33]=new Tile();
			tile[33].image= ImageIO.read(getClass().getResource("/tiles/small_enemy_2.png"));
			tile[33].collision=true;
			
			tile[34]=new Tile();
			tile[34].image= ImageIO.read(getClass().getResource("/tiles/small_enemy_3.png"));
			tile[34].collision=true;
			
			tile[35]=new Tile();
			tile[35].image= ImageIO.read(getClass().getResource("/tiles/small_enemy_4.png"));
			tile[35].collision=true;
		
			tile[36]=new Tile();
			tile[36].image= ImageIO.read(getClass().getResource("/tiles/small_enemy_5.png"));
			tile[36].collision=true;
			

			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String s) {
		try {
			 InputStream is = getClass().getResourceAsStream(s);
			 
			 BufferedReader br = new BufferedReader(new InputStreamReader(is));
			 int col =0;
			 int row=0;
			 
			 while(col< gp.maxWorldCol && row<gp.maxWorldRow) {
				 String line = br.readLine();
				 
				 while(col<gp.maxWorldCol) {
					 
					 String numbers[] = line.split(" ");
					 
					 int num = Integer.parseInt(numbers[col]);
					 
					 mapTileNum[col][row]= num;
					 col++;
				 }
				 if(col ==gp.maxWorldCol) {
					 col =0;
					 row++;
				 }
			 }
			 br.close();
		}catch(Exception e) {
			
		}
	}
	public void setup(int index,String imagePath, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index]=new Tile();
			tile[index].image= ImageIO.read(getClass().getResource("/tiles/"+imagePath+".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.titleSize, gp.titleSize);
			tile[index].collision= collision;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int worldcol = 0;
		int worldrow = 0;
		
		
		while(worldcol<gp.maxWorldCol && worldrow< gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldcol][worldrow];
			
			int worldX = worldcol * gp.titleSize;
			int worldY = worldrow * gp.titleSize;
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
				
				g2.drawImage(tile[tileNum].image, screenX,screenY, gp.titleSize, gp.titleSize,null);
			}
			else if(gp.Player.screenX > gp.Player.worldX || 
					gp.Player.screenY > gp.Player.worldY ||
					rightOffset > gp.WorldWidth - gp.Player.worldX ||
					bottomOffset > gp.WorldHeight - gp.Player.worldY) {
				g2.drawImage(tile[tileNum].image, screenX,screenY, gp.titleSize, gp.titleSize,null);
			}
			
			worldcol++;
			
			
			if(worldcol ==gp.maxWorldCol) {
				worldcol =0;
				worldrow++;
				
			}
		}
//		if(drawPath == true) {
//			g2.setColor(new Color(255,0,0,70));
//			
//			for(int i=0; i< gp.pFinder.pathList.size();i++) {
//				
//				
//				
//				int worldX = gp.pFinder.pathList.get(i).col * gp.titleSize;
//				int worldY = gp.pFinder.pathList.get(i).row * gp.titleSize;
//				int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
//				int screenY = worldY - gp.Player.worldY + gp.Player.screenY;
//				
//				g2.fillRect(screenX, screenY, gp.titleSize, gp.titleSize);
//			}
//		}
	}
}
