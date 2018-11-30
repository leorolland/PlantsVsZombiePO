package entities;

import game.Entite;
import game.StdDraw;

import java.util.Arrays;
import java.util.List;

public abstract class Plant extends Entite {
	

	/**
	 * Points de vie de la plante
	 */
	private int hp;
	
	/**
	 * Coût (en soleils) de la plante
	 */
	private int cost;

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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Plant(int ligne, int colonne, int hp, int cost, String[] sprites) {
		super(0.06 + 0.10 * colonne, 0.06 + 0.15 * ligne);
		this.hp = hp;
		this.cost = cost;
		this.sprites = Arrays.asList(sprites);
	}

	@Override
	public void step() {

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
	
	@Override
	public void click() {
		
	}

}
