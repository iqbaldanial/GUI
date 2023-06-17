package tile_interac;

import main.GamePanel;

public class itTruk extends interacTile{
	GamePanel gp;
	
	public itTruk(GamePanel gp, int col, int row) {
		super(gp,col,row);
		this.gp =gp;
		
		this.worldX = gp.titleSize *col;
		this.worldY = gp.titleSize *row;
		down1 = setup("/tile_inteructive/trunk",gp.titleSize,gp.titleSize);
		
		solidArea.x=0;
		solidArea.y=0;
		solidArea.width =0;
		solidArea.height =0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}


}
