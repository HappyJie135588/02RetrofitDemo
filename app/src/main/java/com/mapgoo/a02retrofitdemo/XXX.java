package com.mapgoo.a02retrofitdemo;

import retrofit2.Retrofit;

public class XXX {

    public void xxx(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/")
                .build();
        GnakApi api = retrofit.create(GnakApi.class);
    }
}
