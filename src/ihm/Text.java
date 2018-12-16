package ihm;

import game.Position;
import game.StdDraw;
import java.awt.Font;


/**
 * �l�ment d'affichage de texte � l'�cran avec un param�tre de taille
 *
 */
public class Text {

	private String content;
	protected Position position;
	private Font font; 

	/**
	 * Permet de cr�er un �l�ment texte
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
