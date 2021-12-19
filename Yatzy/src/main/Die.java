package main;


import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Die extends JButton{
	
	public static String imagesPath = "E:\\Java\\Yatzy\\images\\";
	BufferedImage img;
	int id;
	int value;
	int posX;
	int posY;
	int size = 40;
	
	float alpha = 1.f;
	
	Player player;
	
	
	
	public Die(int _id, int _posX, int _posY, Player _player) {
		id = _id;
		posX = _posX;
		posY = _posY;
		player = _player;
		roll();
		
		super.addActionListener(new ActionListener(){  
	    	  public void actionPerformed(ActionEvent e){ 
	    		setEnabled(false);
	    		setVisible(false);
	    		player.dice.remove(this);
		  		System.out.println("Spara t�rning: " + id + " med v�rdet: " + value);
		  		
		  		Die d = new Die(id, player.savedSection.posX, player.savedSection.posY, player);
		  		d.value = value;
		  		d.setImage(value);
		  		player.savedSection.dice.add(d);
		  		
		  			
	          }
	    	  
	      });
		super.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				alpha = 0.7f;
    	  }

    	    public void mouseExited(MouseEvent e) {
    	    	alpha = 1f;
    	  }
			
		});
		
		super.setBounds(posX, posY, size, size);
	
		Game.pane.add(this);
		Game.pane.revalidate();
		Game.pane.repaint();
	}
	
	@Override
    public void paint(Graphics g) {
			//System.out.println("Ritar t�rning: " + id) ;
		    ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		    super.paint(g);
		    g.drawImage(img, 0 , 0 , getWidth() , getHeight() , null);
		
	}

	public void setImage(int n) {
		try {
			String file = imagesPath + "die_" + n + ".png";		
			img = ImageIO.read(new File(file));
			super.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void roll() {
		value = (int) Math.ceil(Math.random()*6);
		setImage(value);
	}
	
	public int getValue() {
		return value;
		
	}
	
}