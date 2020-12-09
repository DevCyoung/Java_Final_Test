package Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


class FileListener implements ActionListener{
	
	ChooserPanel cp;
	JFileChooser fc = new JFileChooser(".");
	
	
	public FileListener(ChooserPanel cp) {
		this.cp = cp;
		
		
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().toString();
		if(name == "불러오기") {
			
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
					fc.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							System.out.println(fc.getSelectedFile());
							
						}
					});
					
					
					if( fc.getSelectedFile() == null )
						System.out.println(fc.getSelectedFile());
					
					String line = null;
					
					while( ( line = br.readLine() ) != null ) {
						cp.textArea.append(line + "\n");
						
					}
					br.close();
					
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				
				
				
				
			}
			else {
				System.out.println(fc.getSelectedFile());
			}
			
			
		}
		else if( name == "저장하기") {
			
			if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
				
				// 중용
				
				fc.addChoosableFileFilter(new FileNameExtensionFilter("txt", "txt"));
				
				
				try {
					
					BufferedWriter bw = new BufferedWriter(new FileWriter(fc.getSelectedFile()));
					bw.write(cp.textArea.getText());
					bw.close();

					
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
			
		}

		
	}
	
}

class ChooserPanel extends JPanel{
	
	public JTextArea textArea;
	public JButton save;
	public JButton load;
	
	public FileListener fl;
	
	
	public ChooserPanel() {
		super.setLayout(new BorderLayout());
		fl = new FileListener(this);
		
		textArea = new JTextArea(5,30);
		
		save = new JButton("저장하기");
		load = new JButton("불러오기");
		
		save.addActionListener(fl);
		load.addActionListener(fl);
		
		JPanel p = new JPanel(new FlowLayout());
		p.add(save);
		p.add(load);
		
		JPanel p2 = new JPanel();
		p2.add(textArea);
		
		super.add(p2 ,  BorderLayout.CENTER);
		super.add(p , BorderLayout.SOUTH);
		
		
		
	}
	
	
}


public class FileChooserDemo {

	public static void main(String[] args) {
		JFrame f = new JFrame("JFrame Button");
		f.setContentPane(new ChooserPanel());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();

	}

}
