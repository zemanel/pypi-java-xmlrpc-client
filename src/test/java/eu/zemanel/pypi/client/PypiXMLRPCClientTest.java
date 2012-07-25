package eu.zemanel.pypi.client;

import junit.framework.TestCase;

import java.util.HashMap;

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
        this.client = new PypiXMLRPCClient();
    }

    /**
     *
     * @throws Exception
     */
    public void testListPackages() throws Exception {
        String[] result = this.client.listPackages();
    }

    /**
     *
     * @throws Exception
     */
    public void testPackageReleases() throws Exception {
        String[] result1 = this.client.packageReleases("an_example_pypi_project");
        String[] result2 = this.client.packageReleases("an_example_pypi_project", false);
        String[] result3 = this.client.packageReleases("an_example_pypi_project", true);
    }

    /**
     *
     * @throws Exception
     */
    public void testReleaseData() throws Exception {
        HashMap result = (HashMap) this.client.releaseData("an_example_pypi_project", "0.0.5");
    }
}
