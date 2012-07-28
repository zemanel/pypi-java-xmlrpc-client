package eu.zemanel.pypi.client;

import junit.framework.TestCase;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void testReleaseData() throws Exception {
        String version = "3.3.5";
        HashMap result = (HashMap) this.client.releaseData("spam", version);
        this.assertTrue(result.get("version").equals(version));
    }

    /**
     *
     * @throws Exception
     */
    public void testSearch() throws Exception {
        Map<SearchParam, String[]> params = new HashMap<SearchParam, String[]>();
        params.put(SearchParam.NAME, new String[]{"nester"});
        HashMap[] result1 = this.client.search(params, SearchOperator.OR);
        HashMap[] result2 = this.client.search(params, SearchOperator.AND);
        HashMap[] result3 = this.client.search(params);
        this.assertTrue(result1.length > 0);
        this.assertTrue(result2.length > 0);
        this.assertTrue(result3.length > 0);
    }
}
