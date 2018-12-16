package entities;

/**
 * Les soleils (cerveaux dans le jeu) sont de bonus cliquables, ils impl�ment donc bonus
 * @author black
 *
 */
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
    
    public Sun(int visibilityTime) {
        super(Math.random(), 0.1 + Math.random()* 0.7, Sun.DEFAULT_BONUS, Sun.DEFAULT_SPRITES, visibilityTime, Sun.DEFAULT_HITRANGE);
        clicked = false;
    }
    public Sun(int x, int y, int visibilityTime) {
        super(x, y, Sun.DEFAULT_BONUS, Sun.DEFAULT_SPRITES, visibilityTime, Sun.DEFAULT_HITRANGE);
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