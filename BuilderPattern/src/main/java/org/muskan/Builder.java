package org.muskan;

import java.util.*;
public class Builder {
    private final String url;
    private String method = "GET";
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParams = new HashMap<>();
    private String body;
    private int timeout = 30000;
    public Builder(String url){
        this.url=url;
    }

    public Builder method(String method){
        this.method=method;
        return this;
    }

    public Builder addHeader(String key, String value){
        this.headers.put(key,value);
        return this;
    }

    public Builder addQueryParam(String key, String value){
        this.queryParams.put(key, value);
        return this;
    }

    public Builder body(String body){
        this.body=body;
        return this;
    }

    public Builder timeout(int timeout){
        this.timeout=timeout;
        return this;
    }

    public HttpRequest build(){
        return new HttpRequest(this);
    }

    public String getUrl() { return url; }
    public String getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public Map<String, String> getQueryParams() { return queryParams; }
    public String getBody() { return body; }
    public int getTimeout() { return timeout; }
}
