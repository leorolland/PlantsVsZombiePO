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
	 * √âtat du zombie
	 */
	private ZombieState state;

	/**
	 * Sprites (Liste des images de l'animation)
	 */
	private List<String> sprites;

	/**
	 * Sprite animation frame counter
	 */
	private int spriteAnimationFrame;
	
	/**
	 * Nombre d'images gÈnÈrÈes depuis l'apparition du zombie
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
	 * Cr√©e un zombie sur une ligne d√©finie en param√®tres.
	 * @param ligne {1 - 5} La ligne sur laquelle appara√Æt le zombie
	 * @param hp les points de vie du zombie
	 * @param atq les points d'attaque du zombie
	 */
	public Zombie(int ligne, int hp, double speed, int atq, String[] sprites) {
		super(1, 0.06 + 0.122 * ligne);
		this.hp = hp;
		this.speed = speed;
		this.atq = atq;
		this.sprites = Arrays.asList(sprites);
		this.spriteAnimationFrame = 0;
		this.frameElapsed = 0;
	}
	
	@Override
	public void step() {
		this.position.setX(this.getX() - 0.0010 * this.speed);
	}
	
	@Override
	public void dessine() {
		// IncrÈment du compteur de temps d'apparition
		this.frameElapsed++;
		// Dessin du sprite correct
		StdDraw.picture(this.getX()+0.028, this.getY()-0.065, "../assets/images/shadow.png", 0.1, 0.06);
		StdDraw.picture(this.getX(), this.getY(), this.sprites.get(this.spriteAnimationFrame), 0.08, 0.1);
		// Incr√©ment de l'animation de sprite
		if (this.frameElapsed % 12 == 0) {
			if (this.spriteAnimationFrame + 1 < this.sprites.size())
				this.spriteAnimationFrame++;
			else
				this.spriteAnimationFrame=0;
		}
	}

	@Override
	public void click() {
		
	}
	
}
