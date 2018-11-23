package entities;

import game.Entite;
import game.StdDraw;

public abstract class Plant extends Entite {
	

	/**
	 * Points de vie de la plante
	 */
	private int hp;
	
	/**
	 * Coût (en soleils) de la plante
	 */
	private int cost;

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

	public Plant(int ligne, int colonne) {
		super(0.06 + 0.10 * colonne, 0.06 + 0.15 * ligne);
	}

	@Override
	public void step() {

	}

	@Override
	public void dessine() {
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.filledSquare(this.position.getX(), this.position.getY(), 0.005);
	}

}
