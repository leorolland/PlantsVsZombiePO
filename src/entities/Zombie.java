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
	 * Sprites (Liste des images de l'animation)
	 */
	private List<String> sprites;

	/**
	 * Sprite animation frame counter
	 */
	private int spriteAnimationFrame = 0;

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
	public Zombie(int ligne, int hp, double speed, int atq, String[] sprites) {
		super(1, 0.06 + 0.15 * ligne);
		this.hp = hp;
		this.speed = speed;
		this.atq = atq;
		this.sprites = Arrays.asList(sprites);
	}
	
	@Override
	public void step() {
		this.position.setX(this.getX() - 0.0010 * this.speed);
	}
	
	@Override
	public void dessine() {
		// Dessin du sprite correct
		StdDraw.picture(this.getX(), this.getY(), this.sprites.get(this.spriteAnimationFrame), 0.05, 0.1);
		// Incrément de l'animation de sprite
		if (this.spriteAnimationFrame + 1 < this.sprites.size())
			this.spriteAnimationFrame++;
		else
			this.spriteAnimationFrame=0;
	}

}
