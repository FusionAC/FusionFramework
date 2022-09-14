package ac.fusion.framework.data.impl.abilities;

import ac.fusion.framework.data.DataHandler;
import ac.fusion.framework.util.annotation.Desync;
import ac.fusion.framework.util.annotation.PostConfirmed;
import ac.fusion.framework.util.annotation.PreConfirmed;
import ac.fusion.framework.util.annotation.Spoofable;

/**
 * Represents a data handler of the player abilities states.
 */
public interface AbilitiesHandler extends DataHandler {
    /**
     * Get the currently active player abilities that were confirmed by the client.
     * @return post confirmed player abilities
     */
    @PostConfirmed
    Abilities getConfirmedAbilities();

    /**
     * Get the pending abilities that might have been active for the player.
     * @return pre confirmed player abilities
     */
    @PreConfirmed
    Abilities getPendingAbilities();

    /**
     * Get the last abilities sent by the server.
     * @return last sent server abilities
     */
    @Desync
    Abilities getServerAbilities();

    /**
     * Get the last abilities sent by the player.
     * @return last sent player abilities
     */
    @Spoofable
    Abilities getClientAbilities();
}
