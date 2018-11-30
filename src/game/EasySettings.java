package game;

public class EasySettings extends Settings {

    private final int SUN_APPARITION_FREQUENCY = 0;
    private final int DEFAULT_SUNS = 50;
    private final int DEFAULT_BASIC_ZOMBIE_APPARITION_FREQUENCY = 150;
    private final int DEFAULT_TANK_ZOMBIE_APPARITION_FREQUENCY = 450;
    private final int DEFAULT_ZOMBIE_APPARITION_FREQUENCY = 180;


    /**
     * Sun apparition frequency in ticks^(-1)
     */
    public int getSunApparitionFrequency(int amountSunflower) {
        return SUN_APPARITION_FREQUENCY + amountSunflower*24;
    }

    /**
     * Default sun points amount
     */
    public int getDefaultSuns() {
        return DEFAULT_SUNS;
    }

    /**
     * Basic zombie apparition frequency in ticks^(-1)
     * @return
     */
    public int getBasicZombieApparitionFrequency() {
        return DEFAULT_BASIC_ZOMBIE_APPARITION_FREQUENCY;
    }
    
    /**
     * Tank zombie apparition frequency in ticks^(-1)
     * @return
     */
    public int getTankZombieApparitionFrequency() {
        return DEFAULT_TANK_ZOMBIE_APPARITION_FREQUENCY;
    };

    /**
     * other zombie apparition frequency in ticks^(-1)
     * @return
     */
    public int getZombieApparitionFrequency(){
        return DEFAULT_ZOMBIE_APPARITION_FREQUENCY;
    }
}