package Swing;

import javax.swing.*;

import Swing.ListModel;


class ButtonaAligment extends JPanel{
	
	
	public ButtonaAligment() {
		
		super.setLayout( new BoxLayout(this , BoxLayout.LINE_AXIS) );
		
		JButton b1 = new JButton("��ư1");
		JButton b2 = new JButton("��ư2");
		JButton b3 = new JButton("��ư3");
		JButton b4 = new JButton("��ư4");
		
		b1.setAlignmentY(0);
		b2.setAlignmentY(1);
		b3.setAlignmentY(0.5f);
		b4.setAlignmentY(0.25f);
		
		super.add(b1);
		super.add(b2);
		super.add(b3);
		super.add(b4);
		
		
		
		
	}
	
	
	
	
	
	
}





public class BoxLayoutDemo {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new ButtonaAligment());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();



	}

}
;