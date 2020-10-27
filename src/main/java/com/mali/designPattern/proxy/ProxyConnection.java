package com.mali.designPattern.proxy;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

public class ProxyConnection implements InternetConnection {

    static List<String> sites = new ArrayList<>();
    private static InternetConnection internetConnection;

    static {
         sites.add("com.xyz.com");
         sites.add("com.abc.com");
    }

    @Override
    public String getConnection(String site) throws AccessDeniedException {
        if (sites.contains(site)){
            throw new AccessDeniedException("illegal access");
        }
        else if (internetConnection == null){
            internetConnection = new RealConnection();
        }
        return internetConnection.getConnection(site);
    }
}
