package ac.fusion.framework.data.impl.entity;

import org.bukkit.entity.Entity;

/**
 * Represents a data handler of the tracked entity positions the player can see on their screen.
 */
public interface EntityTracker {
    /**
     * Get a tracked entity from bukkit entity instance.
     * @param entity target bukkit entity
     * @return entity tracker or null if it is not tracked
     */
    TrackedEntity getTrackedEntity(Entity entity);

    /**
     * Get a tracked entity from its entity id.
     * @param entityId target entity id
     * @return entity tracker or null if it is not tracked
     */
    TrackedEntity getTrackedEntity(int entityId);
}
