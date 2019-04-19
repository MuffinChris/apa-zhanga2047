import java.awt.Color;

public class Wall extends Block {

	public Wall() {
		super();
	}
	public Wall(int xPos, int yPos) {
		super(xPos, yPos);
	}
	public Wall(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
	}
	public Wall(int xPos, int yPos, int width, int height, Color color) {
		super(xPos, yPos, width, height, color);
	}
	
}
