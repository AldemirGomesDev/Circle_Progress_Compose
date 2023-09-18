package br.com.aldemir.circleprogresscustom.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.aldemir.circleprogresscustom.components.CircleProgressCustom
import br.com.aldemir.circleprogresscustom.data.dataSources.DataSources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    id: Int
) {
    val course = DataSources.getCourseById(id)

    Scaffold { paddingValues ->
        course?.let {
            Surface(
                color = course.colorMain,
                modifier = Modifier
                    .padding(horizontal = 80.dp, vertical = 64.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .clickable {
                        navController.popBackStack()
                    }
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 32.dp,
                            bottom = 32.dp
                        )
                        .width(IntrinsicSize.Max)
                        .padding(paddingValues)
                ) {
                    CircleProgressCustom(
                        allSteps = course.allClasses,
                        finishedSteps = course.finishedClasses,
                        sizeStroke = 16.dp,
                        modifier = Modifier.size(160.dp),
                        progressColor = course.progressColor,
                        baseColor = course.baseColor,
                        textColor = if (course.isLightColor) Color.Black else Color.White,
                        textFontSize = 32.dp
                    )
                    Spacer(modifier = Modifier.height(48.dp))
                    Text(
                        text = course.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (course.isLightColor) Color.Black else Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "${course.allClasses} Classes •\t ${course.level.name}",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = if (course.isLightColor) Color(0xFF99948F) else Color.White,
                            fontSize = 18.sp
                        ),
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}