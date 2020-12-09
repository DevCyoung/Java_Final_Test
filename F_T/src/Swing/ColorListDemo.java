package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ColorListPro extends JPanel implements ListSelectionListener{
	
	
	String[] colors = new String[]{
		"RED" , "BLUE" , "GREEN" , "YELLOW" , "PUPLE"	
	};
	
	JList<String> listString;
	JList<ImageIcon> listIcon;
	JTextField tf;
	
	public ColorListPro() {
		super.setLayout(new BorderLayout());
	
		String basePath = "Images/Colors/";
		ImageIcon[] icons = new ImageIcon[colors.length];
		
		for(int i= 0; i < colors.length; i++ ) {
			icons[i] = new ImageIcon(basePath + colors[i] + ".png");
			System.out.println(basePath + colors[i] + ".png");
			
		}
		
		listString = new JList<String>(colors);
		listIcon   = new JList<ImageIcon>(icons);
		tf         = new JTextField();
		tf.setEditable(false);
		
		listString.addListSelectionListener(this);
		listIcon.addListSelectionListener(this);
		
		JScrollPane pane1 = new JScrollPane();
		pane1.setPreferredSize(new Dimension(150,90));
		pane1.getViewport().add(listString);
		
		
		JScrollPane pane2 = new JScrollPane();
		pane2.setPreferredSize(new Dimension(150,90));
		pane2.getViewport().add(listIcon);
		
		super.add(pane1 , BorderLayout.WEST);
		super.add(pane2 , BorderLayout.EAST);		
		super.add(tf , BorderLayout.SOUTH);
		
		
		
		
		
	
	}
	
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting())
			return;
		
		
		if(e.getSource().equals(listString)) {
			listIcon.setSelectedIndex(listString.getSelectedIndex());
		}
		else {
			listString.setSelectedIndex(listIcon.getSelectedIndex());
		}

		
	}
	
	
	
}



public class ColorListDemo {

	public static void main(String[] args) {

		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new ColorListPro());
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
	}

}
