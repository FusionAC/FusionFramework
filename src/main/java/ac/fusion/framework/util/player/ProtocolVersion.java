package ac.fusion.framework.util.player;

import ac.fusion.framework.annotation.FusionInit;
import ac.fusion.framework.check.Preconditions;

/**
 * Represents a registry of the minecraft protocol versions.
 */
public enum ProtocolVersion {
    V1_7(4, "1.7", "v1_7_R3"),
    V1_7_10(5, "1.7.10", "v1_7_R4"),
    V1_8(45, "1.8", "v1_8_R1"),
    V1_8_5(46, "1.8.5", "v1_8_R2"),
    V1_8_9(47, "1.8.9", "v1_8_R3"),
    V1_9(107, "1.9", "v1_9_R1"),
    V1_9_1(108, "1.9.1", "v1_9_R1"),
    V1_9_2(109, "1.9.2", "v1_9_R2"),
    V1_9_4(110, "1.9.4", "v1_9_R2"),
    V1_10(210, "1.10", "v1_10_R1"),
    V1_10_2(210, "1.10.2", "v1_10_R1"),
    V1_11(315, "1.11", "v1_11_R1"),
    V1_11_1(316, "1.11.1", "v1_11_R1"),
    V1_12(335, "1.12", "v1_12_R1"),
    V1_12_1(338, "1.12.1", "v1_12_R1"),
    V1_12_2(340, "1.12.2", "v1_12_R1"),
    V1_13(350, "1.13", "v1_13_R1"),
    V1_13_1(351, "1.13,1", "v1_13_R2"),
    V1_13_2(352, "1.13.2", "v1_13_R2"),
    V1_14(477, "1.14", "v1_14_R1"),
    V1_14_1(480, "1.14.1", "v1_14_R1"),
    V1_14_2(485, "1.14.2", "v1_14_R1"),
    V1_14_3(490, "1.14.3", "v1_14_R1"),
    V1_14_4(498, "1.14.4", "v1_14_R1"),
    V1_15(573, "1.15", "v1_15_R1"),
    V1_15_1(575, "1.15.1", "v1_15_R1"),
    V1_15_2(578, "1.15.2", "v1_15_R1"),
    V1_16(735, "1.16", "v1_16_R1"),
    V1_16_1(736, "1.16.1", "v1_16_R1"),
    V1_16_2(751, "1.16.2", "v1_16_R2"),
    V1_16_3(753, "1.16.3", "v1_16_R2"),
    V1_16_4(754, "1.16.4", "v1_16_R3"),
    V1_16_5(754, "1.16.5", "v1_16_R3"),
    V1_17(755, "1.17", "v1_17_R1"),
    V1_17_1(756, "1.17.1", "v1_17_R1"),
    V1_18(757, "1.18", "v1_18_R1"),
    UNKNOWN(-1, "unknown", "UNKNOWN");

    /**
     * The last requested protocol version.
     */
    private static ProtocolVersion cachedGameVersion;

    /**
     * The version of the NMS code.
     */
    @FusionInit
    private static String nmsVersion;

    /**
     * The version number of the protocol version.
     */
    private final int number;

    /**
     * The display name of the protocol version.
     */
    private final String displayName;

    /**
     * The server version of the protocol version.
     */
    private final String serverVersion;

    /**
     * Initialize protocol version.
     * @param number version number
     * @param displayName version name
     * @param serverVersion server version
     */
    ProtocolVersion(int number, String displayName, String serverVersion) {
        this.number = number;
        this.displayName = displayName;
        this.serverVersion = serverVersion;
    }

    /**
     * Get the protocol version of the server.
     */
    public static ProtocolVersion getGameVersion() {
        // get the version from cache
        if (cachedGameVersion != null)
            return cachedGameVersion;
        // make sure the framework is already initialized
        Preconditions.notNull(nmsVersion, "Framework hasn't been initialized yet.");
        // loop through the registered versions
        for (ProtocolVersion version : values()) {
            // check if the version matches the reflection server version
            if (version.serverVersion.equals(nmsVersion))
                return cachedGameVersion = version;
        }
        return UNKNOWN;
    }

    /**
     * Get the protocol version of a version number.
     * @param versionNumber protocol version number
     * @return protocol version
     */
    public static ProtocolVersion getVersion(int versionNumber) {
        // loop through the registered versions
        for (ProtocolVersion version : values()) {
            // check if the version number matches the given one
            if (version.number == versionNumber)
                return version;
        }
        return UNKNOWN;
    }

    /**
     * Compare a protocol version to another.
     * @param version version to compare
     * @param other other version to compare to
     * @return version - other
     */
    public static int compare(ProtocolVersion version, ProtocolVersion other) {
        return version.number - other.number;
    }

    /**
     * Get the version number of the protocol version.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Get the display name of the protocol version.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Get the server version of the protocol version.
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     * Check if this version is a valid protocol version
     * @return <code>true</code> if this is valid
     */
    public boolean isValid() {
        return this != UNKNOWN;
    }

    /**
     * Compare the protocol version to another.
     * @param other version to compare to
     * @return this - other
     */
    public int compare(ProtocolVersion other) {
        return number - other.number;
    }

    /**
     * Determine if the current protocol version is above the other protocol version.
     * @param other other protocol version
     * @return this > other
     */
    public boolean isAbove(ProtocolVersion other) {
        return compare(other) > 0;
    }

    /**
     * Determine if the current protocol version is below the other protocol version.
     * @param other other protocol version
     * @return this < other
     */
    public boolean isBelow(ProtocolVersion other) {
        return compare(other) < 0;
    }

    /**
     * Determine if the current protocol version is above or equals to the other protocol version.
     * @param other other protocol version
     * @return this >= other
     */
    public boolean isAboveOrEquals(ProtocolVersion other) {
        return compare(other) >= 0;
    }

    /**
     * Determine if the current protocol version is below or equals to the other protocol version.
     * @param other other protocol version
     * @return this <= other
     */
    public boolean isBelowOrEquals(ProtocolVersion other) {
        return compare(other) <= 0;
    }

    /**
     * Get the string representation of the protocol version.
     * @return version debug data
     */
    @Override
    public String toString() {
        return "ProtocolVersion{" +
            "number=" + number +
            ", displayName='" + displayName + '\'' +
            ", serverVersion='" + serverVersion + '\'' +
            '}';
    }
}
