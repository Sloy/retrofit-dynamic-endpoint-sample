package com.sloydev.dynamicretrofitendpoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private SevibusApi sevibusApi;
    private SevibusEndpoint endpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.execute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest();
            }
        });

        endpoint = new SevibusEndpoint();
        sevibusApi = new RestAdapter.Builder()
          .setEndpoint(endpoint)
          .build().create(SevibusApi.class);

        endpoint.setUrl("http://api.sevibus.sloydev.com");

    }

    private void executeRequest() {
        sevibusApi.hello(new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                String url = response.getUrl();
                Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
                Log.d("URL", "url");
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                Log.e("URL", "error", error.getCause());
            }
        });
    }
}
