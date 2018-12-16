package ihm;

import game.Position;
import game.StdDraw;
import java.awt.Font;


/**
 * Élément d'affichage de texte à l'écran avec un paramètre de taille
 *
 */
public class Text {

	private String content;
	protected Position position;
	private Font font; 

	/**
	 * Permet de créer un élément texte
	 * @param content Contenu du texte
	 * @param x coord x
	 * @param y coord y 
	 * @param fontSize la hauteur de la police en pixels
	 */
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
