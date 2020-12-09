package Swing;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import javax.swing.*;


class MenuTest extends JMenuBar{
	
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	
	public MenuTest() {
		
		menuItem1 = new JMenuItem("�츮����");
		menuItem2 = new JMenuItem("Ǫ����Ǫ����");
		
		JMenu menu = new JMenu("���괭����");
		
		menu.add(menuItem1);
		menu.addSeparator();
		menu.add(menuItem2);
		
		JMenu menu2 = new JMenu("�нǼ�");
		
		JMenu subMenu = new JMenu("SUB1");
		JMenu subMenu2 = new JMenu("SUB2");
		menu2.add(subMenu);
		menu2.add(subMenu2);
		
		for( int i = 0; i < 10; i++ ) {
			JMenuItem mi = new JMenuItem("***");
			subMenu.add(mi);
			subMenu2.add(mi);
		}
		
		
		
		super.add(menu);
		super.add(menu2);
		
	}
	
	
	
	
}






public class JMenuBarDemo {

	public static void main(String[] args) {
		JFrame f = new JFrame("JFrame Button");
		f.setJMenuBar(new MenuTest());
	
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();



	}

}
