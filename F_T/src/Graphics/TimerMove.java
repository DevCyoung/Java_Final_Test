package Graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;



enum State{
	
}




class Player{
	
	Point position;
	
	Image sprite;
	
	Image[] spriteAnimMove =new Image[20];
	
	
	
	public int curCount = 0;
	
	
	int width;
	int height;
	
	public boolean Key_Move_Right;
	public boolean Key_Move_LEFT;
	
	public Player(String path) {
		
		
		position = new Point(50,500);
		
		String basePath = "Images/";
		String objectPath = "Run";
		
		BufferedImage bimg = null;
		try {
			sprite = ImageIO.read(new File(path));
			bimg = ImageIO.read(new File(path));
			
			for(int i = 0; i < 20; i++ ) {
				spriteAnimMove[i] = ImageIO.read(new File( basePath + objectPath + Integer.toString(i+1
						) + ".png" ) );
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		width          = bimg.getWidth();
		height         = bimg.getHeight();
		
	}
	
	
	public void drawSprite(Graphics g) {
		
		
		
		g.drawImage(spriteAnimMove[curCount], position.x, position.y, position.x +150 , position.y + 150 , 0, 0, width, height, null);
		
		
		
	}
	
	public void Move() {
		if( !Key_Move_LEFT && !Key_Move_Right  )
			return;
		
		if( Key_Move_LEFT )
			position.x -= 5;
		else if(Key_Move_Right)
			position.x += 5;
		
	}
	
	
	public void setPosition(Point position) {
		this.position = position;
		
		
	}
	public Point getPosition() {
		return position;
	}
	
	public void Animation() {
		curCount++;
		if(curCount >= spriteAnimMove.length- 1)
			curCount = 0;
		
	}
	

	
}


class MoveCanvas extends JPanel{
	
	public Player player;
	public Controller ct;
	
	
	
	public MoveCanvas(){
		super.setPreferredSize(new Dimension(800,800));
		ct = new Controller(this);
		
		
		Timer tm = new Timer(33, ct);
		
		
		
		
		
		player = new Player("Images/Run1.png");
		
		tm.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.drawSprite(g);
		
		
		
	}
	
	
	
	
	
	
	
	
}


class Controller implements ActionListener , KeyListener{
	
	MoveCanvas mc;
	
	public Controller(MoveCanvas mc) {
		this.mc = mc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		mc.player.Move();
		mc.player.Animation();
		
		mc.repaint();
		
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		
		switch ( e.getKeyCode() )  {
		
		case KeyEvent.VK_LEFT:
			mc.player.Key_Move_LEFT = true;
			break;
			
		case KeyEvent.VK_RIGHT:
			mc.player.Key_Move_Right = true;
			break;
	
			
		}
			
		
		

		
	}


	@Override
	public void keyReleased(KeyEvent e) {

		switch ( e.getKeyCode() )  {
		
		case KeyEvent.VK_LEFT:
			mc.player.Key_Move_LEFT = false;
			break;
			
		case KeyEvent.VK_RIGHT:
			mc.player.Key_Move_Right = false;
			
			break;
		}
			
		
	}
	
	
	
	
}
	
	









public class TimerMove {

	public static void main(String[] args) {
		
		MoveCanvas mc = new MoveCanvas();
		JFrame f = new JFrame("MoveCanvas");
		f.setContentPane(mc);
		f.addKeyListener(mc.ct);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();


	}

}
