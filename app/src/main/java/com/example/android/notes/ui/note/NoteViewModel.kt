package com.example.android.notes.ui.note

import android.arch.lifecycle.ViewModel
import com.example.android.notes.data.NotesRepository
import com.example.android.notes.data.entity.Note

class NoteViewModel(private val repository: NotesRepository = NotesRepository) : ViewModel() {

    private var pendingNote: Note? = null

    fun save(note: Note){
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            repository.saveNote(it)
        }
    }

}