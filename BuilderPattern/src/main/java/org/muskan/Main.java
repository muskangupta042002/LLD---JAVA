package org.muskan;

public class Main {
    public static void main(String[] args) {
        HttpRequest request1 = new Builder("https://api.example.com/data").method("POST")
                .addHeader("Content-Type","application/json")
                .addQueryParam("user","muskan")
                .body("{\"msg\":\"Hello\"}")
                .timeout(10000)
                .build();

        System.out.println("Method: "+ request1.getMethod());
        System.out.println("URL: "+request1.getUrl());

    }
}