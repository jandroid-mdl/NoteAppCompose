package com.example.noteappcompose.domain.usecase

import com.example.noteappcompose.domain.model.Note
import com.example.noteappcompose.domain.repository.NoteRepository

class GetNotes(private val repository: NoteRepository) {
    operator fun invoke(): List<Note> {
        return repository.getNotes()
    }
}
