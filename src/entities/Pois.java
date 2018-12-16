package entities;

import game.Entite;
import game.StdDraw;

public class Pois extends Entite {
	private double hp=1;
	private double speed = -4.0;
	private int atq = 25;
	private double sprite_rotation = 0;
	private static final String[] DEFAULT_SPRITES= {"../assets/images/roundup.png"};
	
	public Pois(double ligne, double colonne) {
		super(ligne, colonne);
	}
	
	@Override	
	public void step() {
		this.position.setX(this.getX() - 0.0010 * this.speed);
	}
	
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getAtq() {
		return atq;
	}
	public void setAtq(int atq) {
		this.atq = atq;
	}
	public void attaque(Zombie a) {
		a.hit(this.atq);
		this.setHp(0);
	}
	public void dessine() {
		StdDraw.picture(getX(), getY(), DEFAULT_SPRITES[0], 0.05, 0.03, sprite_rotation);
		StdDraw.picture(getX(), getY()-0.05, "/assets/images/shadow.png", 0.05, 0.03);
		sprite_rotation -= 5;
	}

	@Override
	public void click() {

	}
}