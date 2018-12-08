package ihm;

public class Reserve extends Text {
	
	/**
	 * Quantité de soleils stoqués par le joueur
	 */
	private int amount;
	
	public Reserve(int amount) {
		super(String.valueOf(amount), 0.067, 0.84, 30);
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}

	/**
	 * Tente de retirer amount sur le compte, et renvoie le résultat
	 * @return true si l'opération est un succès, false sinon
	 */
	public boolean pay(int amount) {
		if (amount <= this.amount) {
			this.amount -= amount;
			return true;
		} 
		return false;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		this.setContent(String.valueOf(this.amount));
	}
	
}
