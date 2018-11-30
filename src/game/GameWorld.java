package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.BasicZombie;
import entities.Sunflower;
import entities.Sun;
import ihm.Reserve;
import ihm.Text;

public class GameWorld {

	// Configuration des constantes de partie
	Settings difficulty;

	// l'ensemble des entites, pour gerer (notamment) l'affichage
	private static List<Entite> entites;
	
	// l'ensemble des textes affichés à l'écran
	private static List<Text> texts;

	//Pour savoir si la partie est gagnee ou pas
	private static boolean gameWon;

	// Idem pour savoir si le jeu est perdu (si le jeu n'est ni gagne ni perdu, il est en cours)
	private static boolean gameLost;

	// Chronomètre du jeu (en ticks)
	private int tickCount;

	// Réserve de soleils du joueur
	private Reserve reserve;
	
	// Nombre de sunflowers present sur le board
	private int countOfSunflowers;
	
	// constructeur, il faut initialiser notre monde virtuel
	public GameWorld() {

		difficulty = new EasySettings();

		// on cree les collections
		entites = new LinkedList<Entite>();
		texts = new LinkedList<Text>();

		gameWon=false;
		gameLost=false;

		tickCount = 0;
		
		reserve = new Reserve(this.difficulty.getDefaultSuns());
		texts.add(reserve);
		

		// on rajoute une entite de demonstration
		//entites.add(new TrucQuiBouge(0, 0.5));
		entites.add(new BasicZombie(1));
		entites.add(new BasicZombie(2));
		entites.add(new BasicZombie(3));
		entites.add(new BasicZombie(4));
		entites.add(new BasicZombie(5));
		
		entites.add(new Sunflower(1, 1));
		countOfSunflowers++;
		entites.add(new Sunflower(2, 1));
		countOfSunflowers++;
		entites.add(new Sunflower(3, 2));
		countOfSunflowers++;
		entites.add(new Sunflower(4, 3));
		countOfSunflowers++;
		entites.add(new Sunflower(5, 3));
		countOfSunflowers++;


	}

	/**
	 * Gestion des interactions clavier avec l'utilisateur
	 * 
	 * @param key
	 *            Touche pressee par l'utilisateur
	 */
	public void processUserInput(char key) {
		switch (key) {
		case 't':
			System.out.println("Le joueur veut planter un Tournesol...");
			// TODO
			break;
		case 'p':
			System.out.println("Le joueur veut planter un Tire-Pois...");
			// TODO
			break;
		case 'n':
			System.out.println("Le joueur veut planter une Noix...");
			// TODO
			break;

		default:
			System.out.println("Touche non prise en charge");
			break;
		}
	}
	
	/**
	 * Gestion des interactions souris avec l'utilisateur (la souris a été cliquée)
	 * 
	 * @param x position en x de la souris au moment du clic
	 * @param y position en y de la souris au moment du clic
	 */
	public void processMouseClick(double x, double y) {
		for (Entite e : entites) {
			float distanceSquarredFromEntity = (float) Math.pow(e.getX()-x, 2.0) + (float)Math.pow(e.getY()-y, 2.0);
			// On compare les carrés des distances pour optimisation
			if (distanceSquarredFromEntity < Math.pow(e.getHitRadius(), 2.0))
				e.click();
		}
	}

	// on fait bouger/agir toutes les entites
	public void step() {
		tickCount++;
		// Mémorise les entités qui devront être supprimés après cette boucle itérative
		List<Entite> entitiesToRemove = new ArrayList<Entite>();
		for (Entite entite : entites) {
			entite.step();
			if (entite instanceof Sun) {
				if (((Sun)entite).isClicked()) {
					// Suppression de l'entite
					entitiesToRemove.add(entite);
					//Ajout de 25 soleil a la reserve
					reserve.setAmount(reserve.getAmount()+25);
				}
			}
		}
		// Suppression des entités mémorisées
		entitiesToRemove.stream().forEach((e)->entites.remove(e));
		// Apparition des soleils
		if (tickCount % this.difficulty.getSunApparitionFrequency(countOfSunflowers) == 0) {
			entites.add(new Sun());
		}
		// Apparition des zombies 
		if (tickCount % this.difficulty.getBasicZombieApparitionFrequency() == 0) {
			entites.add(new entities.BasicZombie());
		}
	}

	// dessine les entites du jeu
	public void dessine() {

		// affiche les textes
		for (Text text : texts)
			text.dessine();
				
		// affiche les entites
		for (Entite entite : entites)
			entite.dessine();
	}

	public static boolean gameWon() {
		return gameWon;
	}
	
	public static boolean gameLost() {
		return gameLost;
	}
	

}
