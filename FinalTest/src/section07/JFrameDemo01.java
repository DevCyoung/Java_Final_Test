package section07;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.*;

class JFramePro extends JFrame{
	
	JPanel p1 = new JPanel();
	
	public JFramePro(String title) {
		super(title);
		
		p1.setLayout(new FlowLayout());
		p1.add(new JButton("J��ư"));
		p1.add(new JButton("J��ư"));
		p1.add(new JButton("J��ư"));
		p1.add(new JButton("J��ư"));
		p1.add(new JButton("J��ư"));
		
		super.setContentPane(p1);
		
		super.setVisible(true);
		super.pack();
		super.setLocation(400, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	
	
	
}









public class JFrameDemo01 {

	public static void main(String[] args) {
		JFramePro pro = new JFramePro("��Ѿ���̴�");
	}

}
