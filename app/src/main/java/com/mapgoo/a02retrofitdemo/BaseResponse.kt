package com.mapgoo.a02retrofitdemo

class BaseResponse<T>(
        val error: Int,
        val resaon: String,
        val result: T
)