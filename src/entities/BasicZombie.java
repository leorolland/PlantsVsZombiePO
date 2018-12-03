package entities;

public class BasicZombie extends Zombie {
	
	// Default BasicZombie properties
	public static final int DEFAULT_HP = 200;
	public static final double DEFAULT_SPEED = 0.25;
	public static final int DEFAULT_ATQ = 30;
	private static final String[] DEFAULT_SPRITES = {
		"../assets/images/basic_zombie_walk/frame_0_delay-0.5s.png",
		"../assets/images/basic_zombie_walk/frame_1_delay-0.5s.png",
		"../assets/images/basic_zombie_walk/frame_2_delay-0.5s.png",
		"../assets/images/basic_zombie_walk/frame_3_delay-0.5s.png",
		"../assets/images/basic_zombie_walk/frame_4_delay-0.5s.png",
		"../assets/images/basic_zombie_walk/frame_5_delay-0.5s.png"
	};

	/**
	 * Fait apparaitre un zombie basique sur une ligne
	 * @param ligne le numero de la ligne [ 1 ; 5 ]
	 */
	public BasicZombie(int ligne) {
		// Construction de la liste des sprites
		super(ligne, BasicZombie.DEFAULT_HP, BasicZombie.DEFAULT_SPEED, BasicZombie.DEFAULT_ATQ, BasicZombie.DEFAULT_SPRITES);
	}
	
}
