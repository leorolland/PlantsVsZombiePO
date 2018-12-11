package game;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import entities.Plant;
import entities.Pois;
import entities.Zombie;
import entities.ZombieState;

/**
 * Décrit l'ensemble des entités présentes sur un champ de bataille.
 * @author 18002209
 *
 */
public class Battlefield {

	/**
	 * Range d'attaque par défaut des zombies
	 */
	private final double DEFAULT_ZOMBIE_RANGE = 0.02;
	
	/**
	 * Décrit un cadrillage de 5 x 9 dans lequel des plantes peuvent être situées
	 */
	private Plant[][] plantField;
	
	/*
	 * Décrit pour chaque ligne les zombies qui s'y trouvent
	 * Ex : zombieField.get(1) renvoie un ArrayList des zombies présents sur la ligne du haut
	 */
	private List<ArrayList<Zombie>> zombieField;
	
	/**
	 * Décrit pour chaque ligne les pois qui s'y trouvent sous le même principe que zombieField
	 */
	private List<ArrayList<Pois>> poisField; 
	
	/**
	 * Constructeur de champ de bataille
	 */
	public Battlefield() {
		// Instanciation du champ de plantes
		this.plantField = new Plant[5][9];
		
		// Instanciation du champ de zombies
		this.zombieField = new ArrayList<ArrayList<Zombie>>();
		for (int i = 0; i < 5; i++) {
			// On déclare 5 Listes vides pour les 5 lignes
			zombieField.add(new ArrayList<Zombie>());
		}
		
		this.poisField = new ArrayList<ArrayList<Pois>>();
			for(int i =0; i<5; i++) {
				poisField.add(new ArrayList<Pois>());
			}
	}
	
	/**
	 * Renvoie toutes les entités mémorisées dans cette instance de champ de bataille
	 * @return
	 */
	public ArrayList<Entite> getAllEntities() {
		ArrayList<Entite> entites = new ArrayList<Entite>();
		// On ajoute toutes les plantes
		for (Plant[] plantRow : plantField)
			for (Plant plant : plantRow)
				if (plant != null)
					entites.add(plant);
		// On ajoute les zombies
		zombieField.stream().forEach((ArrayList<Zombie> a)->{
			entites.addAll(a);
		});
		return entites;
	}
	
	public void spawnBasicZombie(Class<?> zombieClass) {
		// On génère un nombre entre 1 et 5 pour la ligne
		int row = ThreadLocalRandom.current().nextInt(1, 5 + 1);
		
		// On va créer un zombie à partir de la classe fournie
		Zombie zombie;
		try {
			// Instanciation de la plante
			zombie = (Zombie) zombieClass.getConstructors()[0].newInstance(row);
        } catch (IllegalArgumentException e) {
        	System.out.println("Constructeur mal renseigné");
        	return;
		} catch (ClassCastException cce) {
        	// Si la classe fournie n'est pas castable en Plant c'est que ce n'est pas une classe qui hérite de Plante
        	System.out.println("La classe que vous avez fournie n'hérite pas de la classe Plante");
        	return;
        } catch (Exception e) {
        	e.printStackTrace();
        	return;
        }
		
		// On redéfinit les coordonnées du zombie aux coordonnées voulues;
		this.zombieField.get(row-1).add(zombie);
	}
	
	/**
	 * Fait apparaître une plante dans une case indiquée
	 * @param plantClass La classe de la plante à faire spawn
	 * @param ligne La colonne de la plante [1 ; 5]
	 * @param colonne La ligne de la plante [1 ; 5]
	 */
	public void spawnPlant(Class<?> plantClass, int ligne, int colonne) {
		if (colonne > 9 || ligne > 5 || colonne < 0 || ligne < 0) {			
			System.out.println("Coordonnées de spawn de la plante incorrects");
			return;
		}
		// On va créer une plante à partir de la classe fournie
		Plant plant;
		try {
			// Instanciation de la plante
			plant = (Plant) plantClass.getConstructors()[0].newInstance(ligne, colonne);
        } catch (IllegalArgumentException e) {
        	System.out.println("Constructeur mal renseigné");
        	return;
		} catch (ClassCastException cce) {
        	// Si la classe fournie n'est pas castable en Plant c'est que ce n'est pas une classe qui hérite de Plante
        	System.out.println("La classe que vous avez fournie n'hérite pas de la classe Plante");
        	return;
        } catch (Exception e) {
        	e.printStackTrace();
        	return;
        }
		// On affecte l'objet à une case du tableau.
		this.plantField[ligne-1][colonne-1] = plant;
	}
	private void spawnPois(int ligne, int colonne) {
		Pois a = new Pois(ligne, colonne);
		
	}
	/**
	 * Permet de récupérer la plante la plus à droite d'une ligne
	 * @param ligne, entier entre 1 et 5 inclus.
	 * @return la plante la plus
	 */
	public Plant rightestPlantInALine(int ligne) {
		int i=plantField[ligne-1].length - 1;
		while(plantField[ligne-1][i] == null && i>0) {
			i--;
		}
		return plantField[ligne-1][i];
	}
	
	public Entite leftestZombieInALine(int ligne) {
		ArrayList<Zombie> a = zombieField.get(ligne);
		return a.get(0);
	}
	
	/**
	 * Exécuté à chaque step du jeu, permet notamment de voir quand un zombie est 
	 * arrivé à la fin ou doit commencer à manger une plante
	 */
	public void step() {

		// Pour chaque ligne on vérifie pour chaque zombie s'il doit manger une plante
		// i modélise la ligne [1 - 5]
		for (int i = 1; i < plantField.length + 1; i++) {

			// On fixe la valeur de i dans une constante afin de satisfaire les éxigeances de variables "final or effectively final"
			// plus d'infos : http://ilkinulas.github.io/programming/java/2016/03/27/effectively-final-java.html
			final int counter = i;

			// Pour chaque zombie présent sur cette ligne
			this.zombieField.get(i-1).stream().forEach((Zombie z) -> {

				// On regarde s'il est a proximité d'une plante
				for (Plant plant : plantField[counter-1]) {
					if (plant != null) {
						// Si la plante est à proximité du zombie, alors le zombie l'attaque
						if (Math.abs(plant.getX() - z.getX()) < DEFAULT_ZOMBIE_RANGE) {
							z.setState(ZombieState.ATTAQUE);
						}
					}
				}
				
			});
		}
		// Exécution du step de toutes les entités
		this.getAllEntities().stream().forEach((Entite e)->{
			e.step();
		});
	}
	
}
