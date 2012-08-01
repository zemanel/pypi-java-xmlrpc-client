pypi-java-xmlrpc-client
=======================

A simple Java XMLRPC client for the Python package index.

* http://pypi.python.org/pypi
* http://wiki.python.org/moin/PyPiXmlRpc

Requirements
------------

* Maven 3.x ( http://maven.apache.org )
* http://github.com/timroes/aXMLRPC (installed on your local Maven repository)

Install
-------

    $ cd /path/to/pypi-java-xmlrpc-client
    $ mvn clean install

This will install the library on your local Maven repository.

To use it on your Maven project, add it as a dependency on your pom.xml file:

    <dependency>
        <groupId>eu.zemanel</groupId>
        <artifactId>pypi-java-xmlrpc-client</artifactId>
        <version>0.1</version>
    </dependency>

Implemented xmlrpc calls
------------------------

Documented (from http://wiki.python.org/moin/PyPiXmlRpc) :

    [X] list_packages()
    [X] package_releases(package_name, show_hidden=False)
    [X] package_roles(package_name)
    [x] user_packages(user)
    [X] release_downloads(package_name, version)
    [X] release_urls(package_name, version)
    [X] release_data(package_name, version)
    [X] search(spec[, operator])
    [x] browse(classifiers)
    [ ] changelog(since)

Undocumented (from source code):

    [x] updated_releases(since)
    [x] changed_packages
