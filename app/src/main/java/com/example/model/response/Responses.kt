
//Json Looks like this:
//"categories":[
//{
//    "idCategory":"1",
//    "strCategory":"Beef",
//    "strCategoryThumb":"https:\/\/www.themealdb.com\/images\/category\/beef.png",
//    "strCategoryDescription":
//}

package com.example.model.response
import com.google.gson.annotations.SerializedName
data class MealsCategoriesResponses(val categories: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory") val id: String, //The stuff in SerializedName is the stuff from JSON
    @SerializedName("strCategory") val name: String,                      //The character after val is the newly assigned name
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)