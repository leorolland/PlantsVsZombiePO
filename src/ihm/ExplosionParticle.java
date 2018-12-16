package ihm;

/**
 * Particule d'explosion
 */
public class ExplosionParticle extends Particle {
	
	// Constantes particulières à la particule d'explosion
	private static final int TEMPS = 700;
	private static final String[] SPRITES = {
		"/assets/images/explosion/1.png",
		"/assets/images/explosion/2.png",
		"/assets/images/explosion/3.png",
		"/assets/images/explosion/4.png",
		"/assets/images/explosion/5.png",
		"/assets/images/explosion/6.png",
		"/assets/images/explosion/7.png",
		"/assets/images/explosion/8.png",
		"/assets/images/explosion/9.png",
		"/assets/images/explosion/10.png",
		"/assets/images/explosion/11.png",
		"/assets/images/explosion/12.png",
		"/assets/images/explosion/13.png"
	};
	private static final int FREQUENCY = 3;

	private static final double SCALE_FACTOR = 0.2;
	
	/**
	 * Fait apparaître une explosion aux coordonnées X et Y
	 * @param x
	 * @param y
	 */
	public ExplosionParticle(double x, double y) {
		super(x, y, TEMPS, SPRITES, FREQUENCY, SCALE_FACTOR);
	}

}
