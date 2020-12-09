package Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



class ListModel extends JPanel implements ActionListener , KeyListener , ListSelectionListener{
	
	String[] weak = new String[] {
		"Sun"	 , "Mon" , "Tue"
	};
	DefaultListModel<String> dfList = new DefaultListModel<String>();
	
	JList<String> weakList = new JList<String>(dfList);
	
	JButton add = new JButton("추가");
	JButton remove = new JButton("삭제");
	
	JTextField tf = new JTextField(8);
	
	int pointer = 0;
	
	public ListModel() {
		
		super.setLayout(new BorderLayout());
		
		super.addKeyListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		weakList.addListSelectionListener(this);
		
		
		for(int i = 0; i < weak.length; i++ ) {
			dfList.add(i, weak[i] );
		}
		
		JPanel p1 = new JPanel();
		JScrollPane pane1 = new JScrollPane();
		pane1.getViewport().add(weakList);
		p1.add(pane1);
		
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(tf);
		p2.add(add);
		p2.add(remove);
		
		
		
		super.add( pane1 , BorderLayout.CENTER);
		super.add(p2 , BorderLayout.SOUTH);
		
		
		
		
		
		
		
	
	}
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().toString();
		
		
		if(name == "추가") {
			dfList.add(dfList.getSize(), tf.getText() );
			
		}
		else if(name == "삭제" && weakList.getSelectedValue() != null) {
			if( dfList.getSize() > 0 ) {
			
				dfList.remove(weakList.getSelectedIndex());
				weakList.setSelectedIndex(0);
			}
			
			
		}

		
	}






	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void keyPressed(KeyEvent e) {
		int curPointer = pointer;
		
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("asd");
			pointer--;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			pointer++;
		}
		
		String temp = dfList.getElementAt(curPointer);
		dfList.remove(curPointer);

		pointer = pointer < 0 || pointer > dfList.getSize()  ? pointer : 0;
		dfList.add(pointer, temp);
		weakList.setSelectedIndex(pointer);

		
	}






	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting())
			return;
		
		pointer = weakList.getSelectedIndex();
		
		

		
	}
	
}
















public class ListAddRemoveDemo {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new ListModel());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();


	}

}
