package com.mapgoo.a02retrofitdemo

import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST
import android.R.style.Widget
import retrofit2.http.GET






interface GnakApi {
    //http://gank.io/api/data/Android/10/1
    @GET("api/data/Android/10/{page}")
    fun getAndroidInfo(@Path("page") page: Int): Call<GankBean>

    //http://op.juhe.cn/onebox/weather/query?cityname=深圳&key=您申请的KEY
    @GET("onebox/weather/query?cityname=深圳")
    fun getWeather(@Query("key") key: String): Call<WeatherDataBean>

    @GET("onebox/weather/query")
    fun getWeather(@QueryMap params: Map<String, String>): Call<WeatherDataBean>

    @POST("user/new")
    fun postUser(@Body user: User): Call<Result3>

    @POST("user/edit")
    fun editUser(@Field("id") id: Int, @Field("name") name: String): Call<Result>

    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    fun widgetList(): Call<List<Widget>>
}