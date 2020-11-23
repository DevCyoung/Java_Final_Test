package section07;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class SwingComponet extends JPanel implements ActionListener{
	
	public SwingComponet() {
		
		//parent
		super.setLayout(new GridLayout(1, 2));
		
		JPanel p1 = new JPanel(new GridLayout(2,1));
		
		
		JLabel l1 = new JLabel("JLabel" , JLabel.CENTER);
		JCheckBox ShowString = new JCheckBox("���ڿ� ǥ��");
		
		l1.setBackground(Color.green);
		l1.setOpaque(true);
		ShowString.addActionListener(this);
		
		p1.add(l1);
		p1.add(ShowString);
		
		JPanel p2 = new JPanel(new GridLayout(3,1));
		p2.setBorder(BorderFactory.createTitledBorder("������"));
		
		JRadioButton red = new JRadioButton("RED");
		JRadioButton green = new JRadioButton("GREEN");
		JRadioButton blue = new JRadioButton("BLUE");
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(red);
		bg.add(green);
		bg.add(blue);
		
		p2.add(red);
		p2.add(green);
		p2.add(blue);
		
		
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		
		
		
		super.add(p1);
		super.add(p2);
		
		
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}







public class ComponetCheckBox {

	public static void main(String[] args) {
		JFrame f = new JFrame("asdasd");
		f.setContentPane(new SwingComponet());
		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		


	}

}