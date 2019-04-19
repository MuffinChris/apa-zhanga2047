import java.awt.Color;
import java.awt.Graphics;

public class Score {

	private Color maincolor;
	private Color teamone;
	private Color teamtwo;
	
	public Score(Color mc, Color to, Color tw) {
		maincolor = mc;
		teamone = to;
		teamtwo = tw;
	}
	
	public void updateScore(Graphics graphToBack, int redScore, int blueScore, int width, int height) {

	    int textwidth = (int) (0.4 * width);
	    int textheight = (int) (0.7 * height);
	    Block cover = new Block(textwidth, textheight - (int) (2 * 0.033333 * textheight), (int) (0.1 * width), (int) (height * 0.1), Color.WHITE);
	    cover.draw(graphToBack);
	    graphToBack.setColor(teamtwo);
	    graphToBack.drawString("Red Score: " + redScore, textwidth, textheight);
	    graphToBack.setColor(teamone);
	    graphToBack.drawString("Blue Score: " + blueScore, textwidth, textheight + (int) (0.033333 * textheight));
  }
	
	public void draw(Graphics graphToBack, int redScore, int blueScore, int width, int height) {

	    graphToBack.setColor(maincolor);
	    int textwidth = (int) (0.4 * width);
	    int textheight = (int) (0.7 * height);
	    graphToBack.drawString("SCORE: ", textwidth, textheight - (int) (2 * 0.033333 * textheight));
	    graphToBack.setColor(teamtwo);
	    graphToBack.drawString("Red Score: " + redScore, textwidth, textheight);
	    graphToBack.setColor(teamone);
	    graphToBack.drawString("Blue Score: " + blueScore, textwidth, textheight + (int) (0.033333 * textheight));
	}
	
}
