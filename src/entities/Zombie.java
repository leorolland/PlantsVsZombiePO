package entities;

import java.util.Arrays;
import java.util.List;

import game.Entite;
import game.StdDraw;
import game.Timer;

public abstract class Zombie extends Entite {
	
	public static final int DEFAULT_ATQ_TICK_FREQUENCY = 1000;// in miliseconds;
	
	/**
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
	
	/**
	 * Définit si le zombie est prêt à attaquer ou non.
	 */
	private boolean isReadyToAttack;
	
	/**
	 * Une fois le compteur écoulé, le booléen isReadyToAttack peut
	 * repasser à true, le zombie est de nouveau prêt à attaquer
	 */
	private Timer readyToAttackTimer;
	
	public boolean isReadyToAttack() {
		return isReadyToAttack;
	}

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
		this.isReadyToAttack = true;
		this.readyToAttackTimer = new Timer(0);
	}
	@Override
	public void step() {
		// Si le zombie est en état de marche, on le fait avancer proportionellement à sa vitesse.
		if (this.state == ZombieState.MARCHE)
			this.position.setX(this.getX() - 0.0010 * this.speed);
		// Si le timer d'attente entre chaque attaque est écoulé on réinitialise l'état à true
		if (this.readyToAttackTimer.hasFinished())
			this.isReadyToAttack = true;
	}
	
	@Override
	public void dessine() {
		// Incrément du compteur de temps d'apparition
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

	public void attaque(Plant a) {
		this.isReadyToAttack = false;
		a.setHp(a.getHp()-this.atq);
		this.readyToAttackTimer = new Timer(DEFAULT_ATQ_TICK_FREQUENCY);
	}
	
}
