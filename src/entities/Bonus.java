package entities;

import game.Entite;

import java.util.Arrays;
import java.util.List;
import game.StdDraw;
import game.Timer;

/**
 * Les bonus sont des entités qui quand ils sont cliqués disparaissent pour attribuer un bonus de soleils au joueur
 * cette classe doit etre implémentée notamment par les soleils qui sont un cas particulier de bonus
 * @author black
 *
 */
public abstract class Bonus extends Entite {

    /**
     * Nombre de soleils donnÃ©s par le bonus
     */
    public int points;

    /**
	 * Sprites (Liste des images de l'animation)
	 */
	private List<String> sprites;

	/**
	 * Sprite animation frame counter
	 */
	private int spriteAnimationFrame;
	
	/**
	 * Timer
	 */
	private Timer expirationTimer;
	
	/**
	 * Temps ï¿½coulï¿½ depuis l'apparition du bonus (en ticks)
	 */
	private int frameElapsed;

	public Bonus(double x, double y, int points, String[] sprites, int visibilityTime) {
        super(x, y, 0);
        this.points = points;
        this.sprites = Arrays.asList(sprites);
        this.spriteAnimationFrame = 0;
        this.frameElapsed = 0;
        this.expirationTimer = new Timer(visibilityTime);
    }
    
    public Bonus(double x, double y, int points, String[] sprites, int visibilityTime, double hitRange) {
        super(x, y, hitRange);
        this.points = points;
        this.sprites = Arrays.asList(sprites);
        this.spriteAnimationFrame = 0;
        this.frameElapsed = 0;
        this.expirationTimer = new Timer(visibilityTime);
    }
    
    /*
     * Permet de savoir si le timer du bonus est terminï¿½
     * @return true si le timer est terminï¿½
     */
    public boolean hasExpired() {
    	return this.expirationTimer.hasFinished();
    }
    
    @Override
    public void step() {

    }

    @Override
    public void dessine() {
    	// Incrï¿½ment du compteur de temps
    	this.frameElapsed++;
        // Dessin du sprite correct
		StdDraw.picture(this.getX(), this.getY(), this.sprites.get(this.spriteAnimationFrame), 0.06, 0.06);
		// IncrÃ©ment de l'animation de sprite
		if (this.spriteAnimationFrame + 1 < this.sprites.size())
			this.spriteAnimationFrame++;
		else
			this.spriteAnimationFrame=0;
    }

    @Override
	public void click() {
    	
	}
}