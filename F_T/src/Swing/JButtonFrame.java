package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;


import javax.swing.*;


public class JButtonFrame {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("JFrame Button");
		
		JPanel p = new JPanel();
		
		JButton button =new JButton("OK");
		
		
		
		p.add(button );
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().toString() == "OK") {
					System.out.println("asd");
				}
				
			}
		});
		
		
		
		f.setPreferredSize(new Dimension(300,300));
		f.setLayout(new BorderLayout());
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		
		
		
		
		
		


	}

}
