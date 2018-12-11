package ihm;

import game.Battlefield;
import game.StdDraw;
import game.Timer;
import ihm.Reserve;
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
     * Instancie une boutique
     * @param bf
     * @param res
     */
    public Boutique(Battlefield bf, Reserve res) {
        this.battlefield = bf;
        this.reserve = res;   
        this.sunflowerTimer = new Timer(0);
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

    public void processKeyboardInput(char key) {
        switch (key) {
            // Achat d'un Sunflower
            case 't':
                // Si le temps de réachat est écoulé et que le paiement de la plante est un succès
                if (this.sunflowerTimer.hasFinished() && this.reserve.pay(Sunflower.DEFAULT_COST)) {
                    // On fait apparaître la plante
                    this.battlefield.spawnPlant(Sunflower.class, determineLineNumber(), determineColumnNumber());
                    // Remise à zéro du timer
                    this.sunflowerTimer = new Timer(1000);
                }
                break;
             // Achat d'un poisplant
            case 'p':
                // Si le temps de réachat est écoulé et que le paiement de la plante est un succès
                if (this.sunflowerTimer.hasFinished() && this.reserve.pay(Sunflower.DEFAULT_COST)) {
                    // On fait apparaître la plante
                    this.battlefield.spawnPlant(Sunflower.class, determineLineNumber(), determineColumnNumber());
                    // Remise à zéro du timer
                    this.sunflowerTimer = new Timer(1000);
                }
                break;
            default:
                System.out.println("Touche non prise en charge");
                break;
            }
    }

}