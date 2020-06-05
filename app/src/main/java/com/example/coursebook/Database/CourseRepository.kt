package com.example.coursebook.Database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
class CourseRepository(private val courseDao: CourseDatabaseDao) {

    val allCourses: LiveData<List<CourseContents>> = courseDao.get()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(course : CourseContents) {
        courseDao.insert(course)
    }

}