package com.example.model.API

import com.example.model.response.MealsCategoriesResponses
import com.google.gson.internal.GsonBuildConfig
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {
    private lateinit var api: MealsAPI
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsAPI::class.java)
    }
    suspend fun getMeals(): MealsCategoriesResponses {
        return api.getMeals()   //With Coroutines use suspend to wait for the future, Asynchorous
    }
    interface MealsAPI{
        @GET("categories.php")
        suspend fun getMeals():MealsCategoriesResponses
    }
}