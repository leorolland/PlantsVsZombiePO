package entities;

import ihm.Reserve;

public class Sun extends Bonus {

    // Default BasicZombie properties
    public static final int DEFAULT_BONUS = 30;
    public static final String[] DEFAULT_SPRITES = {
		"../assets/images/sun.png"
    };
    private static final double DEFAULT_HITRANGE = 0.05;
    
    
    /*
     * Définit si l'entité à déjà été cliquée une fois ou non
     */
    private boolean clicked;
    
    public Sun() {
        super(Math.random(), Math.random(), Sun.DEFAULT_BONUS, Sun.DEFAULT_SPRITES, Sun.DEFAULT_HITRANGE);
        clicked = false;
    }
    public Sun(int x, int y) {
        super(x, y, Sun.DEFAULT_BONUS, Sun.DEFAULT_SPRITES, Sun.DEFAULT_HITRANGE);
        clicked = false;
    }
    
    /**
     * @return true si le soleil à déjà été cliqué une fois
     */
    public boolean isClicked() {
    		return this.clicked;
    }
    
    @Override
	public void click() {
    		clicked = true;
    		System.out.println("Soleil cliqué");
    		
    		
	}

}