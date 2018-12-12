package entities;

import game.Entite;

public class Pois extends Entite {
	private double hp=1;
	private double speed = -0.50;
	private int atq =25;
	private static final String[] DEFAULT_SPRITES= {"../assets/images/roundup.png"};
	
	public Pois(double ligne, double colonne) {
		super(colonne,ligne);
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
		a.setHp(a.getHp()-this.atq);
		this.setHp(0);
	}
	public void dessine() {
		
	}
}