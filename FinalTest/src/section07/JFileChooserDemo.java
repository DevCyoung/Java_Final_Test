package section07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

class JFilePro extends JFrame implements ActionListener{
	
	private JTextArea textArea;
	
	
	
	public JFilePro(String title) {
		super(title);
		
		textArea = new JTextArea(5,30);
		
		
		JPanel parentLayout = new JPanel(new BorderLayout());
		
		JPanel p1 = new JPanel(new FlowLayout());
		
		JButton open = new JButton("�ҷ�����");
		JButton save = new JButton("�����ϱ�");
		JButton chagne = new JButton("������");
		
		open.addActionListener(this);
		save.addActionListener(this);
		chagne.addActionListener(this);
		
		p1.add(open);
		p1.add(save);
		p1.add(chagne);
		
	
		parentLayout.add(textArea , BorderLayout.NORTH);
		parentLayout.add(p1 , BorderLayout.SOUTH);
		
		
		
		
		
		
		
		super.setContentPane(parentLayout);
		super.setVisible(true);
		super.pack();
		super.setLocation(500, 500);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().toString();
		JFileChooser fc = new JFileChooser(".");
		switch (name) {
		case "�ҷ�����":
			fileLoad(fc);
			
			break;
		case "�����ϱ�":
			fileSave(fc);
			break;
		case "������":
			ChangeColor();
			
			break;
			
			
		
		
		default:
			break;
			
		}
		
		
		
	}
	
	public void fileLoad(JFileChooser fc) {
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
				String lineString;
				while( ( lineString = br.readLine() ) != null) {
					textArea.append(lineString+"\n");
				}
				br.close();
				
			}catch (Exception e) {
				
			}
		}
		
	}
	
	public void fileSave(JFileChooser fc) {
		String path = null;
		fc.setFileFilter(new FileNameExtensionFilter("java ����", "txt"));
		if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				path = fc.getSelectedFile().toString();
				if(path == null )
					return;
				
				BufferedWriter br = new BufferedWriter(new FileWriter(path));
				br.write(textArea.getText());
				br.close();	
			}catch (Exception e) {
				
			}
		}
	}
	
	public void ChangeColor() {
		Color color = JColorChooser.showDialog(null, "���� �ٲ���" , Color.red);
		textArea.setBackground(color);
		
	}
	
	
	
}

public class JFileChooserDemo {

	public static void main(String[] args) {
		JFilePro pro = new JFilePro("���������");
		
		


	}

}
