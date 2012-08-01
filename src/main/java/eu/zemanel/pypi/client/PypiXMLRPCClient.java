package eu.zemanel.pypi.client;

import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Pypi XMLRPC client
 * More information: http://wiki.python.org/moin/PyPiXmlRpc
 */
public class PypiXMLRPCClient implements PypiClient {

    private XMLRPCClient client;

    /**
     * @param url Pypi url, ex.: "http://testpypi.python.org/pypi" or "http://pypi.python.org/pypi"
     * @throws PypiXMLRPCException
     */
    public PypiXMLRPCClient(URL url) throws MalformedURLException {
        this.client = new XMLRPCClient(url, XMLRPCClient.FLAGS_NIL);
    }

    /**
     * Retrieve a list of the package names registered with the package index. Returns a list of name strings.
     *
     * @return List of Python package names
     * @throws PypiXMLRPCException
     */
    @Override
    public String[] listPackages() throws PypiXMLRPCException {
        try {
            Object[] result = (Object[]) client.call("list_packages");
            String[] results = new String[result.length];
            for (int i = 0; i < result.length; i++) {
                results[i] = (String) result[i];
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     * Retrieve a list of the releases registered for the given package_name.
     *
     * @param packageName Python package name
     * @return List of the releases registered for the given package name
     * @throws PypiXMLRPCException
     */
    @Override
    public String[] packageReleases(String packageName) throws PypiXMLRPCException {
        return this.packageReleases(packageName, false);
    }

    /**
     * Retrieve a list of the releases registered for the given package_name.
     *
     * @param packageName Python package name
     * @param showHidden  Returns a list with all version strings if showHidden is True or only the non-hidden ones otherwise.
     * @return List of the releases registered for the given package name
     * @throws PypiXMLRPCException
     */
    @Override
    public String[] packageReleases(String packageName, boolean showHidden) throws PypiXMLRPCException {
        try {
            Object[] result = (Object[]) client.call("package_releases", new Object[]{packageName, showHidden});
            String[] results = new String[result.length];
            for (int i = 0; i < result.length; i++) {
                results[i] = (String) result[i];
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     *
     * @param packageName
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public UserRole[] packageRoles(String packageName) throws PypiXMLRPCException {
        try {
            Object[] result = (Object[]) client.call("package_roles", packageName);
            UserRole[] results = new UserRole[result.length];
            UserRole userRole;
            for (int i = 0; i < result.length; i++) {
                Object[] item = (Object[])result[i];
                userRole = new UserRole();
                userRole.setRole(Role.getEnum((String) item[0]));
                userRole.setUsername((String)item[1]);
                results[i] = userRole;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     *
     * @param username
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public UserPackage[] userPackages(String username) throws PypiXMLRPCException {
        try {
            Object[] result = (Object[]) client.call("user_packages", username);
            UserPackage[] results = new UserPackage[result.length];
            UserPackage userPackage;
            for (int i = 0; i < result.length; i++) {
                Object[] item = (Object[])result[i];
                userPackage = new UserPackage();
                userPackage.setRole(Role.getEnum((String) item[0]));
                userPackage.setPackageName((String)item[1]);
                results[i] = userPackage;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     *
     * @param packageName
     * @param version
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public PackageReleaseDownload[] releaseDownloads(String packageName, String version) throws PypiXMLRPCException {
        try {
            Object[] result = (Object[]) client.call("release_downloads", packageName, version);
            PackageReleaseDownload[] results = new PackageReleaseDownload[result.length];
            PackageReleaseDownload packageReleaseDownload;
            for (int i = 0; i < result.length; i++) {
                Object[] item = (Object[])result[i];
                packageReleaseDownload = new PackageReleaseDownload();
                packageReleaseDownload.setFilename((String)item[0]);
                packageReleaseDownload.setDownloadCount(((Integer)item[1]).intValue());
                results[i] = packageReleaseDownload;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     *
     * @param packageName
     * @param version
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public PackageReleaseUrl[] releaseUrls(String packageName, String version) throws PypiXMLRPCException {
        try {
            Object[] result = (Object[]) client.call("release_urls", packageName, version);
            PackageReleaseUrl[] results = new PackageReleaseUrl[result.length];
            PackageReleaseUrl releaseUrl;
            for (int i = 0; i < result.length; i++) {
                //TODO: complete me
                HashMap<String, Object>item = (HashMap<String, Object>)result[i];
                releaseUrl = new PackageReleaseUrl();
                releaseUrl.setCommentText((String) item.get("comment_text"));
                releaseUrl.setDownloadCount((Integer)item.get("downloads"));
                releaseUrl.setFilename((String)item.get("filename"));
                releaseUrl.setHasSignature(((Boolean)item.get("has_sig")).booleanValue());
                releaseUrl.setMd5Digest((String)item.get("md5_digest"));
                releaseUrl.setPackageType((String)item.get("packagetype"));
                releaseUrl.setPythonVersion((String)item.get("python_version"));
                releaseUrl.setSize((Integer)item.get("size"));
                releaseUrl.setUploadTime((Date)item.get("upload_time"));
                releaseUrl.setUrl((String)item.get("url"));
                results[i] = releaseUrl;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     * Retrieve metadata describing a specific package release.
     *
     * @param packageName Python package name
     * @param version     A valid package version
     * @return Metadata describing a specific package release.
     * @throws PypiXMLRPCException
     *
     */
    public PackageReleaseData releaseData(String packageName, String version) throws PypiXMLRPCException {
        try {
            HashMap result = (HashMap) client.call("release_data", packageName, version);
            PackageReleaseData packageReleaseData = new PackageReleaseData();
            packageReleaseData.setPypiOrdering((Integer)result.get("_pypi_ordering"));
            packageReleaseData.setAuthor((String)result.get("author"));
            packageReleaseData.setAuthorEmail((String)result.get("author_email"));
            packageReleaseData.setBugtrackUrl((String)result.get("bugtrack_url"));
            packageReleaseData.setCheesecakeCodeKwaliteeId((Integer)result.get("cheesecake_code_kwalitee_id"));
            packageReleaseData.setCheesecakeDocumentationId((Integer)result.get("cheesecake_documentation_id"));
            packageReleaseData.setCheesecakeInstallabilityId((Integer)result.get("cheesecake_installability_id"));
            // set classifiers
            Object[] classifiersEntry = (Object[])result.get("classifiers");
            String[] classifiers = new String[classifiersEntry.length];
            for(int i=0; i<classifiersEntry.length; i++) {
                classifiers[i] = (String)classifiersEntry[i];
            }
            packageReleaseData.setClassifiers(classifiers);
            packageReleaseData.setDescription((String)result.get("description"));
            packageReleaseData.setDocsUrl((String)result.get("docs_url"));
            packageReleaseData.setDownloadUrl((String)result.get("download_url"));
            packageReleaseData.setHomepage((String)result.get("home_page"));
            packageReleaseData.setKeywords((String)result.get("keywords"));
            packageReleaseData.setLicense((String)result.get("license"));
            packageReleaseData.setMaintainer((String)result.get("maintainer"));
            packageReleaseData.setMaintainerEmail((String)result.get("maintainer_email"));
            packageReleaseData.setName((String)result.get("name"));
            packageReleaseData.setPackageUrl((String)result.get("package_url"));
            packageReleaseData.setRequiresPython((String)result.get("requires_python"));
            packageReleaseData.setStableVersion((String)result.get("stable_version"));
            packageReleaseData.setSummary((String)result.get("summary"));
            packageReleaseData.setVersion((String)result.get("version"));
            return packageReleaseData;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     *
     * @param classifiers
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public PackageRelease[] browse(String[] classifiers) throws PypiXMLRPCException {
        try {
            Object[] result = (Object[])client.call("browse", new Object[]{classifiers});
            PackageRelease[] results = new PackageRelease[result.length];
            PackageRelease packageRelease;
            for (int i = 0; i < result.length; i++) {
                Object[] item = (Object[])result[i];
                packageRelease = new PackageRelease();
                packageRelease.setPackageName((String) item[0]);
                packageRelease.setVersion((String)item[1]);
                results[i] = packageRelease;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }
    /**
     *
     * @param sinceDate
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public PackageRelease[] updatedReleases(Date sinceDate) throws PypiXMLRPCException {
        try {
            int since = (int)(sinceDate.getTime() * .001); //TODO timestamp/date should be UTC
            Object[] result = (Object[])client.call("updated_releases", since);
            PackageRelease[] results = new PackageRelease[result.length];
            PackageRelease packageRelease;
            for (int i = 0; i < result.length; i++) {
                Object[] item = (Object[])result[i];
                packageRelease = new PackageRelease();
                packageRelease.setPackageName((String) item[0]);
                packageRelease.setVersion((String)item[1]);
                results[i] = packageRelease;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }
    /**
     *
     * @param sinceDate
     * @return
     * @throws PypiXMLRPCException
     */
    @Override
    public String[] changedPackages(Date sinceDate) throws PypiXMLRPCException {
        try {
            int since = (int)(sinceDate.getTime() * .001); //TODO timestamp/date should be UTC
            Object[] result = (Object[])client.call("changed_packages", since);
            String[] results = new String[result.length];
            for (int i = 0; i < result.length; i++) {
                results[i] = (String)result[i];
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     * @param params         Search spec (parameters)
     * @param searchOperator Search operator for different fields, "and" (the default) or "or".
     * @return List of results
     * @throws PypiXMLRPCException
     */
    public PackageSearchResult[] search(Map<SearchParam, String[]> params, SearchOperator searchOperator)
            throws PypiXMLRPCException {
        try {
            // prepare call search parameters (convert search fields from enums to String values)
            Map<String, String[]> paramMap = new HashMap<String, String[]>();
            for (Map.Entry<SearchParam, String[]> param : params.entrySet()) {
                paramMap.put((param.getKey()).getValue(), param.getValue());
            }
            // call remote method
            Object[] result = (Object[]) client.call("search", paramMap, searchOperator.name());
            // convert results to array
            PackageSearchResult[] results = new PackageSearchResult[result.length];
            PackageSearchResult searchResult;
            for (int i = 0; i < result.length; i++) {
                HashMap<String, String> item = (HashMap<String, String>) result[i];
                searchResult = new PackageSearchResult();
                //TODO complete me
                results[i] = searchResult;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     * Search the Pypi index using default operator ("and")
     *
     * @param params Search spec (parameters)
     * @return List of results
     * @throws PypiXMLRPCException
     */
    public PackageSearchResult[] search(Map<SearchParam, String[]> params) throws PypiXMLRPCException {
        return this.search(params, SearchOperator.AND);
    }
}
