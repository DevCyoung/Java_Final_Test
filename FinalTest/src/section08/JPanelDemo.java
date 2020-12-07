package section08;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.*;

class ColorCanvas extends JPanel{
	
	private Color color = Color.red;
	
	private final int width = 200;
	private final int height = 50;
	
	private final int interval = 10;
	
	public ColorCanvas() {
		super.setPreferredSize(new Dimension(width , height));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(interval, interval, width - interval , height - interval );
	}
	
	
	public void SetColor(Color color) {
		this.color = color;
	}
	
	
}

class ColorPro extends JPanel{
	
	public static String[] colorsStr = new String[] {"red" , "green" , "yellow"};
	public static Color[] colors = new Color[] {Color.RED , Color.GREEN , Color.yellow};
	
	ColorCanvas canvas;
	RadioListener rm;
	
	
	public ColorPro() {
		
		
		
		
		super.setLayout(new GridLayout(1,2));
		
		canvas = new ColorCanvas();
		rm = new RadioListener(canvas);
		
		JPanel p = new JPanel(new GridLayout(colorsStr.length,1));
		ButtonGroup bg = new ButtonGroup();
		
		for(int i = 0; i < colorsStr.length; i++ ) {
			JRadioButton jb = new JRadioButton(colorsStr[i]);
			bg.add(jb);
			p.add(jb);
			jb.addActionListener(rm);
		}
		
		super.add(canvas);
		super.add(p);
		
	}
	
	
}

class RadioListener implements ActionListener{
	
	
	
	public static Color curColor = Color.RED;
	
	public ColorCanvas canvas;
	
	public RadioListener(ColorCanvas canvas) {
		this.canvas = canvas;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		String name = e.getActionCommand().toString();
		
		for(int i =0; i < ColorPro.colors.length; i++ ) {
			
			if(name == ColorPro.colorsStr[i]) {
				curColor = ColorPro.colors[i];
			}
		}	
		canvas.SetColor(curColor);
		canvas.repaint();
		
	}
	public Color getColor() {
		return curColor;
	}
	
	
	
}




public class JPanelDemo {

	public static void main(String[] args) {
		JFrame f = new JFrame("ColorPro");
		f.setContentPane(new ColorPro());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

}
