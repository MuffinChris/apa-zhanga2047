//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;

public class TheGame extends JFrame
{
  private static final int WIDTH = 1000;
  private static final int HEIGHT = 600;

  public TheGame()
  {
    super("PONG");
    setSize(WIDTH,HEIGHT);

    Breakout game = new Breakout(WIDTH, HEIGHT);

    ((Component)game).setFocusable(true);
    getContentPane().add(game);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main( String args[] )
  {
    TheGame run = new TheGame();
  }
}