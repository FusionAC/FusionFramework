package ac.fusion.framework;

/**
 * Represents a static holder of the framework implementation.
 */
public class FrameworkProvider {
    /**
     * The implementation of the framework.
     */
    private static FusionFramework framework;

    /**
     * Get the implementation of the framework.
     * @return internal framework implementation
     */
    public static FusionFramework getFramework() {
        return framework;
    }

    /**
     * Set the framework implementation. This is automatically done by Fusion.
     * @param framework internal framework implementation
     */
    public static void setFramework(FusionFramework framework) {
        if (FrameworkProvider.framework != null && framework != null)
            throw new IllegalArgumentException("Fusion framework is already initialized");
        FrameworkProvider.framework = framework;
    }
}
