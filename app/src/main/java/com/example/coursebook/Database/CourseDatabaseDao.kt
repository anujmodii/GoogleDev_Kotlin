package com.example.coursebook.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CourseDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(course: CourseContents)

    @Query("SELECT * from course_contents WHERE coursename= :key")
    fun get(key : String): List<CourseContents>

    @Query("SELECT * from course_contents")
    fun get(): LiveData<List<CourseContents>>

    @Query("DELETE FROM course_contents")
    fun deleteAll()

}