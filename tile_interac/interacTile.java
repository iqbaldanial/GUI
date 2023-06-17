package tile_interac;

import entity.Entity;
import main.GamePanel;

public class interacTile extends Entity{

	GamePanel gp;
	public boolean destructive = false;
	
	public interacTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}

	public void update() {
		
	}
	
	public interacTile getDestroyedForm() {
		interacTile tile = null;
		return tile;
	}
	
	


}
