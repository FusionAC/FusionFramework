package ac.fusion.framework.data.impl.abilities;

/**
 * Represents a wrapper for a player abilities update.
 */
public interface Abilities {
    /**
     * Determines if the player has hod mode enabled.
     * @return true if the god mode is enabled
     */
    boolean isGodMode();

    /**
     * Determines if the player has toggled their flight state.
     * @return true if the player is flying
     */
    boolean isFlying();

    /**
     * Determine if the player is allowed to toggle flight.
     * @return true if the player is allowed to fly
     */
    boolean isFlightAllowed();

    /**
     * Determine if the player is in creative mode.
     * @return true if the player is in creative
     */
    boolean isCreativeMode();

    /**
     * Get the ground walk speed of the player.
     * @return non-flying on ground speed
     */
    float getWalkSpeed();

    /**
     * Get the air fly speed of the player.
     * @return flying air speed
     */
    float getFlySpeed();
}
