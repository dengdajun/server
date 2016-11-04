package com.server.vinci.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Werwolf on 2016/11/4.
 */
public class ServerConfig {
    private static final String CONFIG_DIR="server.properties";
    private static final String DEFAULT_CONFIG="server.properties";
    private Map<String,Object>  configs=null;
    public ServerConfig(){
        new ServerConfig(DEFAULT_CONFIG);
    }
    public ServerConfig(String file){
        Properties property=new Properties();
        property.load(new InputStream(ServerConfig.class.getClassLoader().getResourceAsStream(CONFIG_DIR+file), "utf-8"));
    }

}
