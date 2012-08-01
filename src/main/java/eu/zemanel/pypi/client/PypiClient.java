package eu.zemanel.pypi.client;

import java.util.Date;
import java.util.Map;

/**
 *
 */
public interface PypiClient {

    public String[] listPackages() throws PypiXMLRPCException;

    public String[] packageReleases(String packageName) throws PypiXMLRPCException;

    public String[] packageReleases(String packageName, boolean showHidden) throws PypiXMLRPCException;

    public UserRole[] packageRoles(String packageName) throws PypiXMLRPCException;

    public UserPackage[] userPackages(String username) throws PypiXMLRPCException;

    public PackageReleaseDownload[] releaseDownloads(String packageName, String version) throws PypiXMLRPCException;

    public PackageReleaseUrl[] releaseUrls(String packageName, String version) throws PypiXMLRPCException;

    public PackageReleaseData releaseData(String packageName, String version) throws PypiXMLRPCException;

    public PackageRelease[] browse(String[] classifiers) throws PypiXMLRPCException;

    public PackageRelease[] updatedReleases(Date since) throws PypiXMLRPCException;

    public String[] changedPackages(Date since) throws PypiXMLRPCException;

    public PackageSearchResult[] search(Map<SearchParam, String[]> params, SearchOperator searchOperator)
            throws PypiXMLRPCException;

    public PackageSearchResult[] search(Map<SearchParam, String[]> params) throws PypiXMLRPCException;
}
