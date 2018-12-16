package entities;

import game.Entite;
import game.StdDraw;

/**
 * Modélise une protection qui peut être portée par un zombie
 * La protection à une quantité de HP et la texture de la protection
 * doit changer selon son nombre de HP.
 * Une fois qu'elle n'a plus de HP, la protection disparaît du zombie (à gérer dans la classe zombie)
 */
public abstract class Protection extends Entite {
	
	/**
	 * Zombie auquel est attaché la protection
	 */
	private Zombie attached_zombie;

	/**
	 * Points de vie de la protection
	 */
	private int hp;
	
	public Zombie getAttached_zombie() {
		return attached_zombie;
	}

	public void setAttached_zombie(Zombie attached_zombie) {
		this.attached_zombie = attached_zombie;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Valeur de HP à partir de laquelle la texture devient cette la plus abimée
	 */
	private int low_hp_value;
	
	/**
	 * Texture de la protection quand ses HP sont supérieurs à low_hp_value
	 */
	private String texture_full;
	
	/**
	 * Texture de la protection quand ses HP sont inférieurs à low_hp_value
	 */
	private String texture_low;
	
	public Protection(Zombie attached_zombie, int hp, int low_hp_value, String texture_full, String texture_low) {
		super(attached_zombie.getX(), attached_zombie.getY());
		this.attached_zombie = attached_zombie;
		this.hp = hp;
		this.low_hp_value = low_hp_value;
		this.texture_full = texture_full;
		this.texture_low = texture_low;
	}

	@Override
	public void step() {
		
	}

	@Override
	public void dessine() {
		String texture = hp > low_hp_value ? texture_full : texture_low;
		StdDraw.picture(this.attached_zombie.getX(), this.attached_zombie.getY() + 0.1, texture);
	}

	@Override
	public void click() {

	}

}
