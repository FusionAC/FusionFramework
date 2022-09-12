package ac.fusion.framework.plugin;

import java.io.File;

/**
 * Represents a framework-level implementation of {@link Plugin}.
 * This class is extended by the framework plugin implementations.
 */
public abstract class FusionPlugin implements Plugin {
    /**
     * The data folder of the plugin.
     */
    private File dataFolder;

    /**
     * The description of the plugin.
     */
    private PluginDescription description;

    /**
     * The framework plugin manager.
     */
    private PluginManager pluginManager;

    /**
     * Determines if the plugin is enabled.
     */
    private boolean enabled;

    /**
     * Initialize fusion plugin.
     * To be invoked by the plugin class loader.
     */
    public FusionPlugin() {
        // get the class loader of the plugin
        ClassLoader loader = getClass().getClassLoader();
        // check if someone was trying to instantiate the plugin manually
        // if (!(loader instanceof PluginClassLoader))
        //     throw new IllegalStateException("Fusion plugin cannot be instantiated manually.");
    }

    /**
     * Get the data folder of the plugin.
     * @return plugin root folder
     */
    @Override
    public File getDataFolder() {
        return dataFolder;
    }

    /**
     * Get the description of the plugin.
     * @return plugin information
     */
    @Override
    public PluginDescription getDescription() {
        return description;
    }

    /**
     * Get the plugin manager of the plugin.
     * @return framework plugin manager
     */
    @Override
    public PluginManager getPluginManager() {
        return pluginManager;
    }

    /**
     * Determine if the plugin is currently enabled.
     * @return true if it the plugin is enabled
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Update the plugin's enabled state.
     * @param enabled new plugin state
     */
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled)
            onEnable();
        else
            onDisable();
    }

    /**
     * Get the name of the plugin.
     * @return plugin name
     */
    @Override
    public String getName() {
        return description.getName();
    }

    /**
     * Post initialize the plugin.
     * @param dataFolder plugin data folder
     * @param description plugin information
     * @param pluginManager framework plugin manager
     */
    final void init(File dataFolder, PluginDescription description, PluginManager pluginManager) {
        // check if the plugin is already initialized
        if (this.description != null)
            throw new IllegalStateException("Plugin is already initialized");
        this.dataFolder = dataFolder;
        this.description = description;
        this.pluginManager = pluginManager;
    }

    /**
     * Get the instance of the given plugin.
     * @param clazz plugin class
     * @param <T> plugin class type
     * @return loaded plugin instance
     */
    public static <T extends FusionPlugin> T getPlugin(Class<T> clazz) {
        // check if class is not a main class
        if (!FusionPlugin.class.isAssignableFrom(clazz))
            throw new IllegalArgumentException(clazz + " doest not extend " + FusionPlugin.class);
        // check if class was not instantiated by the framework
        ClassLoader loader = clazz.getClassLoader();
        if (!(loader instanceof PluginClassLoader))
            throw new IllegalArgumentException(clazz + " is not initialized by " + FusionPlugin.class);
        // check if the plugin is null
        FusionPlugin plugin = ((PluginClassLoader) loader).getPlugin();
        if (plugin == null)
            throw new IllegalStateException("Cannot get plugin for " + clazz + " from a static initializer");
        // get the plugin
        return clazz.cast(plugin);
    }
}
