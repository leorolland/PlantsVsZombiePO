package entities;

import java.util.Arrays;
import java.util.List;

import game.Entite;
import game.StdDraw;

public abstract class Zombie extends Entite {
	
	/*
	 * Points de vie (Health Points)
	 */
	private int hp;
	
	/**
	 * Vitesse (en cases par seconde)
	 */
	private double speed;
	
	/**
	 * Points d'attaque
	 */
	private int atq;

	/**
	 * État du zombie
	 */
	private ZombieState state;

	/**
	 * Sprites (Liste des images de l'animation)
	 */
	private List<String> walkingSprite;
	
	/**
	 * Sprites (Liste des images de l'animation)
	 */
	private List<String> attackingSprite;

	/**
	 * Sprite animation frame counter
	 */
	private int spriteAnimationFrame;
	
	/**
	 * Nombre d'images g�n�r�es depuis l'apparition du zombie
	 */
	private int frameElapsed;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getAtq() {
		return atq;
	}

	public void setAtq(int atq) {
		this.atq = atq;
	}

	
	/**
	 * Crée un zombie sur une ligne définie en paramètres.
	 * @param ligne {1 - 5} La ligne sur laquelle apparaît le zombie
	 * @param hp les points de vie du zombie
	 * @param atq les points d'attaque du zombie
	 */
	public Zombie(int ligne, int hp, double speed, int atq, String[] walkingSprite, String[] attackSprite) {
		super(1, 0.06 + 0.122 * ligne);
		this.hp = hp;
		this.speed = speed;
		this.atq = atq;
		this.walkingSprite = Arrays.asList(walkingSprite);
		this.spriteAnimationFrame = 0;
		this.frameElapsed = 0;
		this.state = ZombieState.MARCHE;
		this.attackingSprite = Arrays.asList(attackSprite);
	}
	
	@Override
	public void step() {
		if (this.state == ZombieState.MARCHE)
			this.position.setX(this.getX() - 0.0010 * this.speed);
	}
	
	@Override
	public void dessine() {
		// Incr�ment du compteur de temps d'apparition
		this.frameElapsed++;
		
		// Sprite actuellement utilisé (dépend du mode
		List<String> sprite = null;
		// Speed animation frequency in steps^-1
		if (this.state == ZombieState.MARCHE) {			
			sprite = this.walkingSprite;
		}
		else if (this.state == ZombieState.ATTAQUE) {
			sprite = this.attackingSprite;
		}
		
		// Dessin du sprite correct
		StdDraw.picture(this.getX()+0.028, this.getY()-0.065, "../assets/images/shadow.png", 0.1, 0.06);
		StdDraw.picture(this.getX(), this.getY(), sprite.get(this.spriteAnimationFrame), 0.08, 0.1);
		// Incrément de l'animation de sprite
		if (this.frameElapsed % 9 == 0) {
			if (this.spriteAnimationFrame + 1 < sprite.size())
				this.spriteAnimationFrame++;
			else
				this.spriteAnimationFrame=0;
		}
	}

	public ZombieState getState() {
		return state;
	}

	public void setState(ZombieState state) {
		// Si l'état est le même que l'état précédent, on abandonne
		if (this.state == state)
			return;
		this.state = state;
		this.spriteAnimationFrame = 0;
	}

	@Override
	public void click() {
		
	}
	
}
