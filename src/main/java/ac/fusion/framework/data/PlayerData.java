package ac.fusion.framework.data;

import ac.fusion.framework.data.impl.MovementHandler;
import ac.fusion.framework.data.impl.abilities.AbilitiesHandler;
import ac.fusion.framework.data.impl.entity.EntityTracker;
import ac.fusion.framework.util.player.ProtocolVersion;
import org.bukkit.entity.Player;

/**
 * Represents a holder of all the player-related data that fusion stores during gameplay.
 */
public interface PlayerData {
    /**
     * Get the bukkit player of the data.
     * @return data holder player
     */
    Player getPlayer();

    /**
     * Get the current tick of the player.
     * @return clientside transaction tick
     */
    long currentTick();

    /**
     * Queue a task that will be executed when the player confirms the last sent PRE transaction.
     * @param task pre transaction confirm task
     */
    void queuePreTask(Runnable task);

    /**
     * Queue a task that will be executed when the player confirms the last sent POST transaction.
     * @param task post transaction confirm task
     */
    void queuePostTask(Runnable task);

    /**
     * Get the protocol version of the player.
     * @return client game version
     */
    ProtocolVersion getVersion();

    /**
     * Get the player movement state data handler.
     */
    MovementHandler getMovementHandler();

    /**
     * Get the player abilities data handler.
     */
    AbilitiesHandler getAbilitiesHandler();

    /**
     * Get the entity position tracker.
     */
    EntityTracker getEntityTracker();
}
