package Swing;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class JDialogLoad extends JDialog{

	public JTextField tf;
	
	public JButton b1;
	public JButton b2;
	public JDialogLoad() {
		
		super.setLayout(new GridLayout(2,1));
		
		tf = new JTextField("Show Dialog");
		
		b1 = new JButton("OK");
		b2 = new JButton("CNACEL");
		
		b1.addActionListener(new DiaActionLitenser());
		
		JPanel jp1 = new JPanel();
		
		JPanel jp2 = new JPanel(new FlowLayout());
		
		jp1.add(tf);
		
		
		
		jp2.add(b1);
		jp2.add(b2);
		
		super.add(jp1);
		super.add(jp2);
		
	}
	
	
}

class JDiaLoadFrame extends JPanel{
	
	public JTextField tf;
	
	public JButton b1;
	public JButton b2;
	
	
	public JDiaLoadFrame() {
		super.setLayout(new GridLayout(2,1));
		
		tf = new JTextField("Show Dialog");
		
		b1 = new JButton("OK");
		b2 = new JButton("CNACEL");
		
		b1.addActionListener(new DiaActionLitenser());
		
		JPanel jp1 = new JPanel();
		
		JPanel jp2 = new JPanel(new FlowLayout());
		
		jp1.add(tf);
		
		
		
		jp2.add(b1);
		jp2.add(b2);
		
		super.add(jp1);
		super.add(jp2);
	}
	
	
}

class DiaActionLitenser implements ActionListener{
	
	JDiaLoadFrame jdf;

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().toString();
		if( name == "OK") {
			JDialogLoad jl = new JDialogLoad();
			jl.setPreferredSize(new Dimension(150,150));
			jl.setVisible(true);
			jl.pack();
			jl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jl.setLocation(500, 500);
			
		}
				
		
		
	}
	
	
	
}





public class JDiaLog {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new JDiaLoadFrame());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
	}

}
