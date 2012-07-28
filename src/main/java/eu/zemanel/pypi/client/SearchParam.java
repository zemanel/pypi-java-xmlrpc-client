package eu.zemanel.pypi.client;

/**
 * "search" method call "spec" parameter
 */
public enum SearchParam {

    NAME("name"),
    VERSION("version"),
    AUTHOR("author"),
    MAINTAINER("maintainer"),
    HOME_PAGE("home_page"),
    SUMMARY("summary"),
    KEYWORDS("keywords"),
    DOWNLOAD_URL("download_url");

    private final String value;

    SearchParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
