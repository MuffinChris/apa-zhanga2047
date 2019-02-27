//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    //call other methods
    upperBody(window);
    lowerBody(window);
    
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(300, 100, 200, 100);
    
    window.setColor(Color.RED);
    window.fillOval(300, 100, 100, 50);
    window.fillOval(400, 100, 100, 50);

    //add more code here
    
  }

  public void upperBody( Graphics window )
  {
	  window.setColor(Color.BLACK);
	  window.fillRect(250, 200, 300, 200);
	  window.drawLine(300, 200, 250, 150);
	  window.drawLine(500, 200, 650, 300);
    //add more code here
  }

  public void lowerBody( Graphics window )
  {

    //add more code here
	  window.setColor(Color.BLUE);
	  window.fillRect(250, 400, 300, 100);
	  window.drawLine(300, 400, 250, 550);
	  window.drawLine(500, 400, 650, 500);
  }
}
