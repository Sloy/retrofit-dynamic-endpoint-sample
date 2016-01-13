package com.sloydev.dynamicretrofitendpoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String URL_1 = "http://api.sevibus.sloydev.com";
    private static final String URL_2 = "https://sevibus.herokuapp.com";

    private SevibusApi sevibusApi;
    private SevibusEndpoint endpoint;
    private TextView currentEndpointText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentEndpointText = ((TextView) findViewById(R.id.current_endpoint));

        findViewById(R.id.url1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEndpoint(URL_1);
            }
        });

        findViewById(R.id.url2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEndpoint(URL_2);
            }
        });

        findViewById(R.id.execute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest();
            }
        });

        endpoint = new SevibusEndpoint();
        sevibusApi = new RestAdapter.Builder()
          .setLogLevel(RestAdapter.LogLevel.BASIC)
          .setEndpoint(endpoint)
          .build().create(SevibusApi.class);
    }

    private void changeEndpoint(String url) {
        currentEndpointText.setText("Current endpoint: "+url);
        endpoint.setUrl(url);
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
