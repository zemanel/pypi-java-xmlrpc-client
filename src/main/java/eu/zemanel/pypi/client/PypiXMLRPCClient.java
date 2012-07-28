package eu.zemanel.pypi.client;

import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
     * @param url Pypi url, ex.: "http://testpypi.python.org/pypi" or "http://pypi.python.org/pypi"
     * @throws PypiXMLRPCException
     */
    public PypiXMLRPCClient(URL url) throws PypiXMLRPCException {
        this.client = new XMLRPCClient(url, XMLRPCClient.FLAGS_NIL);
    }

    /**
     * Retrieve a list of the package names registered with the package index. Returns a list of name strings.
     * @return List of Python package names
     * @throws PypiXMLRPCException
     */
    public String[] listPackages() throws PypiXMLRPCException {
        try {
            Object[] result = (Object[])client.call("list_packages");
            String[] results = new String[result.length];
            for(int i=0; i < result.length; i++) {
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
        try {
            Object[] result = (Object[])client.call("package_releases", new Object[]{ packageName, showHidden });
            String[] results = new String[result.length];
            for(int i=0; i < result.length; i++) {
                results[i] = (String) result[i];
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
     * @param version A valid package version
     * @return Metadata describing a specific package release.
     * @throws PypiXMLRPCException
     */
    public HashMap releaseData(String packageName, String version) throws PypiXMLRPCException {
        try {
            return (HashMap)client.call("release_data", new Object[]{ packageName, version });
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     *
     * @param params Search spec (parameters)
     * @param searchOperator Search operator for different fields, "and" (the default) or "or".
     * @return List of results
     * @throws PypiXMLRPCException
     */
    public HashMap<String, String>[] search(Map<SearchParam, String[]> params, SearchOperator searchOperator) throws PypiXMLRPCException {
        try {
            // prepare call search parameters (convert search fields from enums to String values)
            Map<String, String[]> paramMap = new HashMap<String, String[]>();
            for(Map.Entry<SearchParam, String[]> param: params.entrySet()) {
                paramMap.put((param.getKey()).getValue(), param.getValue());
            }
            // call remote method
            Object[] result = (Object[]) client.call("search", paramMap, searchOperator.name());
            // convert results to array
            HashMap[] results = new HashMap[result.length];
            for(int i=0; i < result.length; i++) {
                results[i] = (HashMap<String, String>)result[i] ;
            }
            return results;
        } catch (XMLRPCException e) {
            throw new PypiXMLRPCException(e.getMessage());
        }
    }

    /**
     * Search the Pypi index using default operator ("and")
     * @param params Search spec (parameters)
     * @return List of results
     * @throws PypiXMLRPCException
     */
    public HashMap<String, String>[] search(Map<SearchParam, String[]> params) throws PypiXMLRPCException {
        return this.search(params, SearchOperator.AND);
    }
}
