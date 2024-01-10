package com.example.FlavorCanvas.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.MealsRepository
import com.example.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealCategoriesViewModel (val repository:MealsRepository = MealsRepository()): ViewModel() //Passing the repository to the ViewModel
{
    private val mealsJob = Job()
    init {
        Log.d("Tag Coroutines", "We are about to launch a coroutine") //1
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Tag Coroutines", "WE HAVE LAUNCHED A COROUTINE") //3
            val meals = getMeals()
            Log.d("Tag Coroutines", "We HAVE RECEIVED ASYNC DATA") //4
            mealsState.value = meals
        }
        Log.d("Tag Coroutines", "Other work") //2

    }
    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())
    suspend fun getMeals():List<MealResponse>{
         return repository.getMeals().categories
         }

}
