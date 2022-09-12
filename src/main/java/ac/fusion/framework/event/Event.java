package ac.fusion.framework.event;

import ac.fusion.framework.data.PlayerData;
import org.bukkit.entity.Player;

/**
 * Represents a Fusion event that is called when intercepting a minecraft packet.
 */
public interface Event {
    /**
     * Get the executor of the event.
     * @return target player
     */
    Player getPlayer();

    /**
     * Get the data of the event executor.
     * @return player data
     */
    PlayerData getData();

    /**
     * Determine if the executing event is cancelled.
     * @return true if the event is cancelled
     */
    boolean isCancelled();

    /**
     * Set the executing event cancelled.
     * @param cancelled event is cancelled
     */
    void setCancelled(boolean cancelled);
}
