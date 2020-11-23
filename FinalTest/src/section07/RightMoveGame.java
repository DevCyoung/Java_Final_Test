package section07;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



class MyCanvas extends Canvas{
 
 
 
	private int x;

	 @Override
	 public void paint(Graphics g) {
	  
	  
	  g.drawRect(x + 10, 50, 50, 50);
	  
	  
	 }
	 
	 
	 public void Move() {
	  
	  x += 10;
	  
	  repaint();
	  
	 }
 

}


class MoveFrame extends Frame{
 
	MyCanvas MyCanvas;
 
 
 	public MoveFrame(String str) {
	 
	  super(str);
	  
	  MyCanvas = new MyCanvas();
	
	  
	  super.add(MyCanvas , BorderLayout.CENTER);
	  
	  Button b1 = new Button(">>>>>>>>>>>>>>>>>");
	  
	  super.add(b1 , BorderLayout.SOUTH);
	  b1.addActionListener(new ActionListener() {
	   
	   @Override
	   public void actionPerformed(ActionEvent arg0) {
	    MyCanvas.Move();
	    
	
	    
	   }
	  });
	  
	
	  super.setVisible(true);  
	  
	  this.setLocation(400, 400);
	  this.setSize(800, 400);
	 
	  
	  this.addWindowListener(new WindowAdapter() {
	   @Override
	   public void windowClosing(WindowEvent e) {
	    System.exit(0);
	    
	   
	   }
	  });
  
  
 
  
  
  
 }
 
 
 
 
  

 
 
 
 
 
 
}









public class RightMoveGame {

	public static void main(String[] args) {
		MoveFrame pro = new MoveFrame
				("asd");

	}

}
