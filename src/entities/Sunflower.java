package entities;

public class Sunflower extends Plant {
	
	// Default Sunflower properties
	public static final int DEFAULT_HP = 300;
	public static final int DEFAULT_COST = 50;
	private static final String[] DEFAULT_SPRITES = {
			"../assets/images/sunflower/frame_0_delay-0.2s.png",
			"../assets/images/sunflower/frame_1_delay-0.2s.png",
			"../assets/images/sunflower/frame_2_delay-0.2s.png",
			"../assets/images/sunflower/frame_1_delay-0.2s.png"
		};
	public static final int DEFAULT_TIME_BEFORE_REBUYING = 2000; // in miliseconds
	public Sunflower(int ligne, int colonne) {
		super(ligne, colonne, Sunflower.DEFAULT_HP, Sunflower.DEFAULT_COST,Sunflower.DEFAULT_TIME_BEFORE_REBUYING, Sunflower.DEFAULT_SPRITES);
	}
}
