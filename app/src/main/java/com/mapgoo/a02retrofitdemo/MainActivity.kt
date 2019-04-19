package com.mapgoo.a02retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_requet1.setOnClickListener {
            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("http://gank.io/")
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .build()
            val api = retrofit.create(GnakApi::class.java)

            val call: Call<GankBean> = api.getAndroidInfo(10)

            call.enqueue(object : Callback<GankBean> {
                override fun onResponse(call: Call<GankBean>?, response: Response<GankBean>?) {
                    if (response == null) {
                        return
                    }
                    val bean: GankBean = response?.body()!!
                    val results = bean.results
                    val result = results[0]

                    val str: String = Gson().toJson(result)
                    Log.i("TAG", str)
                    tv_result.text =str
                }

                override fun onFailure(call: Call<GankBean>?, t: Throwable?) {

                }
            })
        }
        btn_requet2.setOnClickListener({
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://op.juhe.cn/")
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .build()
            val api = retrofit.create(GnakApi::class.java)

            val call: Call<WeatherDataBean> = api.getWeather("4ea58de8a7573377cec0046f5e2469d5")

            call.enqueue(object : Callback<WeatherDataBean> {
                override fun onResponse(call: Call<WeatherDataBean>?, response: Response<WeatherDataBean>?) {
                    if (response == null) {
                        return
                    }
                    val weatherDataBean = response.body()
                    var result = weatherDataBean!!.result
                    var dataBean = result.data
                    var realtime = dataBean.realtime
                    var weather = realtime.weather
                    var info = weather.info

                    tv_result.text ="深圳天气：" + info;

                }

                override fun onFailure(call: Call<WeatherDataBean>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
        })
        btn_requet3.setOnClickListener({
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://op.juhe.cn/")
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .build()
            val api = retrofit.create(GnakApi::class.java)

            val params = HashMap<String,String>()
            params.put("cityname", "深圳")
            params.put("key", "4ea58de8a7573377cec0046f5e2469d5")
            val call: Call<WeatherDataBean> = api.getWeather(params)

            call.enqueue(object : Callback<WeatherDataBean> {
                override fun onResponse(call: Call<WeatherDataBean>?, response: Response<WeatherDataBean>?) {
                    if (response == null) {
                        return
                    }
                    val weatherDataBean = response.body()
                    var result = weatherDataBean!!.result
                    var dataBean = result.data
                    var realtime = dataBean.realtime
                    var weather = realtime.weather
                    var info = weather.info

                    tv_result.text ="深圳天气：" + info;

                }

                override fun onFailure(call: Call<WeatherDataBean>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
        })
        btn_requet4.setOnClickListener({
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://gank.io/")
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .build()
            val api = retrofit.create(GnakApi::class.java)


            val call: Call<Result3> = api.postUser(User(1,"lgl"))

            call.enqueue(object : Callback<Result3> {
                override fun onResponse(call: Call<Result3>?, response: Response<Result3>?) {
                    if (response == null) {
                        return
                    }
                    val result3 = response.body()
                    if(result3?.yes==0){
                        toast("成功")
                    }

                }

                override fun onFailure(call: Call<Result3>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    toast("错误")
                }

            })
        })

    }
}
