package ac.fusion.framework.data.impl;

import ac.fusion.framework.util.annotation.Desync;

/**
 * Represents a data handler of the player movement states.
 */
public interface MovementHandler {
    /**
     * Determine if the player is currently on ground clientside.
     * @return client ground state
     */
    @Desync
    boolean isClientGround();

    /**
     * Determine if the player was previously on ground clientside.
     * @return client ground state
     */
    @Desync
    boolean isLastClientGround();

    /**
     * Determine if the player is currently on ground using collisions.
     * @return calculated serverside ground state
     */
    boolean isCollisionGround();

    /**
     * Determine if the player was previously on ground using previous collisions.
     * @return previous calculated serverside ground state
     */
    boolean isLastCollisionGround();

    /**
     * Determine if the player is currently on ground by checking their Y axis position.
     * @return calculated serverside ground state
     */
    boolean isPositionGround();

    /**
     * Determine if the player was previously on ground by checking their previous Y axis position.
     * @return previous calculated serverside ground state
     */
    boolean isLastPositionGround();
}
