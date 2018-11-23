package ihm;

public class Reserve extends Text {
	
	/**
	 * Quantité de soleils stoqués par le joueur
	 */
	private int amount;
	
	public Reserve(int amount) {
		super("Réserve : " + String.valueOf(amount), 0.8, 0.1 );
		this.amount =amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.setContent(String.valueOf(this.amount));
		this.amount = amount;
	}
	
}
