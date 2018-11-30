package game;

public class Battlefield {
	private Entite [][]plantField;
	private Entite [] zombieField; 
	public Battlefield() {
		this.plantField=new Entite[5][9];
		this.zombieField=new Entite[5];
	}
	public Entite rightestPlantInALine(int ligne) {
		int i=0;
		while(plantField[5][i+1]==null || i<8) {
			i++;
		}
		return plantField[5][i+1];
	}
	public Entite leftestZombieInALine(int ligne) {
		return null;
	}
	
	
}
