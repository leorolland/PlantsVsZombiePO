package entities;

/**
 * Mod�lise un cone de travaux qui peut servir de protection � appliquer sur un zombie;
 */
public class BucketProtection extends Protection {
	
	// Valeur par d�faut du nombre de vies du cone de travaux
	public static final int DEFAULT_HP = 200;
	// Valeur par d�faut du nombre de vies du cone de travaux � partir duquel la texture du cone doit changer
	private static final int DEFAULT_LOW_HP = 100;
	// Texture par d�faut du cone de travaux plein de vie
	private static final String DEFAULT_TEXTURE_FULL = "/assets/images/bucket/full.png";
	// Texture par d�faut du cone de travaux abim�
	private static final String DEFAULT_TEXTURE_LOW = "/assets/images/bucket/low.png";
	
	/**
	 * Mod�lise un cone de travaux qui peut servir de protection � appliquer sur un zombie;
	 */
	public BucketProtection(Zombie attached_zombie) {
		super(attached_zombie, DEFAULT_HP, DEFAULT_LOW_HP, DEFAULT_TEXTURE_FULL, DEFAULT_TEXTURE_LOW);
	}
	
}
