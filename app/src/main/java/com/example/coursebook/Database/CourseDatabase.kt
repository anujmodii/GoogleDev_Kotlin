package com.example.coursebook.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [CourseContents::class], version = 1)
abstract class CourseDatabase : RoomDatabase() {

    abstract fun courseDatabaseDao(): CourseDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: CourseDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CourseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CourseDatabase::class.java,
                    "course_guide"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.courseDatabaseDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(courseDao : CourseDatabaseDao) {
            courseDao.deleteAll()
            var courseA= CourseContents()
            courseA.courseName="aad"
            courseA.channelName="App Dev - Youtube"
            courseA.channelLink="https://www.youtube.com/playlist?list=PLknSwrodgQ72X4sKpzf5vT8kY80HKcUSe"
            courseDao.insert(courseA)
            courseA.courseName="aad"
            courseA.channelName="App Dev - Udacity"
            courseA.channelLink="https://classroom.udacity.com/courses/ud851"
            courseDao.insert(courseA)
            courseA.courseName="ds"
            courseA.channelName="Data Science - Youtube"
            courseA.channelLink="https://www.youtube.com/watch?v=KdgQvgE3ji4&list=PL9ooVrP1hQOGR57Y4g1LFhn1JXVgn1lkX"
            courseDao.insert(courseA)
            courseA.courseName="ds"
            courseA.channelName="Data Science - Edureka"
            courseA.channelLink="https://www.youtube.com/playlist?list=PL9ooVrP1hQOGR57Y4g1LFhn1JXVgn1lkX"
            courseDao.insert(courseA)
            courseA.courseName="sql"
            courseA.channelName="SQL - Youtube"
            courseA.channelLink="https://www.youtube.com/playlist?list=PL08903FB7ACA1C2FB"
            courseDao.insert(courseA)
            courseA.courseName="sql"
            courseA.channelName="SQL - NPTEL"
            courseA.channelLink="https://nptel.ac.in/courses/106/106/106106093/"
            courseDao.insert(courseA)
            courseA.courseName="wd"
            courseA.channelName="Web Dev - Youtube"
            courseA.channelLink="https://www.youtube.com/playlist?list=PLu0W_9lII9agiCUZYRsvtGTXdxkzPyItg"
            courseDao.insert(courseA)
            courseA.courseName="wd"
            courseA.channelName="Web Dev - w3schools"
            courseA.channelLink="https://www.w3schools.com/whatis/"
            courseDao.insert(courseA)
            courseA.courseName="py"
            courseA.channelName="Python - Youtube"
            courseA.channelLink="https://www.youtube.com/playlist?list=PL9ooVrP1hQOHY-BeYrKHDrHKphsJOyRyu"
            courseDao.insert(courseA)
            courseA.courseName="py"
            courseA.channelName="Python - Edyoda"
            courseA.channelLink="https://www.edyoda.com/course/1462?episode_id=1381"
            courseDao.insert(courseA)
        }
    }

}

