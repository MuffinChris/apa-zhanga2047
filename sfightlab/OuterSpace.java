//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
  
  private int timebase = 5;
  private int timebaseduration = 500;
  private int timebasecd = 1200;

  /* uncomment once you are ready for this part
   */
   private AlienHorde horde;
   private Bullets shots;
  

  private boolean[] keys;
  private BufferedImage back;
  
  private boolean gamestate = false;
  private boolean startgame = false;
  private int diffi = 10;

  private boolean endless = true;
  private int eTicker = 1000;
  
  public OuterSpace()
  {
    setBackground(Color.black);

    keys = new boolean[8];

    //instantiate other instance variables
    //Ship, Alien
    ship = new Ship(300, 450, 30, 50, 2);
    shots = new Bullets();
    horde = new AlienHorde(diffi);

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
	  if (keys[4] == true && !startgame) {
		  gamestate = true;
		  startgame = true;
	  }
	  if(gamestate) {
		  paint(window);
	  } else if (!startgame){
		  window.setColor(Color.CYAN);
		  window.drawString("PRESS SPACE TO START",300, 300);
	  }
  }

  public void paint( Graphics window )
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);
    
    ship.draw(graphToBack);
    
    if(keys[0] == true)
    {
      ship.move("LEFT");
    }
    if(keys[1] == true)
    {
      ship.move("RIGHT");
    }
    if(keys[2] == true)
    {
      ship.move("UP");
    }
    if(keys[3] == true)
    {
      ship.move("DOWN");
    }
    if(keys[4] == true) {
    	if (ship.getCD()) {
	    	Ammo ammo = new Ammo(ship.getX() + 10, ship.getY() - 10, -4, Color.YELLOW, 0);
	    	shots.add(ammo);
    	}
    	ship.setbasecd(25);
    	ship.shoot(graphToBack);
    }
    if (keys[5] == true) {
    	if (ship.getCD()) {
    		for (int i = 0; i < 30; i++) {
    			int speed = (int) (Math.random() * 5 + 1);
    			int xspeed = (int) (Math.random() * 3);
    			double neg = Math.random();
    			int mod = 1;
    			if (neg >= 0.5) {
    				mod = -1;
    			}
		    	Ammo ammo = new Ammo(ship.getX() + 10, ship.getY() - 20, -speed, Color.GREEN, xspeed * mod);
		    	shots.add(ammo);
    		}
    	}
    	ship.setbasecd(300);
    	ship.shoot(graphToBack);
    }
    
    if (keys[7] == true) {
    	timebase = 10;
    	
    }
    
    ship.setSCD(ship.getSCD()-1);
    
    if (keys[6] == true) {
    	if (ship.getSCD() <= 0) {
    		ship.setSCD(1000);
    	}
    }
    
    
    
    
    for (Alien al : horde.getList()) {
    	if (al.getY() > StarFighter.HEIGHT) {
    		graphToBack.setColor(Color.RED);
			graphToBack.drawString("==> OBLITERATION TIME <==", 250, 300 );
    		Ammo ammo = new Ammo(al.getX() + 20, al.getY() + al.getWidth() + 5, -1, Color.RED, 0);
	    	shots.add(ammo);
  	    }
    	if (al.getY() > 0) {
	    	double random = Math.random();
	    	if (al.getType().equalsIgnoreCase("railgun")) {
	    		if (al.getRailgunTicker() > 1) {
	    			al.setRailgunTicker(al.getRailgunTicker() - 1);
				    
	    		}
	    		if (al.getRailgunTicker() == 1) {
	    			for (int i = 0; i < 200; i++) {
		    			int speed = (int) (1 + 100 * Math.random());
				    	Ammo ammo = new Ammo(al.getX() + 20, al.getY() + al.getHeight() + 5, speed, Color.RED, 0);
				    	shots.add(ammo);
	    			}
	    			al.setRailgunTicker(0);
	    			try
	    		    {
	    		      URL url = getClass().getResource("railgun.jpg");
	    		      al.setImage(ImageIO.read(url));
	    		    }
	    		    catch(Exception e)
	    		    {
	    		      //feel free to do something here
	    		    	e.printStackTrace();
	    		    }
	    		}
	    		if (random >= 0.99D) {
	    			if (al.getRailgunTicker() <= 0) {
	    			al.setRailgunTicker(150);
	    			try
	    		    {
	    		      URL url = getClass().getResource("railgunHOT.jpg");
	    		      al.setImage(ImageIO.read(url));
	    		    }
	    		    catch(Exception e)
	    		    {
	    		      //feel free to do something here
	    		    	e.printStackTrace();
	    		    }
	    			}
			    }
	    	} else {
			    if (random >= 0.998D) {
			    	Ammo ammo = new Ammo(al.getX() + 20, al.getY() + al.getWidth() + 5, 1, Color.RED, 0);
			    	shots.add(ammo);
			    }
	    	}
		    if (al.getHp() > 1) {
		    	random = Math.random();
			    if (random >= 0.8D) {
			    	int speed = (int) (1 + 3 * Math.random());
			    	int yspeed = (int) (1 + 3 * Math.random());
			    	double neg = Math.random();
	    			int mod = 1;
	    			if (neg >= 0.5) {
	    				mod = -1;
	    			}
			    	Ammo ammo = new Ammo(al.getX() + 80, al.getY() + al.getHeight() + 5, speed, Color.RED, yspeed * mod);
			    	shots.add(ammo);
			    }
		    }
    	}
    }

    //add code to move Ship, Alien, etc.
    if (!ship.getCD()) {
    	ship.setTicker(ship.getTicker() - 1);
    	if (ship.getTicker() < 0) {
    		ship.toggleCD();
    	}
    }
    
    
    //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
    horde.moveEmAll();
    horde.drawEmAll(graphToBack);
    horde.removeDeadOnes(shots.getList());
    eTicker--;
    if ((horde.getSize() <= 0 && !endless) || (endless && eTicker <= 0)) {
    	diffi+=10;
    	horde.setSize(5 + diffi/30);
    	horde.populate();
    	System.out.println(diffi + " " + horde.getSize());
    	if ((diffi>=60 && !endless) || diffi >= 300) {
    		gamestate = false;
    		graphToBack.setColor(Color.GREEN);
			graphToBack.drawString("YOU WON!!!", 250, 250 );
    	}
    	if (diffi % 100 == 0 && diffi >= 100) {
    		Alien bigal = new Alien(300, 10, 200, 50, 1, 20, "Alien");
    		horde.add(bigal);
    	}
    	eTicker+=1000 - diffi * 3;
    }

    for (int i = shots.getList().size() - 1; i >= 0; i--) {
    	Ammo a = shots.getList().get(i);
    	if (a.getColor() == Color.RED) {
    		if (a.getY() + a.getHeight() <= ship.getY() + ship.getHeight() && a.getY() >= ship.getY()) {
	    		if ((a.getX() >= ship.getX() && a.getX() + a.getWidth() <= ship.getX() + ship.getWidth())) {
	    			if (!(ship.getSCD() >= 500)) {
		    			gamestate = false;
		    			graphToBack.setColor(Color.RED);
		    			graphToBack.drawString("YOU DIED!!!", 250, 250 );
	    			} else {
	    						  a.setSpeed(0);
	    						  a.setxSpeed(0);
	    						  a.setY(-50);
	    						  shots.getList().remove(i);
	    			}
	    		}
    		}
    	}
    }
    
    for (Alien a : horde.getList()) {
		if (a.getY() <= ship.getY() + ship.getHeight() && a.getY() + a.getHeight() >= ship.getY()) {
    		if ((a.getX() + a.getWidth() >= ship.getX() && a.getX() <= ship.getX() + ship.getWidth())) {
    			gamestate = false;
    			graphToBack.setColor(Color.RED);
    			graphToBack.drawString("YOU DIED!!!", 250, 250 );
    		}
		}
    
    }
    graphToBack.setColor(Color.RED);
    graphToBack.drawString("Star Fighter Game (GAME OF THE YEAR: 2019)", 250, 50 );
    graphToBack.drawString("CONTROLS: ", 250, 80);
    graphToBack.drawString("WASD - Movement", 250, 100);
    graphToBack.drawString("SPACE - Standard Fire", 360, 100);
    graphToBack.drawString("E - Scattershot", 500, 100);
    graphToBack.drawString("Q - Shield", 600, 100);
    
    shots.moveEmAll();
    shots.drawEmAll(graphToBack);
    shots.cleanEmUp();
    
    if (ship.getSCD() >= 500) {
    	graphToBack.setColor(Color.CYAN);
    	for (int i = 0; i < 3; i++) {
    		graphToBack.drawOval(ship.getX() - i, ship.getY() - i, ship.getWidth() + i, ship.getHeight() + i);
    	}
    }
    
    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_E)
    {
      keys[5] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_Q)
    {
      keys[6] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SHIFT)
    {
      keys[7] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_E)
    {
      keys[5] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_Q)
    {
      keys[6] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SHIFT)
    {
      keys[7] = false;
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}

