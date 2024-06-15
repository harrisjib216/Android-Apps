package com.example.noteapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var noteInput: EditText? = null;
    private var addNoteBtn: Button? = null;
    private var notesListView: ListView? = null;

    private var notes: ArrayList<String> = ArrayList<String>();
    private var localAdapter: ArrayAdapter<String>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteInput = findViewById(R.id.note_input)
        addNoteBtn = findViewById(R.id.add_note_btn)
        notesListView = findViewById(R.id.notes_list)

        localAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes);
        notesListView?.adapter = localAdapter;

        addNoteBtn?.setOnClickListener{
            insertNote()
        }
    }

    private fun insertNote() {
        val text = noteInput?.text.toString()
        if (text.isNotEmpty()) {
            notes.add(text)
            localAdapter?.notifyDataSetChanged()
            noteInput?.setText("");
        }
    }
}