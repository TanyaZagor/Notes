package com.example.android.notes.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.android.notes.data.entity.Note
import java.util.*

object NotesRepository {

    private val notesLiveData = MutableLiveData<List<Note>>()

    val notes: MutableList<Note> = mutableListOf(
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.WHITE
            ),
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.BLUE
            ),
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.GREEN
            ),
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.PINK
            ),
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.RED
            ),
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.YELLOW
            ),
            Note(
                UUID.randomUUID().toString(),
                "Моя первая заметка",
                "Kotlin очень краткий, но при этом выразительный язык",
                Note.Color.VIOLET
            )
    )

    init {
        notesLiveData.value = notes
    }

    fun getNotes(): LiveData<List<Note>>{
        return notesLiveData
    }

    fun saveNote(note: Note) {
        addOrReplace(note)
        notesLiveData.value = notes
    }

    private fun addOrReplace(note: Note) {
        for (i in 0 until notes.size) {
            if (notes[i] == note) {
                notes[i] = note

                return
            }
        }
        notes.add(note)
    }
}