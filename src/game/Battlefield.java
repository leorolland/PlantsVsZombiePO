package game;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import entities.MitraillettePlant;
import entities.Plant;
import entities.Pois;
import entities.PoisPlant;
import entities.Zombie;
import entities.ZombieState;
import ihm.Boutique;
import ihm.ExplosionParticle;
import ihm.Particle;
import ihm.PlotchParticle;

/**
 * Décrit l'ensemble des entités présentes sur un champ de bataille.
 * @author 18002209
 *
 */
public class Battlefield {

	/**
	 * Range d'attaque par défaut des zombies
	 */
	private final double DEFAULT_ZOMBIE_RANGE = 0.05;
	
	/**
	 * Range avant qu'un pois ne touche un Zombie
	 */
	private final double DEFAULT_POIS_RANGE = 0.02;
	
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
	 * Compte le nombre de zombie qui ont spawned depuis le début.
	 */
	private int  countOfZombieSpawned;
	/**
	 * Liste des particules affichées sur le champ de bataille
	 */
	private List<Particle> particleList;
	
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
			
		this.particleList = new ArrayList<Particle>();
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
		poisField.stream().forEach((ArrayList<Pois> a)->{
			entites.addAll(a);
		});
		entites.addAll(particleList);
		return entites;
	}
	/**
	 * Renvoie tout les zombie mémoriser dans zombieField
	 */
	public ArrayList<Entite> getAllZombies() {
		ArrayList<Entite> Zombie = new ArrayList<Entite>();
		this.zombieField.stream().forEach((ArrayList<Zombie> a)->{
			Zombie.addAll(a);
		});
		return Zombie;
	}
	
	
	public int getCountOfZombieSpawned() {
		return countOfZombieSpawned;
	}


	public void spawnBasicZombie(Class<?> zombieClass) {
		countOfZombieSpawned++;
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
	
	/**
	 * 
	 * @param ligne sur laquelle  nous voulons faire aparraitre notre pois
	 * @param colonne sur laquelle  nous voulons faire aparraitre notre pois
	 * fait apparaitre un pois dans poisField
	 */
	public void spawnPois(double x, double y) {
		Pois a = new Pois(x, y);
		final int ligne = Boutique.determineLineNumber(y);
		System.out.println(ligne);
		this.poisField.get(ligne - 1).add(a);
;	}
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
				int indexPlant = 0;
				// Définit si le zombie aura attaqué une plante ou non durant ce step()
				boolean hasZombieAttackedAPlant = false;
				for (Plant plant : plantField[counter-1]) {
					if (plant != null) {
						// Si la plante est à proximité du zombie, alors le zombie l'attaque s'il est prêt à attaquer
						if (Math.abs(plant.getX() - z.getX()) < DEFAULT_ZOMBIE_RANGE) {
							hasZombieAttackedAPlant = true;
							if (z.isReadyToAttack()) {
								z.attaque(plant);
								if(plant.getHp() <= 0) {
									this.plantField[counter-1][indexPlant] = null;
								}
							}
						}
					}
					indexPlant++;
				}
				// Si le zombie à attaqué une plante, alors on le met dans l'état d'attaque
				if (hasZombieAttackedAPlant)
					z.setState(ZombieState.ATTAQUE);
				// Sinon il retourne en état de marche
				else
					z.setState(ZombieState.MARCHE);
				ArrayList<Pois> poisASupprimer = new ArrayList<Pois>();
				this.poisField.get(counter-1).stream().forEach((Pois p)->{
					if(Math.abs(p.getX() - z.getX()) < DEFAULT_ZOMBIE_RANGE) {
						p.attaque(z);
						this.particleList.add(new PlotchParticle(z.getX()-0.02, z.getY()-0.05));
						if(p.getHp()==0 || p.getX() > 1)
							poisASupprimer.add(p);
					}
				});
				this.poisField.get(counter-1).removeAll(poisASupprimer);
			});
		}
		
		// Itération sur toutes les entités du champ de bataille
		this.getAllEntities().stream().forEach((Entite e)->{
			// Exécution du step de toutes les entités
			e.step();
			// Cas particulier du step du poisplant qui doit être géré ici
			if(e instanceof PoisPlant) {
				PoisPlant pp = ((PoisPlant)e);
				if(pp.isReadyToAttack()) {
					// spawnPois(((int) ( e.getX()/0.10-0.015)) ,((int) (e.getY()/ 0.122-0.06)));
					this.spawnPois(pp.getX()+0.03, pp.getY());					
					pp.setReadyToAttack(false);
				}
			}
			if(e instanceof MitraillettePlant) {
				MitraillettePlant pp = ((MitraillettePlant)e);
				if(pp.isReadyToAttack()) {
					// spawnPois(((int) ( e.getX()/0.10-0.015)) ,((int) (e.getY()/ 0.122-0.06)));
					this.spawnPois(pp.getX()+0.03, pp.getY());					
					pp.setReadyToAttack(false);
				}
			}
			// On supprime les zombies morts de chaque ligne
			if (e instanceof Zombie) {
				Zombie zombie = ((Zombie)e);
				if (zombie.getHp() <= 0) {
					this.particleList.add(new ExplosionParticle(zombie.getX(), zombie.getY()));
					this.zombieField.forEach((ArrayList<Zombie> az)->{
						az.remove(zombie);
					}); 
				}
			}
		});
		
		
		// Suppression des particules qui ont terminé leur affichage
		List<Particle> particleToRemove = new ArrayList<Particle>();
		this.particleList.stream().forEachOrdered((Particle p) -> {
			if (p.hasFinished())
				particleToRemove.add(p);
		});
		particleToRemove.forEach(p->{
			this.particleList.remove(p);
		});

		
	}
	
}
