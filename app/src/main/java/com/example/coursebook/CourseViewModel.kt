package com.example.coursebook

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.coursebook.Database.CourseContents
import com.example.coursebook.Database.CourseDatabase
import com.example.coursebook.Database.CourseDatabaseDao
import com.example.coursebook.Database.CourseRepository
import kotlinx.android.synthetic.main.list_item_layout.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CourseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CourseRepository
    val allCourses: LiveData<List<CourseContents>>

    init {
        val courseDao = CourseDatabase.getDatabase(application, viewModelScope).courseDatabaseDao()
        repository = CourseRepository(courseDao)
        this.allCourses = repository.allCourses
    }
}
