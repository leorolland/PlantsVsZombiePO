package ihm;

public class Reserve extends Text {
	
	/**
	 * Quantité de soleils stoqués par le joueur
	 */
	private int amount;
	
	public Reserve(int amount) {
		super("Reserve : " + String.valueOf(amount), 0.2, 0.9);
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
