package main;

import java.awt.Color;
import tile_interac.interacTile;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Entity;
import javax.swing.JPanel;
import tile.TileManager;
import entity.player;
import main.UI;
import java.util.ArrayList;
import ai.PathFinder;

public class GamePanel extends JPanel implements Runnable  {
    //screen settings
	int FPS =60;
    final int oriTileSize = 16;
    final int scale =3;
    public final int titleSize = oriTileSize*scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 13;
    public final int screenWidth = titleSize * maxScreenCol;
    public final int screenHeight = titleSize * maxScreenRow;
    
    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int maxMap = 10;
    public int currentMap = 0;
    
    public final int WorldWidth = titleSize * maxWorldCol;
    public final int WorldHeight = titleSize * maxWorldRow;

    AssetSetter aSetter = new AssetSetter(this);
    public TileManager tileM = new TileManager(this);
    public keyhandler keyH = new keyhandler(this);
    //SOUND
    Sound sound = new Sound();
    Thread gameThread;
    public collision checker = new collision(this);
    public player Player = new player(this,keyH);
    public player Player2 = new player(this,keyH);
    public interacTile iTile[] = new interacTile[200];
    public PathFinder pFinder = new PathFinder(this);
    public Entity npc[] = new Entity[10];
    public Entity enemy[] = new Entity[20];
    public ArrayList<Entity> particleList = new ArrayList<>();
    public UI ui = new UI(this);
    
    
    //GAME STATE
    public int gameState;
    public final int titleState =0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState =3;
    public final int gameOverState = 6;
    
    public GamePanel() {
    	this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    	this.setBackground(Color.black);
    	this.setDoubleBuffered(true);
    	this.addKeyListener(keyH);
    	this.setFocusable(true);
    }
    
    public void setupGame() {
    	
    	aSetter.setNPC();
    	aSetter.setEnemy();
    	aSetter.setInteracTile();
    	//daplayMusic(0);
    	gameState = titleState;
    }
    public void startGameThread() {
    	gameThread = new Thread(this);
    	gameThread.start();
    }

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
	        
	    double nextDrawTime = System.nanoTime()+ drawInterval;
		
		
		while(gameThread!=null) {
			update();
			repaint();
		
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /=1000000;
				
				if(remainingTime<0) {
					remainingTime =0;
				}
				Thread.sleep((long)remainingTime);
				nextDrawTime +=drawInterval;
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		//PLAYER
		Player.update();
		
		//NPC
		for(int i=0;i<npc.length;i++) {
			if(npc[i]!=null) {
				npc[i].update();
			}
		}
		for(int i=0;i<enemy.length;i++) {
			if(enemy[i] !=null) {
				if(enemy[i].alive == true && enemy[i].die == false) {
					enemy[i].update();
				}
				if(enemy[i].alive == false) {
					enemy[i] = null;
				}
				
			}
		}
		
		for(int i=0; i<particleList.size();i++) {
			if(particleList.get(i) != null) {
				if(particleList.get(i).alive == true) {
					particleList.get(i).update();
				}
				if(particleList.get(i).alive == false) {
					particleList.remove(i);
				}
			}
		}
		
		for(int i=0;i<iTile.length;i++) {
			if(iTile[i] != null) {
				iTile[i].update();
			}
		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		// TITLE SCREEN
		if(gameState == titleState) {
			ui.draw(g2);
		}
		//OTHERS
		else {
			// TILE
			tileM.draw(g2);
			
			for(int i=0 ; i<iTile.length;i++) {
				if(iTile[i] != null) {
					iTile[i].draw(g2);
				}
			}
			//NPC
			for(int i=0;i<npc.length;i++) {
				if(npc[i] !=null) {
					npc[i].draw(g2);
				}
			}
			for(int i=0;i<enemy.length;i++) {
				if(enemy[i] !=null) {
					enemy[i].draw(g2);
				}
			}
			for(int i=0;i<particleList.size();i++) {
				if(particleList.get(i) != null) {
					particleList.get(i).draw(g2);
				}
			}
			
			Player.draw(g2);
			
			g2.dispose();
		}		
		
	}
	
	public void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic() {
		sound.stop();
	}
	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}
    
}
