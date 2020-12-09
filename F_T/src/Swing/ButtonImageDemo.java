package Swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;




class JButtonImage extends JPanel{
	
	
	
	ImageIcon im1 = new ImageIcon("Images/apple.png");
	ImageIcon im2 = new ImageIcon("Images/google.jpg");
	
	JButton b1 = new JButton(im1);
	JButton b2 = new JButton(im2);
	
	
	
	public JButtonImage() {
		
		
		
		JPanel p = new JPanel(new FlowLayout());
		p.add(b1);
		p.add(b2);
		b1.setText("asdas");
		b1.setHorizontalTextPosition(JButton.CENTER);
		
		super.add(p);
		
		
		
		
		
	}
	
	
	
}














public class ButtonImageDemo {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("JFrame Button");
		
		f.setContentPane(new JButtonImage());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();


	}

}
