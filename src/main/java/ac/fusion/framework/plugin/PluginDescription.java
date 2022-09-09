package ac.fusion.framework.plugin;

import java.util.List;

/**
 * Represents a plugin information holder. The plugin description is loaded from each
 * plugin's jar, from the <code>plugin.yml</code> file. If the plugin description is
 * corrupted, the plugin will not load.
 */
public interface PluginDescription {
    /**
     * Get the name of the plugin.
     * @return plugin actual name
     */
    String getName();

    /**
     * Get the main class of the plugin.
     * @return main class path
     */
    String getMain();

    /**
     * Get the build version of the plugin.
     * @return current build version
     */
    String getVersion();

    /**
     * Get the short description of the plugin.
     * @return general plugin description
     */
    String getDescription();

    /**
     * Get the website of the plugin.
     * @return plugin author website
     */
    String getWebsite();

    /**
     * Get the list of the contributors of the plugin.
     * @return contributor list
     */
    List<String> getAuthors();

    /**
     * Get the list of the required plugin dependencies.
     * @return framework plugin dependencies
     */
    List<String> getDependencies();

    /**
     * Get the list of the supported plugins that may be used by this plugin.
     * @return supported framework plugins
     */
    List<String> getSoftDependencies();

    /**
     * Get the list of the plugins that this plugin should be loaded before.
     * @return plugins that are loaded after this
     */
    List<String> getLoadBefore();

    /**
     * Get the list of the plugins that this plugin should be loaded after.
     * @return plugins that are loaded before this
     */
    List<String> getLoadAfter();
}
