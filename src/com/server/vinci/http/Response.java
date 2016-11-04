package com.server.vinci.http;

import java.io.OutputStream;

/**
 * Created by YoungMan on 2016/11/5.
 */
public class Response {
    private Request request;

    public Response(OutputStream outputStream) {
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
