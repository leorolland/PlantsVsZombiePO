package entities;

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
	
	// Attaque 
	private int atq;

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
	 * @param ligne
	 */
	public Zombie(int ligne) {
		super(1, 0.06 + 0.15 * ligne);
	}
	
	@Override
	public void step() {
		this.position.setX(this.getX() - 0.0025);
	}
	
	@Override
	public void dessine() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(this.position.getX(), this.position.getY(), 0.02);
	}

}
