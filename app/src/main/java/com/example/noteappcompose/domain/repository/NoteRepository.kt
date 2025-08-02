package com.example.noteappcompose.domain.repository

interface NoteRepository {
    fun getNotes(): List<Note>
    fun addNote(note: Note)
    fun deleteNote(note: Note)
}