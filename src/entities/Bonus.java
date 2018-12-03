package entities;

import game.Entite;

import java.util.Arrays;
import java.util.List;
import game.StdDraw;
import game.Timer;

public abstract class Bonus extends Entite {

    /**
     * Nombre de soleils donnés par le bonus
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
	 * Temps �coul� depuis l'apparition du bonus (en ticks)
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
     * Permet de savoir si le timer du bonus est termin�
     * @return true si le timer est termin�
     */
    public boolean hasExpired() {
    	return this.expirationTimer.hasFinished();
    }
    
    @Override
    public void step() {

    }

    @Override
    public void dessine() {
    	// Incr�ment du compteur de temps
    	this.frameElapsed++;
        // Dessin du sprite correct
		StdDraw.picture(this.getX(), this.getY(), this.sprites.get(this.spriteAnimationFrame), 0.06, 0.06);
		// Incrément de l'animation de sprite
		if (this.spriteAnimationFrame + 1 < this.sprites.size())
			this.spriteAnimationFrame++;
		else
			this.spriteAnimationFrame=0;
    }

    @Override
	public void click() {
    	
	}
}