package br.com.aldemir.circleprogresscustom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import br.com.aldemir.circleprogresscustom.components.CourseItem
import br.com.aldemir.circleprogresscustom.data.dataSources.DataSources
import br.com.aldemir.circleprogresscustom.data.models.Course
import br.com.aldemir.circleprogresscustom.screens.DetailScreen
import br.com.aldemir.circleprogresscustom.screens.HomeScreen
import br.com.aldemir.circleprogresscustom.ui.theme.CircleProgressCustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleProgressCustomTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home")
                {
                    composable("home") { HomeScreen(navController) }
                    composable(
                        route = "detail/{id}"
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id") ?: ""
                        DetailScreen(navController, id = id.toInt())
                    }


                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CircleProgressCustomTheme {

    }
}