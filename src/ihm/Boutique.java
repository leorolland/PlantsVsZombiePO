package ihm;

import game.Battlefield;
import game.StdDraw;
import game.Timer;
import ihm.Reserve;
import entities.MitraillettePlant;
import entities.PoisPlant;
import entities.ShieldPlant;
import entities.Sunflower;

/**
 * Boutique
 * Cette classe devra gérer les clics de la souris dans la boutique et autres
 * actions du clavier, déterminer quelle plante est choisir pour achat
 * retirer l'argent dans la réserve et enfin faire apparaitre
 * la plante choisie.
 */
public class Boutique {

    /**
     * Stoque l'instance du champ de bataille actuel
     */
    private Battlefield battlefield;

    /**
     * Stoque l'instance de la réserve actuelle
     */
    private Reserve reserve;

    /**
     * Timer de réachat d'un Sunflower
     */
    private Timer sunflowerTimer;
    
    /**
     * Timer de réachat d'un poisPlant
     */
    private Timer poisPlantTimer;
    
    /**
     * Timer de réachat d'un shieldPlant
     */
    private Timer shieldPlantTimer;
    
    /**
     * Timer de réachat d'une mitraillettePlant
     */
    private Timer mitraillettePlantTimer;

    /**
     * Instancie une boutique
     * @param bf
     * @param res
     */
    public Boutique(Battlefield bf, Reserve res) {
        this.battlefield = bf;
        this.reserve = res;   
        this.sunflowerTimer = new Timer(0);
        this.poisPlantTimer = new Timer(0);
        this.shieldPlantTimer = new Timer(0);
        this.mitraillettePlantTimer = new Timer(0);
    }

    /**
     * Renvoie la coordonnée X de la case cliquée du champ de bataille
     * en fonction de la coordonnée X de la souris.
     * @param mousePosition La position de la souris
     * @return le numéro de la ligne [1 - 5]
     */
    public static int determineLineNumber() {
        double mouseYPosition = StdDraw.mouseY();
        mouseYPosition -= 0.1;
        int line = 1 + (int) (mouseYPosition / 0.122);
        if (line > 5)
            return 5;
        else
            return line;
    }

    /**
     * Renvoie la coordonnée X de la case cliquée du champ de bataille
     * en fonction de la coordonnée X de la souris.
     * @param mousePosition La position de la souris
     * @return le numéro de la ligne [1 - 5]
     */
    public static int determineColumnNumber() {
        double mouseXPosition = StdDraw.mouseX();
        mouseXPosition -= 0.067;
        int line = 1 + (int) (mouseXPosition / 0.10);
        if (line > 9)
            return 9;
        else
            return line;
    }
    
    
    /**
     * Renvoie la coordonnée X de la case en fonction d'une coordonnée verticale brute
     * @param mousePosition La coordonnée brute verticale
     * @return le numéro de la ligne [1 - 5]
     */
    public static int determineLineNumber(double mouseYPosition) {
        mouseYPosition -= 0.1;
        int line = 1 + (int) (mouseYPosition / 0.122);
        if (line > 5)
            return 5;
        else
            return line;
    }

    public void processKeyboardInput(char key) {
        switch (key) {
            // Achat d'un Sunflower
            case 't':
                // Si le temps de réachat est écoulé et que le paiement de la plante est un succès
                if (this.sunflowerTimer.hasFinished() && this.reserve.pay(Sunflower.DEFAULT_COST)) {
                    // On fait apparaître la plante
                    this.battlefield.spawnPlant(Sunflower.class, determineLineNumber(), determineColumnNumber());
                    // Remise à zéro du timer
                    this.sunflowerTimer = new Timer(Sunflower.DEFAULT_TIME_BEFORE_REBUYING);
                }
                break;
            // Achat d'un poisplant
            case 'p':
                // Si le temps de réachat est écoulé et que le paiement de la plante est un succès
                if (this.poisPlantTimer.hasFinished() && this.reserve.pay(PoisPlant.DEFAULT_COST)) {
                    // On fait apparaître la plante
                    this.battlefield.spawnPlant(PoisPlant.class, determineLineNumber(), determineColumnNumber());
                    // Remise à zéro du timer
                    this.poisPlantTimer = new Timer(PoisPlant.DEFAULT_TIME_BEFORE_REBUYING);
                }
                break;
            // Achat d'un Shieldplant
            case 's':
                // Si le temps de réachat est écoulé et que le paiement de la plante est un succès
                if (this.shieldPlantTimer.hasFinished() && this.reserve.pay(ShieldPlant.DEFAULT_COST)) {
                    // On fait apparaître la plante
                    this.battlefield.spawnPlant(ShieldPlant.class, determineLineNumber(), determineColumnNumber());
                    // Remise à zéro du timer
                    this.shieldPlantTimer = new Timer(ShieldPlant.DEFAULT_TIME_BEFORE_REBUYING);
                }
                break;
            // Achat d'un MitraillettePlant
            case 'm':
                // Si le temps de réachat est écoulé et que le paiement de la plante est un succès
                if (this.mitraillettePlantTimer.hasFinished() && this.reserve.pay(MitraillettePlant.DEFAULT_COST)) {
                    // On fait apparaître la plante
                    this.battlefield.spawnPlant(MitraillettePlant.class, determineLineNumber(), determineColumnNumber());
                    // Remise à zéro du timer
                    this.mitraillettePlantTimer = new Timer(MitraillettePlant.DEFAULT_TIME_BEFORE_REBUYING);
                }
                break;
            default:
                System.out.println("Touche non prise en charge");
                break;
            }
    }

}