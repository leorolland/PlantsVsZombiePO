package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.BasicZombie;
import entities.Sunflower;
import entities.Sun;
import ihm.Reserve;
import ihm.Text;
import ihm.Boutique;

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
	
	// Champ de bataille (stoque les zombies et les plantes)
	private Battlefield battlefield;

	// Boutique du jeu
	private Boutique boutique;
	
	
	// constructeur, il faut initialiser notre monde virtuel
	public GameWorld() {

		difficulty = new EasySettings();

		// on cree les collections
		entites = new LinkedList<Entite>();
		texts = new LinkedList<Text>();
		battlefield = new Battlefield();
		
		gameWon=false;
		gameLost=false;

		tickCount = 0;
		
		reserve = new Reserve(this.difficulty.getDefaultSuns());
		texts.add(reserve);	

		// On instancie la boutique en lui passant le champ de bataille et la réserve en paramètre
		this.boutique = new Boutique(battlefield, reserve);

		// on rajoute une entite de demonstration
		//entites.add(new TrucQuiBouge(0, 0.5));
		battlefield.spawnPlant(Sunflower.class, 1, 1);
		countOfSunflowers++;

		battlefield.spawnPlant(Sunflower.class, 2, 2);
		countOfSunflowers++;

		battlefield.spawnPlant(Sunflower.class, 3, 3);
		countOfSunflowers++;
		
		battlefield.spawnPlant(Sunflower.class, 4, 4);
		countOfSunflowers++;
		
		battlefield.spawnPlant(Sunflower.class, 5, 5);
		countOfSunflowers++;
		
		battlefield.spawnPlant(Sunflower.class, 5, 9);
		countOfSunflowers++;
	}

	/**
	 * Gestion des interactions clavier avec l'utilisateur
	 * 
	 * @param key
	 *            Touche pressee par l'utilisateur
	 */
	public void processUserInput(char key) {
		this.boutique.processKeyboardInput(key);
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
		// Exécution de l afonction step du champ de bataille
		this.battlefield.step();
		// Mémorise les entités qui devront être supprimés après cette boucle itérative
		List<Entite> entitiesToRemove = new ArrayList<Entite>();
		for (Entite entite : entites) {
			entite.step();
			if (entite instanceof Sun) {
				Sun sun = ((Sun)entite);
				if (sun.isClicked() || sun.hasExpired()) {
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
			entites.add(new Sun(this.difficulty.getDefaultSunDisparitionTime()));
		}
		//gestion du niveau de difficult�
		if(this.battlefield.getCountOfZombieSpawned() <=20) {
			////TODO Afficher niveau 1
			// Apparition des zombies 
		if (tickCount % this.difficulty.getBasicZombieApparitionFrequency() == 0) {
			this.battlefield.spawnBasicZombie(BasicZombie.class);
		}
		if(this.battlefield.getCountOfZombieSpawned()==5) {
			this.battlefield.spawnBasicZombie(BasicZombie.class/*, Future Classe*/);
		}
		}
		if(this.battlefield.getCountOfZombieSpawned()>20 && this.battlefield.getAllZombies.size()==0 && this.battlefield.getCountOfZombieSpawned()<70 ) {
			//this.difficulty=MediumSetting();//
			//TODO Afficher niveau 2
			if (tickCount % this.difficulty.getBasicZombieApparitionFrequency() == 0) {
				this.battlefield.spawnBasicZombie(BasicZombie.class);
			}
			if(this.battlefield.getCountOfZombieSpawned()%5==0) {
				this.battlefield.spawnBasicZombie(BasicZombie.class/*, Future Classe*/);
			}
			if(this.battlefield.getCountOfZombieSpawned()%9==0) {
				this.battlefield.spawnBasicZombie(BasicZombie.class /*,Future Classe*/);
			}
		}
		
		
	}	

	// dessine les entites du jeu
	public void dessine() {
				
		// Affiche le background
		StdDraw.picture(0.5, 0.5, "../assets/images/background.png");
		
		// Affiche les entites du champ de bataille
		this.battlefield.getAllEntities().stream().forEach((Entite e)->{
			e.dessine();
		});
				
		// affiche les entites
		for (Entite entite : entites)
			entite.dessine();
		
		// affiche les textes
		for (Text text : texts)
			text.dessine();
				
	}

	public static boolean gameWon() {
		return gameWon;
	}
	
	public static boolean gameLost() {
		return gameLost;
	}
	

}
