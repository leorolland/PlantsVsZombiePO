package game;


public abstract class Entite {
	
	// la position de l'entite
	protected Position position;
	
	/**
	 * Rayon de hitbox
	 * Définit le rayon dans lequel l'entité peut être cliqué
	 * Définit également la boite de collision pour reçevoir des projectiles
	 */
	protected double hitRadius;
	
	/*
	 * Constructeur d'entité sans hitbox
	 */
	public Entite(double x, double y) {
		position = new Position(x, y);
		this.hitRadius = 0;
	}
	
	/*
	 * Constructeur d'entité avec hitbox
	 */
	public Entite(double x, double y, double hitRadius) {
		position = new Position(x, y);
		this.hitRadius = hitRadius;
	}

	public double getX() {
		return position.getX();
	}
	
	public double getY() {
		return this.position.getY();
	}
	
	public double getHitRadius() {
		return this.hitRadius;
	}
	
	public void setHitRadius(double hitRadius) {
		this.hitRadius = hitRadius;
	}
	
	public void setPosition(Position p){
		this.position = p;
	}
	
	// met a jour l'entite : déplacement, effectuer une action
	public abstract void step();
	
	// dessine l'entite, aux bonnes coordonnees
	public abstract void dessine();
	
	// Quand l'entité est cliquée
	public abstract void click();


}
