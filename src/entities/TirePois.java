package entities;

public class TirePois extends Plant {
	
	public static final int DEFAULT_HP = 300;
	public static final int DEFAULT_COST = 50;
	private static final String[] DEFAULT_SPRITES = {};
	public static final int DEFAULT_TIME_BEFORE_REBUYING=5;
	public static final int DEFAULT_ATQ_SPEED = 0;
	
	public TirePois(int ligne, int colonne) {
		super(ligne, colonne, Sunflower.DEFAULT_HP, Sunflower.DEFAULT_COST,Sunflower.DEFAULT_TIME_BEFORE_REBUYING, DEFAULT_SPRITES);
	}
	
}