package eu.zemanel.pypi.client;

/**
 *
 */
public class PackageReleaseDownload {

    private String filename;
    private int downloadCount;

    /**
     *
     */
    public PackageReleaseDownload() {
    }

    public PackageReleaseDownload(String filename, int downloadCount) {
        this.filename = filename;
        this.downloadCount = downloadCount;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }
}
