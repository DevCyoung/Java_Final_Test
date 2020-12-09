package Graphics;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

class DrawProgram extends JPanel implements ActionListener{
	
	DrawMouseCanvas drawCanvas;
	
	JMenuBar jb = new JMenuBar();
	
	JMenu jm = new JMenu("바꾸기");
	
	
	
	JMenuItem[] items = new JMenuItem[] {
		new JMenuItem("LINE"),
		new JMenuItem("RECT"),
		new JMenuItem("OVAL"),
		new JMenuItem("FILLRECT"),
		new JMenuItem("CLICKTOCLICK"),
		new JMenuItem("TEXT")
	};
	
	JButton[] jbs = new JButton[] {
			
		new JButton("LINE"),
		new JButton("RECT"),
		new JButton("OVAL"),
		new JButton("FILLRECT"),
		new JButton("CLICKTOCLICK"),
		new JButton("TEXT")
		
	};
	
	
	
	public DrawProgram() {
		drawCanvas = new DrawMouseCanvas();
		
		jb.add(jm);
		for(int i=0; i <items.length; i++) {
			jm.add( items[i] );	
			items[i].addActionListener(this);
		}
		
		
		
		
		super.setLayout(new BorderLayout());
		
		JPanel p = new JPanel(new FlowLayout());
		for(int i =0; i< jbs.length; i++) {
			p.add(jbs[i]);
			jbs[i].addActionListener(this);
			
		}
		
		super.add(drawCanvas , BorderLayout.CENTER);
		super.add(p , BorderLayout.SOUTH);
		
		
		
		
	}
	
	public JMenuBar getJMenubar() {
		
		return jb;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().toString();
		
		
		
		if( name == "LINE" ) {
			System.out.println("LINE");
			drawCanvas.type = DrawMouseCanvas.LINE;
		}
		else if(name == "RECT") {
			System.out.println("RECT");
			drawCanvas.type = DrawMouseCanvas.RECT;
		}
		else if(name == "OVAL") {
			System.out.println("OVAL");
			drawCanvas.type = DrawMouseCanvas.OVAL;
		}
		else if(name == "FILLRECT") {
			drawCanvas.type = DrawMouseCanvas.FILLRECT;
		}
		
		else if(name == "TEXT") {
			drawCanvas.type = DrawMouseCanvas.TEXT;
		}
		
		if(name == "CLICKTOCLICK") {
			System.out.println("CLICKTOCLICK");
			drawCanvas.isClickto = true;
			drawCanvas.count = 0; 
			drawCanvas.type = DrawMouseCanvas.CLICKTOCLICK;
		}
		else {
			drawCanvas.isClickto = false;
		}
		
		
		

		
	}
	
}



class DrawMouseCanvas extends JPanel implements MouseListener , MouseMotionListener{
	public static final int NULL = -1;
	public static final int LINE = 0;
	public static final int RECT = 1;
	public static final int OVAL = 2;
	public static final int FILLRECT = 3;
	public static final int CLICKTOCLICK = 4;
	public static final int TEXT = 5;
	
	private Point p1 , p2;
	public int type;
	
	public boolean isClickto = false;
	public int count = 0;
	
	public DrawMouseCanvas() {
		p1 = new Point(0,0);
		p2 = new Point(0,0);
		super.setPreferredSize(new Dimension(800,800));
		type = NULL;
		super.addMouseListener(this);
		super.addMouseMotionListener(this);
		
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Point startP = new Point(0,0);
		Point endP = new Point(0,0);
		
		if( type == DrawMouseCanvas.NULL )
			return;
		
		
		
		startP.x = Math.min(p1.x, p2.x);
		startP.y = Math.min(p1.y, p2.y);
		endP.x = Math.max(p1.x, p2.x);
		endP.y = Math.max(p1.y, p2.y);
		
		switch (type) {
			
		case LINE:
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			break;
		case RECT:
			g.drawRect(startP.x, startP.y, endP.x-startP.x, endP.y-startP.y);
			break;
		case OVAL:
			g.drawOval(startP.x, startP.y, endP.x-startP.x, endP.y-startP.y);
			break;
		case FILLRECT:
			g.setColor(Color.red);
			g.fillRect(startP.x, startP.y, endP.x-startP.x, endP.y-startP.y);
			break;	
		case CLICKTOCLICK:
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
		case TEXT:
			Font font = new Font("명조" , Font.ITALIC | Font.BOLD , 12);
			g.drawString("문자열", p1.x, p1.y);
			
		
		default:
		}
		
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {

			p1 = e.getPoint();	
		
			
		
		
	
		
		
	
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(isClickto)
			return;

		p2 = e.getPoint();
		repaint();
		
	}
	

	//	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		

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



	



	@Override
	public void mouseMoved(MouseEvent e) {
		
		
		
	}
	
	
	
	

}


public class DrawMouseShape {

	public static void main(String[] args) {
		
		DrawProgram pro = new DrawProgram();
		
		
		JFrame f = new JFrame("DrawMouseCanvas");
		f.setContentPane(pro);
		f.setJMenuBar( pro.getJMenubar() );
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
		

	}

}
