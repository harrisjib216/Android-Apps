package com.example.oldmomentsnotesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesListAdapter(private val dataList: List<Note>) : RecyclerView.Adapter<NotesListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_row, parent, false)
        return NotesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
        val data = dataList[position]
        holder.noteDate.text = data.lastUpdated.toString()
        holder.noteTitle.text = data.title
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}