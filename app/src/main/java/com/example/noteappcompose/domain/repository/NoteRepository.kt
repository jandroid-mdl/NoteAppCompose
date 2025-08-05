package com.example.noteappcompose.domain.repository

import com.example.noteappcompose.domain.model.Note


interface NoteRepository {
    fun getNotes(): List<Note>
    fun addNote(note: Note)
    fun deleteNote(note: Note)
}