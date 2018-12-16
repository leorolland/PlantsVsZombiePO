package entities;

public class ZombieKamikaze extends Zombie {
	public static final int DEFAULT_HP = 200;
	public static final double DEFAULT_SPEED = 0.50;
	public static final int DEFAULT_ATQ = 5000;
	private static final String[] DEFAULT_SPRITES_WALK = {
		"../assets/images/kamikaze_zombie_walk/frame_0_delay-0.5s.png",
		"../assets/images/kamikaze_zombie_walk/frame_1_delay-0.5s.png",
		"../assets/images/kamikaze_zombie_walk/frame_3_delay-0.5s.png",
		"../assets/images/kamikaze_zombie_walk/frame_4_delay-0.5s.png",
		"../assets/images/kamikaze_zombie_walk/frame_5_delay-0.5s.png"
	};
	/**
	 * Fait apparaitre un zombie kamikaze sur une ligne
	 * @param ligne le numero de la ligne [ 1 ; 5 ]
	 * @return 
	 */
	public  ZombieKamikaze(int ligne) {
		super(ligne, ZombieKamikaze.DEFAULT_HP, ZombieKamikaze.DEFAULT_SPEED, ZombieKamikaze.DEFAULT_ATQ, ZombieKamikaze.DEFAULT_SPRITES_WALK, ZombieKamikaze.DEFAULT_SPRITES_WALK);
	}
	@Override
	public void attaque(Plant a) {
		if(this.getState()==ZombieState.ATTAQUE) {
			a.setHp(a.getHp()-DEFAULT_ATQ);
			this.setHp(0);
		}
	}
}
