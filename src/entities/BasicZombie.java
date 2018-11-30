package entities;


public class BasicZombie extends Zombie {
	
	// Default BasicZombie properties
	public static final int DEFAULT_HP = 200;
	public static final double DEFAULT_SPEED = 0.25;
	public static final int DEFAULT_ATQ = 30;
	private static final String[] DEFAULT_SPRITES = {
		"../assets/images/basic_zombie.png"
	};

	public BasicZombie(int ligne) {
		// Construction de la liste des sprites
		super(ligne, BasicZombie.DEFAULT_HP, BasicZombie.DEFAULT_SPEED, BasicZombie.DEFAULT_ATQ, BasicZombie.DEFAULT_SPRITES);
	}
	
}
