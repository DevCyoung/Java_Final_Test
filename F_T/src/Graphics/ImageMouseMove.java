package Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


class ImageMousePro extends JPanel {
	
	Image im;
	
	
	public Point EndP;
	
	MouseCanvasMover mc;
	
	public ImageMousePro() {
		
		super.setPreferredSize(new Dimension(800,800));
		
		EndP = new Point(0,0);
	
		mc = new MouseCanvasMover(this);
		
		super.addMouseListener(mc);
		super.addMouseMotionListener(mc);
		
		BufferedImage bimg = null;
		try {
			im = ImageIO.read(new File("Images/apple.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage( im , EndP.x , EndP.y , null );
		
		
	}
	
	
}

class MouseCanvasMover implements MouseListener , MouseMotionListener{
	
	ImageMousePro imageMouse;
	
	Point ClickP;
	Point oriP;
	Point interval;
	
	public MouseCanvasMover(ImageMousePro imageMouse) {
		ClickP = new Point();
		interval = new Point();
		this.imageMouse = imageMouse;
		
	
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		ClickP = e.getPoint();
		Point newOri = new Point();
		
		newOri.x = imageMouse.EndP.x;
		newOri.y = imageMouse.EndP.y;
		
		oriP = newOri;
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		Point drag = e.getPoint();
		
		interval.x = drag.x - ClickP.x;
		interval.y = drag.y - ClickP.y;
		
		imageMouse.EndP.x = interval.x + oriP.x;
		imageMouse.EndP.y = interval.y + oriP.y;
		

		imageMouse.repaint();
		
	}

	
	
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}



public class ImageMouseMove {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("ImageMousePro");
		f.setContentPane(new ImageMousePro());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
		

	}

}
