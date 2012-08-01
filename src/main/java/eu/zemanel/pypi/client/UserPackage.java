package eu.zemanel.pypi.client;

/**
 * User package
 */
public class UserPackage {

    private Role role;
    private String packageName;

    /**
     *
     */
    public UserPackage() {
    }

    /**
     *
     * @param role
     * @param packageName
     */
    public UserPackage(Role role, String packageName) {
        this.role = role;
        this.packageName = packageName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
