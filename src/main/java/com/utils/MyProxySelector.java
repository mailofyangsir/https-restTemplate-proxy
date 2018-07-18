package com.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MyProxySelector extends ProxySelector {

    ProxySelector defaultproxySelector = ProxySelector.getDefault();

    ArrayList<Proxy> noProxy = new ArrayList<Proxy>();
    ArrayList<Proxy> secureProxy = new ArrayList<Proxy>();
    ArrayList<Proxy> sociaMediaProxy = new ArrayList<Proxy>();

    public MyProxySelector(){

        noProxy.add(Proxy.NO_PROXY);

        secureProxy.add(new Proxy(Type.HTTP, new InetSocketAddress(
            "secure.proxy.mycompany.com", 8080)));

        sociaMediaProxy.add(new Proxy(Type.HTTP, new InetSocketAddress(
                "social-media.proxy.mycompany.com", 8080)));
    }

    @Override
    public List<Proxy> select(URI uri) {

        // No proxy for local company addresses.
        if ( uri.getHost().toLowerCase().endsWith("mycompany.com") ) {
            return noProxy ;
        }

        // Special proxy for social networks.
        String host = uri.getHost().toLowerCase();
        if (    host.endsWith("facebook.com") ||
                host.endsWith("twitter.com") ||
                host.endsWith("cfapps.io") ||               
                host.endsWith("flickr.com") ) 
        {
            return sociaMediaProxy ;
        }

        // for https URIs use secureProxy
        if ( uri.getScheme().toLowerCase().equals("https") ){
            return secureProxy ;
        }

        if (defaultproxySelector != null) {
            return defaultproxySelector.select(uri);
        }

        return noProxy;
    }

    @Override
    public void connectFailed(URI arg0, SocketAddress arg1, IOException arg2) {
        // TODO Auto-generated method stub
    }
}