package ac.fusion.framework.check;

public class Preconditions {
    public static void notNull(Object test, String message) {
        if (test == null)
            throw new IllegalStateException(message);
    }
}
