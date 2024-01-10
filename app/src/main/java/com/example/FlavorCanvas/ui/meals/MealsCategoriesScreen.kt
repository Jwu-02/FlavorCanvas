package com.example.FlavorCanvas.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.FlavorCanvas.ui.theme.MealzAppTheme
import com.example.model.response.MealResponse



//@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MealsCategoriesScreen() { //This is the View
    val viewModel: MealCategoriesViewModel = viewModel()//Reference to the ViewModel
    val meals = viewModel.mealsState.value
//    val coroutineScope = rememberCoroutineScope()//This MealsCategories is recomposed many times
//    //The viewModel lives as long as the view Lives and does not reinstantiate all the time
//
//    LaunchedEffect(key1 =" GETMEALS") { //Use LaunchEffect to trigger it only once
//        coroutineScope.launch(Dispatchers.IO) { //Need to do this because
//            val meals = viewModel.getMeals()
//            rememberedMeals.value = meals
//        }
//    }
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MealCategory(meal)
        }
    }
}

@Composable
fun MealCategory(meal:MealResponse, ){
//    var text by remember { mutableStateOf("")}
//    Column( modifier = Modifier
//        .fillMaxWidth()
//        .padding(top = 16.dp)) {
//        TextField(
//            value = text,
//            onValueChange = { text = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp) // Optional: Add a background color
//                .padding(8.dp)
//        )
//    }

    var isExpanded by remember { mutableStateOf(false) }

    Card(shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp))
    {
        Row(modifier = Modifier.animateContentSize()) {
//            AsyncImage(
//                model = rememberAsyncImagePainter(meal.imageUrl),
//                contentDescription = null,
//                modifier = Modifier.size(80.dp).padding(4.dp)
//            )

            Image(
                painter = rememberImagePainter(meal.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(0.8f)
                .padding(16.dp)) {
                Text(text = meal.name, style = MaterialTheme.typography.labelLarge)
                CompositionLocalProvider(LocalContentColor provides  MaterialTheme.colorScheme.onSurface) {
                    Text(text = meal.description,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.titleSmall,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if(isExpanded)50 else 3)
                }

            }
            Icon(imageVector = if(isExpanded) Icons.Filled.KeyboardArrowUp else
                Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand row icon",
                modifier = Modifier
                    .padding(16.dp)
                    .align(if(isExpanded) Alignment.Bottom else Alignment.CenterVertically)
                    .clickable { isExpanded= !isExpanded})

        }
    }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}
