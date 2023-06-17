package main;

import enemy.ENEM;
import enemy.ORC;
import entity.NPC_1;
import tile_interac.drytree;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
	}
	
	public void setObject() {
		
	}
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_1(gp);
		gp.npc[0].worldX = gp.titleSize*10;
		gp.npc[0].worldY = gp.titleSize*7;
		
		gp.npc[1] = new NPC_1(gp);
		gp.npc[1].worldX = gp.titleSize*8;
		gp.npc[1].worldY = gp.titleSize*5;
		
		gp.npc[2] = new NPC_1(gp);
		gp.npc[2].worldX = gp.titleSize*4;
		gp.npc[2].worldY = gp.titleSize*12;
		
			
		gp.npc[3] = new NPC_1(gp);
		gp.npc[3].worldX = gp.titleSize*10;
		gp.npc[3].worldY = gp.titleSize*7;
		
		gp.npc[4] = new NPC_1(gp);
		gp.npc[4].worldX = gp.titleSize*8;
		gp.npc[4].worldY = gp.titleSize*13;
		
		gp.npc[5] = new NPC_1(gp);
		gp.npc[5].worldX = gp.titleSize*4;
		gp.npc[5].worldY = gp.titleSize*15;
	}
	public void setEnemy() {
		gp.enemy[0] = new ORC(gp);
		gp.enemy[0].worldX = gp.titleSize*11;
		gp.enemy[0].worldY = gp.titleSize*32;
		
//		gp.enemy[1] = new ENEM(gp);
//		gp.enemy[1].worldX = gp.titleSize*10;
//		gp.enemy[1].worldY = gp.titleSize*33;
		
		gp.enemy[1] = new ORC(gp);
		gp.enemy[1].worldX = gp.titleSize*10;
		gp.enemy[1].worldY = gp.titleSize*33;
		
		gp.enemy[2] = new ORC(gp);
		gp.enemy[2].worldX = gp.titleSize*38;
		gp.enemy[2].worldY = gp.titleSize*19;
		
		gp.enemy[3] = new ORC(gp);
		gp.enemy[3].worldX = gp.titleSize*36;
		gp.enemy[3].worldY = gp.titleSize*21;
		
		gp.enemy[4] = new ORC(gp);
		gp.enemy[4].worldX = gp.titleSize*29;
		gp.enemy[4].worldY = gp.titleSize*35;
		
		gp.enemy[5] = new ORC(gp);
		gp.enemy[5].worldX = gp.titleSize*27;
		gp.enemy[5].worldY = gp.titleSize*46;
		
		gp.enemy[6] = new ORC(gp);
		gp.enemy[6].worldX = gp.titleSize*30;
		gp.enemy[6].worldY = gp.titleSize*45;
		
		/*gp.enemy[2] = new ENEM(gp);
		gp.enemy[2].worldX = gp.titleSize*23;
		gp.enemy[2].worldX = gp.titleSize*36;
		
		gp.enemy[3] = new ENEM(gp);
		gp.enemy[3].worldX = gp.titleSize*23;
		gp.enemy[3].worldX = gp.titleSize*36;
		
		gp.enemy[4] = new ENEM(gp);
		gp.enemy[4].worldX = gp.titleSize*23;
		gp.enemy[4].worldX = gp.titleSize*36;
		
		gp.enemy[5] = new ENEM(gp);
		gp.enemy[5].worldX = gp.titleSize*23;
		gp.enemy[5].worldX = gp.titleSize*36; */    
	}
	
	public void setInteracTile() {
		int i =0;

		gp.iTile[i]= new drytree(gp,17,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,19,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,19,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,20,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,20,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,20,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,20,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,21,20);
		
		i++;
		gp.iTile[i]= new drytree(gp,21,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,21,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,21,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,21,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,21,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,20);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,22,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,23,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,24,20);
		
		i++;
		gp.iTile[i]= new drytree(gp,24,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,24,22);
		
		i++;
		
		// takcukup
		
		gp.iTile[i]= new drytree(gp,27,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,27,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,27,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,27,29);
		
		i++;
		gp.iTile[i]= new drytree(gp,27,30);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,29);
		
		i++;
		gp.iTile[i]= new drytree(gp,28,30);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,29);
		
		i++;
		gp.iTile[i]= new drytree(gp,29,30);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,29);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,35);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,36);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,37);
		
		i++;
		gp.iTile[i]= new drytree(gp,30,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,23);
		
		i++;
		
		gp.iTile[i]= new drytree(gp,31,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,29);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,35);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,36);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,37);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,40);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,31,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,28);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,39);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,40);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,32,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,20);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,27);
		
		i++;
		
		gp.iTile[i]= new drytree(gp,33,39);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,40);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,33,43);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,21);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,22);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,39);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,40);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,34,43);
		
		i++;
		gp.iTile[i]= new drytree(gp,35,23);
		
		i++;
		gp.iTile[i]= new drytree(gp,35,39);
		
		i++;
		gp.iTile[i]= new drytree(gp,35,40);
		
		i++;
		gp.iTile[i]= new drytree(gp,35,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,35,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,35,43);
		
		i++;
		gp.iTile[i]= new drytree(gp,36,39);
		
		i++;
		gp.iTile[i]= new drytree(gp,36,40);
		
		i++;
		gp.iTile[i]= new drytree(gp,36,41);
		
		i++;
		gp.iTile[i]= new drytree(gp,36,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,36,43);
		
		i++;
		gp.iTile[i]= new drytree(gp,37,42);
		
		i++;
		gp.iTile[i]= new drytree(gp,39,34);
		
		i++;
		gp.iTile[i]= new drytree(gp,39,35);
		
		i++;
		gp.iTile[i]= new drytree(gp,40,33);
		
		i++;
		gp.iTile[i]= new drytree(gp,40,34);
		
		i++;
		gp.iTile[i]= new drytree(gp,40,35);
		
		i++;
		gp.iTile[i]= new drytree(gp,40,36);
		
		i++;
		gp.iTile[i]= new drytree(gp,41,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,41,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,41,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,41,34);
		
		i++;
		gp.iTile[i]= new drytree(gp,41,35);
		
		i++;
		gp.iTile[i]= new drytree(gp,42,24);
		
		i++;
		gp.iTile[i]= new drytree(gp,42,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,42,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,42,27);
		
		i++;
		gp.iTile[i]= new drytree(gp,43,25);
		
		i++;
		gp.iTile[i]= new drytree(gp,43,26);
		
		i++;
		gp.iTile[i]= new drytree(gp,43,27);
		
		i++;
		
	}
	
}
