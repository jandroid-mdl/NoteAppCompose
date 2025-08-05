package com.example.noteappcompose.data.repository

import com.example.noteappcompose.domain.model.Note
import com.example.noteappcompose.domain.repository.NoteRepository

class NoteRepositoryImpl : NoteRepository {

    // Lista en memoria (simula una BD por ahora)
    private val notes = mutableListOf<Note>()

    override fun getNotes(): List<Note> {
        return notes
    }

    override fun addNote(note: Note) {
        notes.add(note)
    }

    override fun deleteNote(note: Note) {
        notes.remove(note)
    }
}
