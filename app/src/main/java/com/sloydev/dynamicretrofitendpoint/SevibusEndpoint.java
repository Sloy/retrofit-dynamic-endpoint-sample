package com.sloydev.dynamicretrofitendpoint;

import retrofit.Endpoint;

public class SevibusEndpoint implements Endpoint {

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getName() {
        return url;
    }
}
