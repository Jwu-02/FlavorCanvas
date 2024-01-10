package com.example.model

import com.example.model.API.MealsWebService
import com.example.model.response.MealsCategoriesResponses
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals():MealsCategoriesResponses{ //The ? is used to handle null exceptions
        return webService.getMeals()
    }
}