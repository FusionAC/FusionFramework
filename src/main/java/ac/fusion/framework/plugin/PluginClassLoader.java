package ac.fusion.framework.plugin;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Represents a custom class loader that loads the given plugin jar file at runtime.
 */
public class PluginClassLoader extends URLClassLoader {
    /**
     * The main class of the plugin.
     */
    private final String main;

    /**
     * The loaded plugin instance.
     */
    private FusionPlugin plugin;

    /**
     * Initialize plugin class loader.
     * @param urls plugin file path
     * @param parent default class loader
     * @param main plugin main class
     */
    public PluginClassLoader(URL[] urls, ClassLoader parent, String main) {
        super(urls, parent);
        this.main = main;
    }

    /**
     * Load a framework plugin dynamically.
     * @return loaded plugin instance
     * @throws Exception error whilst loading
     */
    public FusionPlugin loadPlugin() throws Exception {
        // fetch the main class of the plugin
        Class<?> clazz = Class.forName(main, true, this);
        // check if the plugin main extends FusionPlugin
        if (!FusionPlugin.class.isAssignableFrom(clazz))
            throw new IllegalStateException(clazz + " does not extend " + FusionPlugin.class);
        // create a plugin instance
        return plugin = (FusionPlugin) clazz.newInstance();
    }

    /**
     * The loaded plugin instance.
     */
    public FusionPlugin getPlugin() {
        return plugin;
    }
}
