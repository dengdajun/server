package com.server.vinci.config;

import java.util.Map;

/**
 * Created by Werwolf on 2016/11/4.
 */
public class ServerConfig {
    private static final String DEFAULT_CONFIG="server.properties";
    private Map<String,Object>  configs=null;
    public ServerConfig(){
        new ServerConfig(DEFAULT_CONFIG);
    }
    public ServerConfig(String file){

    }

}
