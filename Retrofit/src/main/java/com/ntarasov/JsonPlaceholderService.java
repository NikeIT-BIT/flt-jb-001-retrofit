package com.ntarasov;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class JsonPlaceholderService {

    private Retrofit retrofit;
    private static JsonPlaceholderService instance;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private JsonPlaceholderService() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static JsonPlaceholderService getInstance() {
        if (instance == null)
            instance = new JsonPlaceholderService();
        return instance;
    }

    public JavaPlaceholderApi getJSONApi() {
        return retrofit.create(JavaPlaceholderApi.class);
    }


}
