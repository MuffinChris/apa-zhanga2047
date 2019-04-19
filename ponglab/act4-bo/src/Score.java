import java.awt.Color;
import java.awt.Graphics;

public class Score {

	private Color maincolor;
	private Color seccolor;
	
	public Score(Color mc, Color to) {
		maincolor = mc;
		seccolor = to;
	}
	
	public void updateScore(Graphics graphToBack, int score, int width, int height) {

	    int textwidth = (int) (0.4 * width);
	    int textheight = (int) (0.7 * height);
	    Block cover = new Block(textwidth, textheight - (int) (2 * 0.033333 * textheight), (int) (0.1 * width), (int) (height * 0.1), Color.WHITE);
	    cover.draw(graphToBack);
	    graphToBack.setColor(seccolor);
	    graphToBack.drawString("Score: " + score, textwidth, textheight);
  }
	
	public void draw(Graphics graphToBack, int score, int width, int height) {

	    graphToBack.setColor(maincolor);
	    int textwidth = (int) (0.4 * width);
	    int textheight = (int) (0.7 * height);
	    graphToBack.setColor(seccolor);
	    graphToBack.drawString("Score: " + score, textwidth, textheight);
	}
	
}
