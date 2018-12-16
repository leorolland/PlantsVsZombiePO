package ihm;

/**
 * Particule d'explosion
 */
public class PlotchParticle extends Particle {
	
	// Constantes particulières à la particule d'explosion
	private static final int TEMPS = 200;
	private static final String[] SPRITES = {
		"/assets/images/plotch/frame_0_delay-0.1s.png",
		"/assets/images/plotch/frame_1_delay-0.1s.png",
		"/assets/images/plotch/frame_2_delay-0.1s.png",
		"/assets/images/plotch/frame_3_delay-0.1s.png",
		"/assets/images/plotch/frame_4_delay-0.1s.png"
	};
	private static final int FREQUENCY = 3;
	private static final double SCALE_FACTOR = 0.1;

	/**
	 * Fait apparaître une explosion aux coordonnées X et Y
	 * @param x
	 * @param y
	 */
	public PlotchParticle(double x, double y) {
		super(x, y, TEMPS, SPRITES, FREQUENCY, SCALE_FACTOR);
	}

}
