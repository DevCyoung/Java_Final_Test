package RunGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class DemoPro extends JPanel implements ActionListener{
	
	Image sprites[] = new Image[20];
	Image sprite;
	int curSprite;
	
	Image bg;
	
	int bgX;
	
	
	public DemoPro(){
		String basePath = "Images/RunGame/Run/";
		String objectPath = "Run";
		
		for(int i = 0; i < 20; i++) {
			sprites[i] = getToolkit().getImage(basePath + objectPath + Integer.toString(i) + ".png");
		}
		
		sprite = getToolkit().getImage("Images/RunGame/Run/Run1.png");
		bg = getToolkit().getImage("Images/bgg.png");
		Timer tm = new Timer(33, this);
		tm.start();
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
//		g.drawImage(sprite, 0, 0,null);
		
		
		g.drawImage(bg, 0, 0, 1500, 1000, bgX, 0, 1920+bgX, 1080, null);
		
		g.drawImage(bg, 1500-bgX, 0, 3000, 2000, 0, 0, 1920, 1080, null);
		
		g.drawImage(sprite, 50, 700, 200, 850, 0, 0, 450, 450, null);
		
		repaint();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		sprite = sprites[++curSprite];
		if( curSprite >= sprites.length - 1)
			curSprite = 0;
		bgX++;
		repaint();
		
	}
	
	
	
	
}





public class GameSystem{

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Run Game");
		f.setPreferredSize(new Dimension(1500,1000));
		f.add(new DemoPro());
		
		
		
		
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
		
	}
	

}
