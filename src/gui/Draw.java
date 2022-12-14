package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import actions.DataHandler;
import game.Snake;

public class Draw extends JLabel{
	
	Point p;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Gui.width, Gui.height);
		
		g.setColor(new Color(51, 204, 51));
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, 32, 32);
        }
		
      //Draw Snake Head
        g.setColor(new Color(0,153,0));
        p = Snake.ptc(Snake.head.getX(),Snake.head.getY());
        g.fillRect(p.x,p.y,32,32);

        //Draw PickUp
        g.setColor(new Color(204,51,0));
        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g.fillRect(p.x,p.y, 32,32);

        
		g.setColor(Color.gray);
		
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32, 32);
			}
		}
		
		g.setColor(Color.black);
		g.drawRect(0, 0, Gui.width, Gui.height);
		
		
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Score "+Snake.score,5,25);
		g.drawString("Highscore "+Snake.bestscore,655,25);
		repaint();
	}
}
