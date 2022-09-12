package ac.fusion.framework.util.annotation;

import ac.fusion.framework.util.player.ProtocolVersion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents an annotation that indicates which game versions the given function supports.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Supported {
    /**
     * The minimum required version.
     * @return version >= above
     */
    ProtocolVersion above() default ProtocolVersion.UNKNOWN;

    /**
     * The maximum required version.
     * @return version <= below
     */
    ProtocolVersion below() default ProtocolVersion.UNKNOWN;
}
