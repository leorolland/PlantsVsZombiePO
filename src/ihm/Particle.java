package ihm;

import game.Entite;
import game.StdDraw;
import game.Timer;

/**
 * Une particule est un objet anim� qui dispara�t au bout d'un nombre de secondes donn�e
 * Elle n'a ni vie, ni d�gat, ni aucune int�raction, elle sert seulement d'am�liorations
 * graphique
 * @author black
 *
 */
public class Particle extends Entite {
	
	/**
	 * Timer qui d�finit quand la particule doit cesser de vivre.
	 */
	private Timer disparitionEntite;
	
	/**
	 * Liste des images d�finissant la particule
	 */
	private String[] sprite;
	
	/**
	 * Fr�quence de mise � jour du sprite in (images^-1)
	 * C'est � dire "toutes les combien d'images on change de sprite"
	 */
	private int spriteAnimationFrequency;
	
	/**
	 * Compteur local pour l'animation des sprites
	 */
	private int spriteAnimationCounter;
	
	/**
	 * Compte les image rendues depuis l'apparition de la particule.
	 */
	private int renderCount;
	
	/**
	 * Echelle de rendu (affichage)
	 */
	private double scaleFactor;
	
	/**
	 * Une particule est un objet anim� qui dispara�t au bout d'un nombre de secondes donn�e
	 * Elle n'a ni vie, ni d�gat, ni aucune int�raction, elle sert seulement d'am�liorations
	 * graphique
	 * @param x Coordonn�e X
	 * @param y Coordonn�e Y
	 * @param temps (en milisecondes) temps de survie de la particule
	 * @param sprites sprites d'animation de la particule (liens vers des images)
	 * @param spriteAnimationFrequency 
	 */
	public Particle(double x, double y, int temps, String[] sprites, int spriteAnimationFrequency, double scale) {
		super(x, y);
		this.disparitionEntite = new Timer(temps);
		this.sprite = sprites;
		this.spriteAnimationFrequency = spriteAnimationFrequency;
		this.spriteAnimationCounter = 0;
		this.renderCount = 0;
		this.scaleFactor = scale;
	}

	/**
	 * Determine si la particule est prete a disparaitre ou non
	 * pour le processus de rendu
	 * @return true si elle doit etre supprim�e
	 */
	public boolean hasFinished() {
		return this.disparitionEntite.hasFinished();
	}
	
	@Override
	public void step() {
		
	}

	@Override
	public void dessine() {
		// On incr�mente le compteur d'image
		this.renderCount++;
		// Si on a compt� assez d'image pour changer de sprite, on incr�mente le spriteAnimationCounter
		if (this.renderCount % this.spriteAnimationFrequency == 0) {
			this.spriteAnimationCounter++;
			// Si le SpriteAnimationCounter d�passe le nombre de sprites, on remet � z�ro le compteur
			if (this.spriteAnimationCounter > this.sprite.length - 1) 
				this.spriteAnimationCounter = 0;
		}
		// On affiche la particule
		StdDraw.picture(getX(), getY(), this.sprite[this.spriteAnimationCounter], scaleFactor, scaleFactor);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
