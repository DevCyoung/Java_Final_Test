package Swing;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class TextBoxTest extends JPanel{
	
	public JLabel tf = new JLabel("JLabel");
	
	
	
	public TextBoxTest() {
		
		super.add(tf);
		super.setBackground(Color.red);
	
	}
	
	public void setColor(Color color) {
		super.setBackground(color);
	}
	
	
}

class CheckBoxTest extends JPanel{
	
	public JCheckBox cb = new JCheckBox("문자열 표시" , false);
	
	public CheckBoxTest() {
		cb.setIcon(new ImageIcon("Images/apple.png"));
		super.add(cb);
	}
	
}

class RadioBoxTest extends JPanel{
	
	public static String[] colors = new String[] {
		"red"	,"green", "blue"
	};
	
	public Color[] colors2 = new Color[] {
		Color.red , Color.green , Color.BLUE	
	};
	
	
	
	public RadioBoxTest() {
		JPanel par = new JPanel(new GridLayout(colors.length,1));
		ButtonGroup bg = new ButtonGroup();
		
		for(int i =0; i < colors.length; i++ ) {
			JRadioButton rb = new JRadioButton(colors[i] , false );
			bg.add(rb);
			par.add(rb);

	
		}
		
		super.add(par);
		super.setBorder(BorderFactory.createTitledBorder("바탕색"));
		
		
		
	}
	
}



class Test_05 extends JPanel implements ActionListener{
	
	TextBoxTest p1;
	CheckBoxTest p2;
	RadioBoxTest p3;
	
	public Test_05() {
		
		super.setLayout( new GridLayout(1,2) );
		
		JPanel par1 = new JPanel(new GridLayout(2,1));
		
		
		
		p1 = new TextBoxTest();
		p2 = new CheckBoxTest();
		p3 = new RadioBoxTest();
		
		
		
		
		par1.add(p1);
		par1.add(p2);
		
		super.add(par1);
		super.add(p3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand().toString();
		
		for(int i = 0 ; i < RadioBoxTest.colors.length; i++ ) {
			if(name == p3.colors[i] ) {
				p1.setColor(p3.colors2[i]);
			}
		}
		
		
		

		
	}
	
	
	
}














public class JCheckAndRadio {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new Test_05());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();

	}

}
