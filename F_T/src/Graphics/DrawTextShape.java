package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.*;

class TextShapeCanvas extends JPanel{
	
	public TextShapeCanvas() {
		super.setPreferredSize(new Dimension(800,800));
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Font font = new Font("³¶³¶" , Font.PLAIN | Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("´ç³ª±Í µîÀå", 30, 30);
		
		font = new Font("³¶³¶" , Font.PLAIN | Font.ITALIC, 30);
		g.setFont(font);
		g.setColor(Color.green);
		g.drawString("´ç³ª±Í µîÀå", 30, 60);
		
		// ¿¬½À¹®Á¦
		font = new Font("³¶³¶" , Font.PLAIN , 15);
		g.setFont(font);
		g.setColor(Color.yellow);
		g.drawString("´ç³ª±Í µîÀå", 30, 150);
		
		
		g.setColor(Color.blue);
		g.drawLine(0, 0, 300, 190);
		
		//
		Point[] ps1 = new Point[] {
			new Point( 160  , 80 ), new Point( 250  , 80 ), new Point( 160  , 140 ),
		};
		
		int x1[] = new int[ps1.length];
		int y1[] = new int[ps1.length];
		
		for(int i = 0; i < ps1.length; i++) {
			x1[i] = ps1[i].x;
			y1[i] = ps1[i].y;
		}
		g.setColor(new Color(120,98,32));
		g.fillPolygon(x1,y1, ps1.length);
		g.drawPolygon(x1, y1, ps1.length);
		//
		
		
		//
		
		
		g.setColor(Color.yellow);
		g.drawLine(30, 90, 200, 90);
		g.setColor(Color.BLACK);
		g.drawLine(30, 120, 200, 120);
		
		
		
		
		g.setColor(Color.pink);
		g.drawRect( 220, 7, 200, 120);
		
		g.setColor(Color.cyan);
		g.fillOval( 220, 7, 200, 120);
		
		
		
		
		Point[] ps = new Point[] {
				new Point( 440  , 7 ), new Point( 540  , 67 ), new Point( 640  , 7 ),
				new Point( 640  , 127 ), new Point( 440  , 127 )
		};
		
		int x[] = new int[5];
		int y[] = new int[5];
		
		for(int i = 0; i < ps.length; i++) {
			x[i] = ps[i].x;
			y[i] = ps[i].y;
		}
		g.fillPolygon(x,y, ps.length);
		g.setColor(Color.black);
		g.drawPolygon(x, y, ps.length);
		
		
		
	
		
		
		
		
		
		
		
		
		
		
	}
	
		
}





public class DrawTextShape {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("DrawTextShape");
		f.setContentPane(new TextShapeCanvas());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
		
		
		
		


	}

}
