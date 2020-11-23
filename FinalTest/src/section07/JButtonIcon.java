package section07;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.text.AbstractDocument.Content;

class IconChanger extends JPanel implements MouseListener{
	
	ImageIcon i1  = new ImageIcon("Images/daum.jpg");
	ImageIcon i2  = new ImageIcon("Images/google.jpg");
	ImageIcon i3  = new ImageIcon("Images/naver.jpg");
	
	JButton b1 = new JButton(i1);
	JButton b2 = new JButton(i2);
	JLabel b3 = new JLabel(i3);
	
	
	
	public IconChanger() {
		super.setLayout(new BorderLayout());
		
		b1.addMouseListener(this);		
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		
		b1.setText("asdasdasd");
		b3.setText("asdasdasd");
		
		b1.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
		b3.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
		
		
		super.add(b1 ,BorderLayout.NORTH);
		super.add(b2 ,BorderLayout.CENTER);
		super.add(b3, BorderLayout.SOUTH);
		
	}
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		b1.setIcon(i3);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		b1.setIcon(i2);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		b1.setIcon(i1);
		
	}

	
	
}




public class JButtonIcon {
	
	
	

	public static void main(String[] args) {
		JFrame f = new JFrame("asdasd");
		Container c =  f.getContentPane();
		c.add(new IconChanger());
		
		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		


	}

}
