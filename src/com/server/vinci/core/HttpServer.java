package com.server.vinci.core;

import com.server.vinci.config.ServerConfig;
import com.server.vinci.http.HttpRequest;
import com.server.vinci.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Werwolf on 2016/11/4.
 */
public class HttpServer {
    private static final String SHUTDOWN_COMMAND="shudown";
    private boolean shutdown=false;
    private ServerConfig config;
    public static void main(String[] arg){
        ServerConfig config=new ServerConfig();
        HttpServer server=new HttpServer(config);
        server.await();
    }
    public HttpServer(ServerConfig config){
        this.config=config;
    }

    public  void await()  {
        int port=Integer.parseInt((String)this.getConfig().getKey("server.port"));
        ServerSocket serverSocket=null;
        try {
             serverSocket=new ServerSocket(port,50, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            System.out.println("open service fail");
            System.exit(1);
        }
        while(!shutdown){
            Socket socket;
            InputStream inputStream;
            OutputStream outputStream;
                try {
                    socket=serverSocket.accept();
                    inputStream=socket.getInputStream();
                    outputStream=socket.getOutputStream();
                    HttpRequest request=new HttpRequest(inputStream);
                    request.parse();
                    HttpResponse response=new HttpResponse(outputStream);
                    response.setRequest(request);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }

        }

    }
    public ServerConfig getConfig() {
        return config;
    }
    public void setConfig(ServerConfig config) {
        this.config = config;
    }
    public boolean isShutdown() {
        return shutdown;
    }
    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }
}
