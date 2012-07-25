package eu.zemanel.pypi.client;

import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Pypi XMLRPC client
 * More information: http://wiki.python.org/moin/PyPiXmlRpc
 */
public class PypiXMLRPCClient {

    private XMLRPCClient client;

    /**
     *
     * @throws PypiXMLRPCException
     */
    public PypiXMLRPCClient() throws PypiXMLRPCException {
        try {
            this.client = new XMLRPCClient(new URL("http://pypi.python.org/pypi"), XMLRPCClient.FLAGS_NIL);
        } catch (MalformedURLException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     * Retrieve a list of the package names registered with the package index. Returns a list of name strings.
     * @return List of Python package names
     * @throws PypiXMLRPCException
     */
    public String[] listPackages() throws PypiXMLRPCException {
        String[] packages;
        try {
            Object[] result = (Object[])client.call("list_packages");
            packages = Arrays.copyOf(result, result.length, String[].class);
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
        return packages;
    }

    /**
     * Retrieve a list of the releases registered for the given package_name.
     *
     * @param packageName Python package name
     * @return List of the releases registered for the given package name
     * @throws PypiXMLRPCException
     */
    public String[] packageReleases(String packageName) throws PypiXMLRPCException {
        return this.packageReleases(packageName, false);
    }

    /**
     * Retrieve a list of the releases registered for the given package_name.
     *
     * @param packageName Python package name
     * @param showHidden Returns a list with all version strings if showHidden is True or only the non-hidden ones otherwise.
     * @return List of the releases registered for the given package name
     * @throws PypiXMLRPCException
     */
    public String[] packageReleases(String packageName, boolean showHidden) throws PypiXMLRPCException {
        String[] releases;
        try {
            Object[] result = (Object[])client.call("package_releases", new Object[]{ packageName, showHidden });
            releases = Arrays.copyOf(result, result.length, String[].class);
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
        return releases;
    }

    /**
     * Retrieve metadata describing a specific package release.
     *
     * @param packageName Python package name
     * @param version A valid package version
     * @return Metadata describing a specific package release.
     * @throws PypiXMLRPCException
     */
    public HashMap releaseData(String packageName, String version) throws PypiXMLRPCException {
        HashMap result;
        try {
            result = (HashMap)client.call("release_data", new Object[]{ packageName, version });
            //releases = Arrays.copyOf(result, result.length, String[].class);
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
        return result;
    }
}
