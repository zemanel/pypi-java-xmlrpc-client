package eu.zemanel.pypi.client;

/**
 * Package release
 */
public class PackageRelease {

    private String packageName;
    private String version;

    /**
     *
     */
    public PackageRelease() {
    }
    /**
     *
     * @param packageName
     * @param version
     */
    public PackageRelease(String packageName, String version) {
        this.packageName = packageName;
        this.version = version;
    }
    /**
     *
     * @return
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     *
     * @param packageName
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     *
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
