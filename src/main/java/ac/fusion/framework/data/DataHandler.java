package ac.fusion.framework.data;

import ac.fusion.framework.event.Event;
import org.bukkit.entity.Player;

/**
 * Represents an event data handler that runs pre and post calculations on the events.
 */
public interface DataHandler {
    /**
     * Get the target player of the data handler.
     * @return bukkit player instance
     */
    Player getPlayer();

    /**
     * Get the data of the target holder.
     * @return fusion player data
     */
    PlayerData getData();

    /**
     * Pre process the check before it is handled by checks.
     * @param event event to pre process
     */
    default void preProcess(Event event) {
    }

    /**
     * Post process the check after it is handled by checks.
     * @param event event to post process
     */
    default void postProcess(Event event) {
    }
}
