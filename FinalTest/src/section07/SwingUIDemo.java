package section07;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


class SwingUIPro extends JFrame implements ActionListener  {
	
	private JTextField tf1 , tf2;
	
	public SwingUIPro(String title) {
		super(title);
		
		JPanel parentLayout = new JPanel(new BorderLayout());
		//1
		JPanel p1 = new JPanel();
		JLabel label = new JLabel("문자열 복사하기");
		p1.add(label);
		//2
		JPanel p2 = new JPanel(new FlowLayout());
		tf1 = new JTextField(9);
		tf2 = new JTextField(9);
		p2.add(tf1);
		p2.add(tf2);
		tf2.setEditable(false);
		//3
		JPanel p3 = new JPanel();
		JButton b = new JButton("복사");
		p3.add(b);
		b.addActionListener(this);
		b.setSize(new Dimension(1000,11));
		tf1.setPreferredSize(new Dimension(400,400));
		
		tf1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf1.setText("");
			
			}
		});
		
		parentLayout.add(p1 , BorderLayout.NORTH);
		parentLayout.add(p2 , BorderLayout.CENTER);
		parentLayout.add(p3 , BorderLayout.SOUTH);
	
		super.setContentPane(parentLayout);
		
		super.setDefaultCloseOperation(JFramePro.EXIT_ON_CLOSE);
		
		super.setVisible(true);
		super.pack();
		
	}
	
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		tf2.setText(tf1.getText());
		

		
	}










	

















	
}




public class SwingUIDemo {

	public static void main(String[] args) {
		SwingUIPro pro = new SwingUIPro("asdasd");
		

	}

}
