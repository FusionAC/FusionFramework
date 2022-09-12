package ac.fusion.framework;

import ac.fusion.framework.util.annotation.FusionInit;

/**
 * Represents a static holder of the framework implementation.
 */
public class FrameworkProvider {
    /**
     * The implementation of the framework.
     */
    @FusionInit
    private static FusionFramework framework;

    /**
     * Get the implementation of the framework.
     * @return internal framework implementation
     */
    public static FusionFramework getFramework() {
        return framework;
    }
}
