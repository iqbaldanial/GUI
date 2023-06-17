package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	Font MaruMonica;
	Image img;
	
	public int commandNum =0;
	public UI(GamePanel gp) {
		this.gp = gp;
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
			MaruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
			img = ImageIO.read(getClass().getResource("/background/war.png"));;
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		//TITLE STATE
		this.g2=g2;
		g2.setFont(MaruMonica);
		g2.setColor(Color.white);
		
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
	}
	
	public void drawTitleScreen() {
		// Draw background image
        g2.drawImage(img, 0, 0, gp.screenWidth, gp.screenHeight, null);
		//TITLE NAME
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,100F));
		String text = "THE BATTLE OF RED CLIFF";
		int x = getXforCenteredText(text) ;
		int y = gp.titleSize*3;
		//SHADOW
		g2.setColor(Color.red);	
		g2.drawString(text,x+5,y+5);
		//MAIN
		g2.setColor(Color.white);	
		g2.drawString(text,x,y);
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,55F));
		text = "START";
	    x = getXforCenteredText(text) ;
		y+=gp.titleSize*3;
		g2.drawString(text, x, y);
		if(commandNum==0) {
			g2.drawString(">",x-gp.titleSize,y);
		}
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,55F));
		text = "QUIT";
	    x = getXforCenteredText(text) ;
		y+=gp.titleSize*2;
		g2.drawString(text, x, y);
		if(commandNum==1) {
			g2.drawString(">",x-gp.titleSize,y);
		}
		
		//game over
		if(gp.gameState == gp.gameOverState) {
			drawGameOverScreen();
		}
	}
	public void drawGameOverScreen() {
		
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
	}
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}
