package entities;

public class PoisPlant extends Plant {

	// Default Sunflower properties
	public static final int DEFAULT_HP = 300;
	public static final int DEFAULT_COST = 50;
	private static final String[] DEFAULT_SPRITES = {
		"../assets/images/basic_plant/frame_00_delay-0.1s.png",
		"../assets/images/basic_plant/frame_01_delay-0.1s.png",
		"../assets/images/basic_plant/frame_02_delay-0.1s.png",
		"../assets/images/basic_plant/frame_03_delay-0.1s.png",
		"../assets/images/basic_plant/frame_04_delay-0.2s.png",
		"../assets/images/basic_plant/frame_05_delay-0.2s.png",
		"../assets/images/basic_plant/frame_06_delay-0.2s.png",
		"../assets/images/basic_plant/frame_07_delay-0.2s.png",
		"../assets/images/basic_plant/frame_08_delay-0.2s.png",
		"../assets/images/basic_plant/frame_09_delay-0.2s.png",
		"../assets/images/basic_plant/frame_10_delay-0.2s.png",
		"../assets/images/basic_plant/frame_11_delay-0.2s.png",
		"../assets/images/basic_plant/frame_12_delay-0.2s.png"
	};
	public static final int DEFAULT_TIME_BEFORE_REBUYING=5;
	
	public PoisPlant(int ligne, int colonne) {
		super(ligne, colonne, DEFAULT_HP, DEFAULT_COST, DEFAULT_TIME_BEFORE_REBUYING, DEFAULT_SPRITES);
	}

}
