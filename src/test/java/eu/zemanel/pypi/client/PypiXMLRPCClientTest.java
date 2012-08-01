package eu.zemanel.pypi.client;

import junit.framework.TestCase;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class PypiXMLRPCClientTest extends TestCase {
    private PypiXMLRPCClient client;
    /**
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.client = new PypiXMLRPCClient(new URL("http://testpypi.python.org/pypi"));
    }
    /**
     *
     * @throws Exception
     */
    public void testListPackages() throws Exception {
        String[] result = this.client.listPackages();
        this.assertTrue(result.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testPackageReleases() throws Exception {
        String[] result1 = this.client.packageReleases("spam");
        String[] result2 = this.client.packageReleases("spam", false);
        String[] result3 = this.client.packageReleases("spam", true);
        this.assertTrue(result1.length > 0);
        this.assertTrue(result2.length > 0);
        this.assertTrue(result3.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testPackageRoles() throws Exception {
        UserRole[] result1 = this.client.packageRoles("spam");
        this.assertTrue(result1.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testUserPackages() throws Exception {
        UserPackage[] result1 = this.client.userPackages("cjerdonek");
        this.assertTrue(result1.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testReleaseDownloads() throws Exception {
        PackageReleaseDownload[] result1 = this.client.releaseDownloads("spam", "3.3.5");
        this.assertTrue(result1.length > 0);
    }

    /**
     *
     * @throws Exception
     */
    public void testReleaseUrls() throws Exception {
        PackageReleaseUrl[] result1 = this.client.releaseUrls("spam", "3.3.5");
        this.assertTrue(result1.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testReleaseData() throws Exception {
        String version = "3.3.5";
        PackageReleaseData result = this.client.releaseData("spam", version);
        this.assertTrue(result.getVersion().equals(version));
    }
    /**
     *
     * @throws Exception
     */
    public void testBrowse() throws Exception {
        String[] classifiers = {"Topic :: Security","Environment :: Console"};
        PackageRelease[] results = this.client.browse(classifiers);
        this.assertTrue(results.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testUpdatedReleases() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2012);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 29);
        Date since = cal.getTime();
        PackageRelease[] results = this.client.updatedReleases(since);
        this.assertTrue(results.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testChangedPackages() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2012);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 29);
        Date since = cal.getTime();
        String[] results = this.client.changedPackages(since);
        this.assertTrue(results.length > 0);
    }
    /**
     *
     * @throws Exception
     */
    public void testSearch() throws Exception {
        Map<SearchParam, String[]> params = new HashMap<SearchParam, String[]>();
        params.put(SearchParam.NAME, new String[]{"nester"});
        PackageSearchResult[] result1 = this.client.search(params, SearchOperator.OR);
        PackageSearchResult[] result2 = this.client.search(params, SearchOperator.AND);
        PackageSearchResult[] result3 = this.client.search(params);
        this.assertTrue(result1.length > 0);
        this.assertTrue(result2.length > 0);
        this.assertTrue(result3.length > 0);
    }
}
