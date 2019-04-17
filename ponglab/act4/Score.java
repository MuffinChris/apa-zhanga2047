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

	    Block cover = new Block(384, 400, 30, 70, Color.WHITE);
	    cover.draw(graphToBack);
	    graphToBack.setColor(teamtwo);
	    int textwidth = (int) (0.4 * width);
	    int textheight = (int) (0.7 * width);
	    graphToBack.drawString("Red Score: " + redScore, textwidth, textheight);
	    graphToBack.setColor(teamone);
	    graphToBack.drawString("Blue Score: " + blueScore, textwidth, textheight + (int) (0.033333 * textheight));
  }
	
	public void draw(Graphics graphToBack, int redScore, int blueScore, int width, int height) {

	    graphToBack.setColor(maincolor);
	    int textwidth = (int) (0.4 * width);
	    int textheight = (int) (0.7 * width);
	    graphToBack.drawString("SCORE: ", textwidth, textheight - (int) (2 * 0.033333 * textheight));
	    graphToBack.setColor(teamtwo);
	    graphToBack.drawString("Red Score: " + redScore, textwidth, textheight);
	    graphToBack.setColor(teamone);
	    graphToBack.drawString("Blue Score: " + blueScore, textwidth, textheight + (int) (0.033333 * textheight));
	}
	
}
