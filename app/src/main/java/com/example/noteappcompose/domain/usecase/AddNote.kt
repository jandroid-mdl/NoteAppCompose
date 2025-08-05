package com.example.noteappcompose.domain.usecase

import com.example.noteappcompose.domain.model.Note
import com.example.noteappcompose.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {
    operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}
