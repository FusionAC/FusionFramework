package ac.fusion.framework;

import ac.fusion.framework.plugin.PluginManager;

/**
 * Represents a framework system that can add plugin extensions to Fusions.
 */
public interface FusionFramework {
    /**
     * Get the plugin manager of the framework.
     * @return plugin manager implementation
     */
    PluginManager getPluginManager();
}
