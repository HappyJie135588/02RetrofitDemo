package com.mapgoo.a02retrofitdemo

data class WeatherDataBean(
        val error_code: Int,
        val reason: String,
        val result: Result1
)

data class Result1(
        val `data`: Data
)

data class Data(
        val date: String,
        val f3h: F3h,
        val isForeign: String,
        val jingqu: String,
        val jingqutq: String,
        val life: Life,
        val partner: Partner,
        val pm25: Pm25,
        val realtime: Realtime,
        val weather: List<Weather>
)

data class Weather(
        val date: String,
        val info: Info,
        val nongli: String,
        val week: String
)

data class Info(
        val dawn: List<String>,
        val day: List<String>,
        val night: List<String>
)

data class F3h(
        val precipitation: List<Precipitation>,
        val temperature: List<Temperature>
)

data class Precipitation(
        val jf: String,
        val jg: String
)

data class Temperature(
        val jb: String,
        val jg: String
)

data class Pm25(
        val cityName: String,
        val dateTime: String,
        val key: String,
        val pm25: Pm25X
)

data class Pm25X(
        val city_code: String,
        val curPm: String,
        val des: String,
        val level: Int,
        val pm10: String,
        val pm25: String,
        val pub_time: Int,
        val quality: String
)

data class Realtime(
        val city_code: String,
        val city_name: String,
        val dataUptime: Int,
        val date: String,
        val moon: String,
        val time: String,
        val weather: WeatherX,
        val week: String,
        val wind: Wind
)

data class WeatherX(
        val humidity: String,
        val img: String,
        val info: String,
        val temperature: String
)

data class Wind(
        val direct: String,
        val offset: String,
        val power: String,
        val windspeed: String
)

data class Partner(
        val base_url: String,
        val show_url: String,
        val title_word: String
)

data class Life(
        val date: String,
        val info: InfoX
)

data class InfoX(
        val chuanyi: List<String>,
        val daisan: List<String>,
        val diaoyu: List<String>,
        val ganmao: List<String>,
        val guomin: List<String>,
        val kongtiao: List<String>,
        val shushidu: List<String>,
        val xiche: List<String>,
        val yundong: List<String>,
        val ziwaixian: List<String>
)