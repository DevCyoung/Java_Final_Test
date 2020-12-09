package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;


class ColorBoxCanvas extends JPanel implements ActionListener{
	
	private String[] jButtonNames = new String[] {
					"red" , "yellow"
	};
	
	private Color[] colors = new Color[] {
			Color.red , Color.yellow
	};
	
	
	private String[] jExButtonNames = new String[] {
			"ExBlack" , "ExYellow"
	};
	
	private Color[] exColors = new Color[] {
			Color.black , Color.yellow
	};
	
	
	
	private Color boxColor = Color.red;
	private Color exBoxColor = Color.black;
	
	JPanel ColorBox;
	
	public ColorBoxCanvas() {
		
		super.setPreferredSize(new Dimension(800,100));
		super.setLayout(new GridLayout(1,4));
		
		//Box
		ColorBox = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(boxColor);
				g.fillRect(10, 10, 200 , 50);
				g.setColor(exBoxColor);
				g.drawRect(10, 10, 200, 50);
				
			}
		};
		
		//Radio 1
		ButtonGroup bg = new ButtonGroup();
		JPanel radioPanel = new JPanel(new GridLayout(jButtonNames.length,1));
		radioPanel.setBorder(BorderFactory.createTitledBorder("박스 색변경"));
		for(int i=0; i < jButtonNames.length; i++ ) {
			
			JRadioButton jb = new JRadioButton(jButtonNames[i]);
			bg.add(jb);
			radioPanel.add(jb);
			jb.addActionListener(this);
		}
		
		//Radio 2
		
		ButtonGroup bg2 = new ButtonGroup();
		JPanel radioPanel2 = new JPanel(new GridLayout(jExButtonNames.length,1));
		radioPanel2.setBorder(BorderFactory.createTitledBorder("외곽선 변경"));
		for(int i=0; i < jButtonNames.length; i++ ) {
			
			JRadioButton jb2 = new JRadioButton(jExButtonNames[i]);
			bg2.add(jb2);
			radioPanel2.add(jb2);
			jb2.addActionListener(this);
		}
		
		//Checkbox 3
		
		JCheckBox jcb = new JCheckBox("보색 변경");
		JPanel panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createTitledBorder("보색으로 바꾸기"));
		panel3.add(jcb);
		jcb.addActionListener(this);
		
		//ColorChooser
		JButton chooser = new JButton("ColorChooser");
		JPanel panel4 = new JPanel();
		panel4.setBorder(BorderFactory.createTitledBorder("컬러추져"));
		panel4.add(chooser);
		chooser.addActionListener(this);
		
		
		
		
		
		super.add(ColorBox);
		super.add(radioPanel);
		super.add(radioPanel2);
		super.add(panel3);
		super.add(panel4);
		
		
		
		
	}
	

	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand().toString();
		
		for(int i = 0; i < jButtonNames.length; i++) {
			if( name == jButtonNames[i]) {
				boxColor = colors[i];
			}
		}
		

		for(int i = 0; i < jExButtonNames.length; i++) {
			if( name == jExButtonNames[i]) {
				exBoxColor = exColors[i];
			}
		}
		
		if(name == "보색 변경") {
			Color color = boxColor;
			int r = 255 - color.getRed() ;
			int g = 255 - color.getGreen() ;
			int b = 255 - color.getBlue() ;
			color = new Color(r,g,b);
			boxColor = color;
		}
		
		if(name == "ColorChooser") {
			JColorChooser jcc = new JColorChooser();
			Color color = jcc.showDialog(null, "Chooser", boxColor);
			boxColor = color;
		}
		
		
		ColorBox.repaint();
		
	}
	

	
	
}











public class ColorBoxChooser {

	public static void main(String[] args) {
		JFrame f = new JFrame("DrawTextShape");
		f.setContentPane(new ColorBoxCanvas());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
		
		

	}

}
