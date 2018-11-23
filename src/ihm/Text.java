package ihm;

import game.Position;
import game.StdDraw;

public abstract class Text {
	private String content;
	protected Position position;
	public Text(String content, double x, double y) {
		this.content=content;
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
		StdDraw.text(position.getX(), position.getY(), content);
	}
}
