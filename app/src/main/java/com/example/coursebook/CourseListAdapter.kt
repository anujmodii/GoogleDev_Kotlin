package com.example.coursebook
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coursebook.Database.CourseContents
import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.coursebook.Database.CourseDatabaseDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.list_item_layout.view.*


class CourseListAdapter internal constructor(context: Context) :
                RecyclerView.Adapter<CourseListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
//    private val coursesAvailable = listOf(
//        "Android App Development", "Data Science",
//        "SQL", "Web Development", "Python"
//    )
    private var courses = emptyList<CourseContents>()
    internal fun setWords(course: List<CourseContents>) {
        courses = course
        notifyDataSetChanged()
    }

    private val newWordActivityRequestCode = 1
    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: Button = itemView.findViewById(R.id.textViewRecycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.list_item_layout, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.wordItemView.text = courses[position].channelName
        }


    override fun getItemCount() = courses.size
}

