package ac.fusion.framework.data.impl.entity;

import ac.fusion.framework.util.annotation.PostConfirmed;
import org.bukkit.util.Vector;

/**
 * Represents a position tracker for a specified minecraft entity.
 */
public interface TrackedEntity {
    /**
     * Get the X position of the tracked entity.
     * @return clientside X position
     */
    @PostConfirmed
    double getPosX();

    /**
     * Get the Y position of the tracked entity.
     * @return clientside XY position
     */
    @PostConfirmed
    double getPosY();

    /**
     * Get the Z position of the tracked entity.
     * @return clientside Z position
     */
    @PostConfirmed
    double getPosZ();

    /**
     * Get the XYZ position of the tracked entity.
     * @return clientside XYZ position
     */
    @PostConfirmed
    Vector getPosition();
}
