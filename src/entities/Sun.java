package entities;

public class Sun extends Bonus {

    // Default BasicZombie properties
    public static final int DEFAULT_BONUS = 30;
    public static final String[] DEFAULT_SPRITES = {
		"../assets/images/basic_zombie.png"
    };
    
    public Sun() {
        super(Math.random(), Math.random(), Sun.DEFAULT_BONUS, Sun.DEFAULT_SPRITES);
    }
    public Sun(int x, int y) {
        super(x, y, Sun.DEFAULT_BONUS, Sun.DEFAULT_SPRITES);
    }

}