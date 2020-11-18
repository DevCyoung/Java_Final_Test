package section07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class JDiaPro extends JDialog implements ActionListener{
	
	public TextField tf = new TextField(10);
	public JButton r = new JButton("����");
	public JButton b = new JButton("�Ķ�");
	private JDiaProgram owner;
	
	
	
	public JDiaPro(JDiaProgram owner , String title , boolean value) {
		super(owner , title , value);
		this.owner = owner;
		
		
		JPanel parentLayout = new JPanel(new BorderLayout());
		
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		
		p1.add(tf);
		
		
		p2.add(r);
		p2.add(b);
		
		r.addActionListener(this);
		b.addActionListener(this);
		
		
		
		parentLayout.add(p1 , BorderLayout.NORTH);
		parentLayout.add(p2 , BorderLayout.CENTER);
		
		super.setContentPane(parentLayout);
		parentLayout.setPreferredSize(new Dimension(400,400));
		
		super.setVisible(true);
		super.setSize(300,300);
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().toString();
		Container con =  owner.getContentPane();
		if( name == "����") {
			con.setBackground(Color.red);
			System.out.println("������ư�� ����");
			
		}
		else {
			con.setBackground(Color.blue);
		}
		

		
	}
	
	
	
	
	
}

class JDiaProgram extends JFrame implements ActionListener {
	
	public TextField tf = new TextField(10);
	public JButton b = new JButton("����");
	
	
	public JDiaProgram(String title) {
		super(title);
		
		JPanel parentLayout = new JPanel(new BorderLayout());
		
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		
		p1.add(tf);
		p2.add(b);
		
		
		
		
		
		parentLayout.add(p1 , BorderLayout.NORTH);
		parentLayout.add(p2 , BorderLayout.SOUTH);
		
		b.addActionListener(this);
		
				
		
		super.setContentPane(parentLayout);
		super.setVisible(true);
		super.setSize(500,500);
		
		super.setLocation(400,200);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JDiaPro pro = new JDiaPro(this, "���̾�α�", true);
		
	}
	
	
	
}





public class JDiaPro01 {

	public static void main(String[] args) {
		JDiaProgram pro = new JDiaProgram("����");
		


	}

}