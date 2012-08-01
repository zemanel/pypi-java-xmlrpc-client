package eu.zemanel.pypi.client;

/**
 * a package role for a user
 */
public enum Role {

    OWNER("Owner"),
    MAINTAINER("Maintaner");

    private String value;

    private Role(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Role getEnum(String value) {
        for (Role re : Role.values()) {
            if (re.getValue().compareTo(value) == 0) {
                return re;
            }
        }
        throw new IllegalArgumentException("Invalid Role value: " + value);
    }
}
