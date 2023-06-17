package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyhandler implements KeyListener  {
    public boolean up,down,left,right,enter;
    GamePanel gp;
    
    public keyhandler(GamePanel gp) {
    	this.gp=gp;
    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //title state
        if(gp.gameState == gp.titleState) {
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0) {
                	gp.ui.commandNum=1;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1) {
                	gp.ui.commandNum=0;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
            	if(gp.ui.commandNum == 0) {
            		gp.gameState = gp.playState;
            		gp.playMusic(0);
            		
            	}
            	if(gp.ui.commandNum ==1) {
            		System.exit(0);
            	}
            	
            }
        }
        //play state
        else if(gp.gameState == gp.playState) {
            if(code == KeyEvent.VK_W){
                up =true;
            }
            if(code == KeyEvent.VK_S){
                down = true;
            }
            if(code == KeyEvent.VK_A){
                left = true;
            }
            if(code == KeyEvent.VK_D){
                right = true;
            }
            if(code == KeyEvent.VK_ENTER) {
            	enter = true;
            }
        }

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	       int code = e.getKeyCode();
	        
	        if(code == KeyEvent.VK_W){
	            up =false;
	        }
	        if(code == KeyEvent.VK_S){
	            down = false;
	        }
	        if(code == KeyEvent.VK_A){
	            left = false;
	        }
	        if(code == KeyEvent.VK_D){
	            right = false;
	        }
		
	}
   
}
