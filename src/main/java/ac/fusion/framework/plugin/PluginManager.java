package ac.fusion.framework.plugin;

import org.bukkit.plugin.InvalidPluginException;

import java.io.File;

/**
 * Represents a plugin manager that loads and saves framework plugins.
 * Each plugin that is placed in the <code>%FUSION_DIR%/extensions</code> will
 * automatically load on Fusion's startup.
 */
public interface PluginManager {
    /**
     * Load an extension plugin from a jar file.
     * @param file plugin jar path
     * @return loaded framework plugin
     */
    Plugin loadPlugin(File file) throws InvalidPluginException;

    /**
     * Load all the plugins from the given folder.
     * @param folder folder to load plugins from
     */
    void loadPlugins(File folder);

    /**
     * Unload a framework plugin.
     * @param plugin plugin to unload
     * @throws Exception error whilst unloading
     */
    void unloadPlugin(Plugin plugin) throws InvalidPluginException;

    /**
     * Get a loaded plugin from its name.
     * @param name plugin name
     * @return loaded plugin or null if it is not loaded
     */
    Plugin getPlugin(String name);

    /**
     * Load the description of the plugin from its jar file.
     * @param file plugin jar file
     * @return loaded plugin description
     * @throws InvalidPluginException invalid jar or description
     */
    PluginDescription getDescription(File file) throws InvalidPluginException;
}
