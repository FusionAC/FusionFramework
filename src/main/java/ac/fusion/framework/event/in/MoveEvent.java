package ac.fusion.framework.event.in;

import ac.fusion.framework.event.Event;
import org.bukkit.Location;

/**
 * Represents a player position, rotation, ticking update event.
 */
public interface MoveEvent extends Event {
    /**
     * Get the previously known location of the player.
     * @return original location
     */
    Location getFrom();

    /**
     * Get the updated location of the player.
     * @return new location
     */
    Location getTo();

    /**
     * Determine if the movement update has positional change.
     * @return packet updated XYZ
     */
    boolean hasPosition();

    /**
     * Determine if the movement update has rotational change.
     * @return packet updated yaw, pitch
     */
    boolean hasLook();

    /**
     * Determine if the player is the on the ground clientside.
     * @return clientside ground state
     */
    boolean clientGround();

    /**
     * Determine if the player is on the ground using collision calculations.
     * @return calculated serverside ground state
     */
    boolean collisionGround();

    /**
     * Determine if the player is on the ground by checking the player's position on the Y axis.
     * @return calculated serverside ground state
     */
    boolean positionGround();

    /**
     * Determine if the player is standing on a ghost block clientside.
     * @return player is on a ghost block
     */
    boolean ghostBlockGround();
}
