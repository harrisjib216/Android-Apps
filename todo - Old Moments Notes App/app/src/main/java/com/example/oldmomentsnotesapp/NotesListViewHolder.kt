package com.example.oldmomentsnotesapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var noteDate: TextView = itemView.findViewById(R.id.noteDate)
    val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)
}
