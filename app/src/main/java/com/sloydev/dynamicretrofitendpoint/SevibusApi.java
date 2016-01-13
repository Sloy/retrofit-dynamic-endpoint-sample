package com.sloydev.dynamicretrofitendpoint;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

public interface SevibusApi {

    @GET("/greeting")
    void hello(Callback<Response> callback);

}
