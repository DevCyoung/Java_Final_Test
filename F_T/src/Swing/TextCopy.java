package Swing;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


class TextPanel extends JPanel{
	
	public JTextField jt1;
	public JTextField jt2;
	
	public TextListener tl = new TextListener(this);
	
	public TextPanel() {
		super.setLayout(new GridLayout(3,1));
		
		JPanel jp1 = new JPanel();
		JLabel jl = new JLabel("문자열 복사하기");
		
		jp1.add(jl);
		
		JPanel jp2 = new JPanel(new FlowLayout());
		
		
		jt1 = new JTextField(5);
		jt2 = new JTextField(5);
		
		jp2.add(jt1);
		jp2.add(jt2);
		
		
		jt1.addMouseListener(tl);
		
		JPanel jp3 = new JPanel();
		JButton jButton = new JButton("복사");
		jp3.add(jButton);
		
		jButton.addActionListener(tl);
	
		super.add(jp1);
		super.add(jp2);
		super.add(jp3);
		
		
		
		
	}
	
	
	
	
	
	
	
}


class TextListener  implements MouseListener , ActionListener{
	
	TextPanel tp;
	
	
	public TextListener(TextPanel tp) {
		this.tp = tp;
		
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		tp.jt1.setText("");
		
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
	public void actionPerformed(ActionEvent e) {
		
		if( e.getActionCommand().toString() == "복사") {
			tp.jt2.setText(tp.jt1.getText());
		}

		
	}
	
}




public class TextCopy {

	public static void main(String[] args) {
	
		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new TextPanel());
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		
		


	}

}
