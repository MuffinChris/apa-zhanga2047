//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

   public Shape(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		//finish this constructor
   }


   public void draw(Graphics window)
   {
      window.setColor(color);
      //window.fillRect(xPos, yPos, width, height);

      //draw whatever you want
      //    ^
      //  [ :: ]
      //    ()
      
      window.drawArc(xPos, yPos, width, height, 0, -180);
      window.drawRect(xPos + 20, yPos - (yPos/10), width /4, height /4);
      window.drawRect(xPos + 50, yPos - (yPos/10), width/4, height/4);

   }

   //BONUS
   //add in set and get methods for all instance variables

   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}