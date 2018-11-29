package game;

/**
 * Permet de paramétrer les constantes du jeu, par exemple étendre cette classe pour construire différents
 * niveaux de difficulté.
 */
public abstract class Settings {

    /**
     * Sun apparition frequency in ticks^(-1)
     */
    public abstract int getSunApparitionFrequency();

    /**
     * Default sun points amount
     */
    public abstract int getDefaultSuns();
    
}