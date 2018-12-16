package entities;

public class ZombieKamikaze extends Zombie {
	public static final int DEFAULT_HP = 200;
	public static final double DEFAULT_SPEED = 1;
	public static final int DEFAULT_ATQ = 0;
	private static final String[] DEFAULT_SPRITES= {};
	
	/**
	 * Fait apparaitre un zombie kamikaze sur une ligne
	 * @param ligne le numero de la ligne [ 1 ; 5 ]
	 * @return 
	 */
	public  ZombieKamikaze(int ligne) {
		super(ligne, ZombieKamikaze.DEFAULT_HP, ZombieKamikaze.DEFAULT_SPEED, ZombieKamikaze.DEFAULT_ATQ, ZombieKamikaze.DEFAULT_SPRITES, ZombieKamikaze.DEFAULT_SPRITES);
	}
	@Override
	public void attaque(Plant a) {
		if(this.getState()==ZombieState.ATTAQUE) {
			a.setHp(a.getHp()-200);
			this.hit(999999);
		}
	}
}
