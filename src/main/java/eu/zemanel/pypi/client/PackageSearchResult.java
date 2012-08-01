package eu.zemanel.pypi.client;

/**
 * Search result
 */
public class PackageSearchResult {

    private int pypiOrdering;
    private String name;
    private String summary;
    private String version;

    public PackageSearchResult() {
    }

    public int getPypiOrdering() {
        return pypiOrdering;
    }

    public void setPypiOrdering(int pypiOrdering) {
        this.pypiOrdering = pypiOrdering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
