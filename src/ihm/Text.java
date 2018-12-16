package ihm;

import game.Position;
import game.StdDraw;
import java.awt.Font;

public class Text {

	private String content;
	protected Position position;
	private Font font; 

	public Text(String content, double x, double y, int fontSize) {
		this.content = content;
		this.font = new Font("Arial", Font.BOLD, fontSize);
		position = new Position(x, y);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void dessine() {
   		StdDraw.setFont(this.font);
		StdDraw.text(position.getX(), position.getY(), content);
	}
}
