package eu.zemanel.pypi.client;

/**
 * Package release data
 */
public class PackageReleaseData {

    private Integer pypiOrdering;
    private String author;
    private String authorEmail;
    private String bugtrackUrl;
    private Integer cheesecakeCodeKwaliteeId;
    private Integer cheesecakeDocumentationId;
    private Integer cheesecakeInstallabilityId;
    private String[] classifiers;
    private String description;
    private String docsUrl;
    private String downloadUrl;
    private String homepage;
    private String keywords;
    private String license;
    private String maintainer;
    private String maintainerEmail;
    private String name;
    private String packageUrl;
    private String requiresPython;
    private String stableVersion;
    private String summary;
    private String version;

    public PackageReleaseData() {
    }

    public Integer getPypiOrdering() {
        return pypiOrdering;
    }

    public void setPypiOrdering(Integer pypiOrdering) {
        this.pypiOrdering = pypiOrdering;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getBugtrackUrl() {
        return bugtrackUrl;
    }

    public void setBugtrackUrl(String bugtrackUrl) {
        this.bugtrackUrl = bugtrackUrl;
    }

    public Integer getCheesecakeCodeKwaliteeId() {
        return cheesecakeCodeKwaliteeId;
    }

    public void setCheesecakeCodeKwaliteeId(Integer cheesecakeCodeKwaliteeId) {
        this.cheesecakeCodeKwaliteeId = cheesecakeCodeKwaliteeId;
    }

    public Integer getCheesecakeDocumentationId() {
        return cheesecakeDocumentationId;
    }

    public void setCheesecakeDocumentationId(Integer cheesecakeDocumentationId) {
        this.cheesecakeDocumentationId = cheesecakeDocumentationId;
    }

    public Integer getCheesecakeInstallabilityId() {
        return cheesecakeInstallabilityId;
    }

    public void setCheesecakeInstallabilityId(Integer cheesecakeInstallabilityId) {
        this.cheesecakeInstallabilityId = cheesecakeInstallabilityId;
    }

    public String[] getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(String[] classifiers) {
        this.classifiers = classifiers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocsUrl() {
        return docsUrl;
    }

    public void setDocsUrl(String docsUrl) {
        this.docsUrl = docsUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getMaintainerEmail() {
        return maintainerEmail;
    }

    public void setMaintainerEmail(String maintainerEmail) {
        this.maintainerEmail = maintainerEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageUrl() {
        return packageUrl;
    }

    public void setPackageUrl(String packageUrl) {
        this.packageUrl = packageUrl;
    }

    public String getRequiresPython() {
        return requiresPython;
    }

    public void setRequiresPython(String requiresPython) {
        this.requiresPython = requiresPython;
    }

    public String getStableVersion() {
        return stableVersion;
    }

    public void setStableVersion(String stableVersion) {
        this.stableVersion = stableVersion;
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
