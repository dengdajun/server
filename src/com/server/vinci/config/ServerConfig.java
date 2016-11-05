package com.server.vinci.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Werwolf on 2016/11/4.
 */
public class ServerConfig {
    private static final String SERVER_DIR=System.getProperty("user.dir");
    private static final String CONFIG_DIR="config";
    private static final String DEFAULT_CONFIG="server.properties";
    private Map<String,Object>  configs;
    public ServerConfig(){
        this(DEFAULT_CONFIG);
    }
    public ServerConfig(String file){
        Properties property=new Properties();
        String path=SERVER_DIR+ File.separator+CONFIG_DIR+ File.separator+file;
        try {
            property.load(new FileInputStream(path));
            this.configs=(Map)property;
        } catch (IOException e) {
            System.out.println("service load configuration fail");
            System.exit(1);
        }

    }
    public Object getKey(String key){
        return  this.configs.get(key);
    }

}
