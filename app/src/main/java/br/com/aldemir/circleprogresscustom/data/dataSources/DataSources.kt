package br.com.aldemir.circleprogresscustom.data.dataSources

import androidx.compose.ui.graphics.Color
import br.com.aldemir.circleprogresscustom.data.models.Course
import br.com.aldemir.circleprogresscustom.data.models.Level

object DataSources {

    private val allLearnedCourses = listOf(
        Course(
            id = 1,
            name = "German \nLanguage",
            allClasses = 20,
            finishedClasses = 10,
            level = Level.Easy,
            colorMain = Color(0xFF5B7BFE),
            progressColor = Color(0xFF051774),
            baseColor = Color(0xFFF2F4FF)
        ),
        Course(
            id = 2,
            name = "Spanish\nLanguage",
            allClasses = 30,
            finishedClasses = 10,
            level = Level.Easy,
            colorMain = Color(0xFFFFF6EB),
            isLightColor = true,
            progressColor = Color(0xFFF76400),
            baseColor = Color(0xFFFEEAD9)
        ),
        Course(
            id = 3,
            name = "Vietnamese\nLanguage",
            allClasses = 20,
            finishedClasses = 4,
            level = Level.Hard,
            colorMain = Color(0xFF051774),
            progressColor = Color(0xFF2295F8),
            baseColor = Color(0xFFA4B0EE)
        ),
        Course(
            id = 4,
            name = "Korea\nLanguage",
            allClasses = 20,
            finishedClasses = 15,
            level = Level.Medium,
            colorMain = Color(0xFFFFF6EB),
            isLightColor = true,
            progressColor = Color(0xFFF76400),
            baseColor = Color(0xFFFEEAD9),
        ),
    )

    fun getCourseById(id: Int): Course? {
        return allLearnedCourses.firstOrNull { it.id == id }
    }

    fun getAllCourses() = allLearnedCourses
}