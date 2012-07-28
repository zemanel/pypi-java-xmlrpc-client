package eu.zemanel.pypi.client;

/**
 *  "search" method call "spec" operator
 */
public enum SearchOperator {

    AND("and"),
    OR("version");
    private final String value;

    SearchOperator(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
