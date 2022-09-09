package ac.fusion.framework.plugin;

import java.io.File;

/**
 * Represents a Fusion framework extension plugin.
 * A plugin can be added externally as a separate jar in the <code>%FUSION_DIR%/extensions</code> folder.
 * Each plugin can register their own checks, listen to events and analyze player data.
 */
public interface Plugin {
    /**
     * Get the data folder of the plugin.
     * @return plugin root folder
     */
    File getDataFolder();

    /**
     * Get the description of the plugin.
     * @return plugin information
     */
    PluginDescription getDescription();

    /**
     * Get the plugin manager of the plugin.
     * @return framework plugin manager
     */
    PluginManager getPluginManager();

    /**
     * Determine if the plugin is currently enabled.
     * @return true if it the plugin is enabled
     */
    boolean isEnabled();

    /**
     * Update the plugin's enabled state.
     * @param enabled new plugin state
     */
    void setEnabled(boolean enabled);

    /**
     * Get the name of the plugin.
     * @return plugin name
     */
    String getName();

    /**
     * A method that is called when the plugin jar is loaded.
     * To be overridden by the plugin implementation.
     */
    default void onLoad() {
    }

    /**
     * A method that is called when the plugin is enabled and ready to be used.
     * To be overridden by the plugin implementation.
     */
    default void onEnable() {
    }

    /**
     * A method that is called when the plugin is disabled and no longer in use.
     * To be overridden by the plugin implementation.
     */
    default void onDisable() {
    }
}
