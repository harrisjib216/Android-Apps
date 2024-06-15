package com.example.oldmomentsnotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.sql.Date
import java.sql.Time
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    private var notes = mutableListOf<Note>()
    private var loading = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // remove
        generateNotes()

        fetchNotes()
        configListView()
    }

    private fun generateNotes() {
        for (i in 0..100) {
            notes.add(
                Note(
                    title = i.toString(),
                    createdAt = LocalTime.now(),
                    lastUpdated = LocalTime.now(),
                    content = List<Body>(1) {
                        Body(i.toString(), "", "")
                    }
                )
            )
        }
    }

    private fun fetchNotes() {

    }

    private fun configListView() {
        val notesList = findViewById<RecyclerView>(R.id.notesList)
        val adapter = NotesListAdapter(notes)
        notesList.adapter = adapter
        notesList.layoutManager = LinearLayoutManager(this)
    }
}


/*
Old Moments: Notes App
- Write entries
- Save them to SQL DB
- Pull them back up
- Modify them
- Challenge: support Bold, Italic, and Large fonts
- Challenge: Support adding images
*/