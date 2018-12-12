package entities;

public class ShieldPlant extends Plant {

	// Default Sunflower properties
	public static final int DEFAULT_HP = 1200;
	public static final int DEFAULT_COST = 50;
	private static final String[] DEFAULT_SPRITES = {
		"../assets/images/plant_shield/frame_0_delay-0.2s.png",
		"../assets/images/plant_shield/frame_1_delay-0.2s.png",
		"../assets/images/plant_shield/frame_2_delay-0.2s.png",
		"../assets/images/plant_shield/frame_1_delay-0.2s.png"
	};
	public static final int DEFAULT_TIME_BEFORE_REBUYING=2000; // in miliseconds
	
	public ShieldPlant(int ligne, int colonne) {
		super(ligne, colonne, DEFAULT_HP, DEFAULT_COST, DEFAULT_TIME_BEFORE_REBUYING, DEFAULT_SPRITES);
	}

}