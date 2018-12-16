package game;

/**
 * Permet de paramétrer les constantes du jeu, par exemple étendre cette classe pour construire différents
 * niveaux de difficulté.
 */
public abstract class Settings {

    /**
     * Sun apparition frequency in ticks^(-1)
     */
    public abstract int getSunApparitionFrequency(int amountSunflower);

    /**
     * Default sun points amount
     */
    public abstract int getDefaultSuns();
    
    /**
     * Default sun disparition time
     */
    public abstract int getDefaultSunDisparitionTime();

    /**
     * Zombie apparition frequency in ticks^(-1)
     * @return
     */
    public abstract int getBasicZombieApparitionFrequency();
    
    /**
     * contain the 
     */
    public abstract int getTankZombieApparitionFrequency();

    public abstract int getZombieApparitionFrequency();
    // TODO
    
 }