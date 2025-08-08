package org.muskan;

import java.util.Map;

public class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;

    public HttpRequest(Builder builder){
        this.url = builder.getUrl();
        this.method = builder.getMethod();
        this.headers = builder.getHeaders();
        this.queryParams = builder.getQueryParams();
        this.body = builder.getBody();
        this.timeout = builder.getTimeout();
    }

   // private static class Builder{}

    public String getUrl(){
        return url;
    }
    public String getMethod(){
        return method;
    }

    public Map<String, String> getHeaders(){
        return headers;
    }

    public Map<String, String> getQueryParams(){
        return queryParams;
    }

    public String getBody(){
        return body;
    }

    public int getTimeout(){
        return timeout;
    }
}
