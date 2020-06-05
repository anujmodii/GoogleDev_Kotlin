package com.example.coursebook.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_contents")
data class CourseContents(
    @PrimaryKey(autoGenerate = true)
    var courseId: Long = 0L,

    @ColumnInfo(name = "courseName")
    var courseName : String = "",

    @ColumnInfo(name = "channelNames")
    var channelName : String ="",

    @ColumnInfo(name = "channelLink")
    var channelLink : String =""
)
