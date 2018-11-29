package entities;

public class Sunflower extends Plant {
	
	// Default Sunflower properties
	public static final int DEFAULT_HP = 300;
	public static final int DEFAULT_COST = 50;
	private static final String[] DEFAULT_SPRITES = {
		"../assets/images/basic_zombie.png"
	};
	
	public Sunflower(int ligne, int colonne) {
		super(ligne, colonne, Sunflower.DEFAULT_HP, Sunflower.DEFAULT_COST, Sunflower.DEFAULT_SPRITES);
	}

}
