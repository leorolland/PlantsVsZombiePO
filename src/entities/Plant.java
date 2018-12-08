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
	 * Temps avant de pouvoir racheter la plant apres l'avoir acheter
	 */
	private int timeBeforeRebuying;

	/**
	 * Sprite animation frame counter
	 */
	private int spriteAnimationFrame = 0;

	/**
	 * Définit si la plante est prête à attaquer ou non
	 */
	private boolean isReadyToAttack;

	/**
	 * Compteur de frames écoulées depuis l'apparition de la plante
	 * Permet de définir la fréquence d'animation notamment
	 */
	private int frameElapsed;

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
	
	public boolean isReadyToAttack() {
		return isReadyToAttack;
	}

	public void setReadyToAttack(boolean isReadyToAttack) {
		this.isReadyToAttack = isReadyToAttack;
	}

	public Plant(int ligne, int colonne, int hp, int cost, int timeBeforeRebuying, String[] sprites) {
		super(0.015 + 0.10 * colonne, 0.06 + 0.122 * ligne);
		this.hp = hp;
		this.cost = cost;
		this.sprites = Arrays.asList(sprites);
		this.timeBeforeRebuying=timeBeforeRebuying;
		this.frameElapsed = 0;
	}
	public int getTimeBeforeRebuying(){
		return timeBeforeRebuying;
	}
	public void setTimeBeforeRebuying(int timeBeforeRebuying) {
		this.timeBeforeRebuying=timeBeforeRebuying;
	}

	@Override
	public void step() {

	}

	@Override
	public void dessine() {
		// Incrément du compteur de frames
		this.frameElapsed++;
		// Dessin du sprite correct
		StdDraw.picture(this.getX()+0.028, this.getY()-0.065, "../assets/images/shadow.png", 0.15, 0.07);
		StdDraw.picture(this.getX(), this.getY(), this.sprites.get(this.spriteAnimationFrame), 0.1, 0.12);
		// Incrément de l'animation de sprite
		if (this.frameElapsed % 7 == 0) {
			if (this.spriteAnimationFrame + 1 < this.sprites.size())
				this.spriteAnimationFrame++;
			else 
				this.spriteAnimationFrame = 0;
			if (this.spriteAnimationFrame == 3)
				// Arrivé à la troisième frame, on considère que la plante est prête à attaquer
				this.setReadyToAttack(true);
		}
	}


	
	@Override
	public void click() {
		
	}

}
