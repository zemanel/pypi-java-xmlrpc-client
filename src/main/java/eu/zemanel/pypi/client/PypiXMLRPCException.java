package eu.zemanel.pypi.client;

/**
 *
 */
public class PypiXMLRPCException extends Exception {

    public PypiXMLRPCException() {
        super();
    }

    public PypiXMLRPCException(Exception ex) {
        super(ex);
    }

    public PypiXMLRPCException(String ex) {
        super(ex);
    }

    public PypiXMLRPCException(String msg, Exception ex) {
        super(msg, ex);
    }
}
