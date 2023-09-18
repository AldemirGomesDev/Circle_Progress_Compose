package br.com.aldemir.circleprogresscustom.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.aldemir.circleprogresscustom.components.CourseItem
import br.com.aldemir.circleprogresscustom.data.dataSources.DataSources

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val courses = DataSources.getAllCourses()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyRow(modifier = Modifier.padding(vertical = 32.dp)) {
            items(courses.size) { index ->
                CourseItem(
                    course = courses[index],
                    modifier = Modifier.padding(start = if (index == 0) 24.dp else 16.dp),
                    onClick = {
                        navController.navigate(route = "detail/${it.id.toString()}")
                    }
                )
            }
        }
    }
}