package game;

public class EasySettings extends Settings {

    private final int SUN_APPARITION_FREQUENCY = 30;
    private final int DEFAULT_SUNS = 50;

    /**
     * Sun apparition frequency in ticks^(-1)
     */
    public int getSunApparitionFrequency() {
        return SUN_APPARITION_FREQUENCY;
    }

    /**
     * Default sun points amount
     */
    public int getDefaultSuns() {
        return DEFAULT_SUNS;
    }

}