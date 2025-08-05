package com.example.noteappcompose.presentation.notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.noteappcompose.domain.model.Note
import com.example.noteappcompose.domain.usecase.AddNote
import com.example.noteappcompose.domain.usecase.DeleteNote
import com.example.noteappcompose.domain.usecase.GetNotes

class NotesViewModel(
    private val getNotes: GetNotes,
    private val addNote: AddNote,
    private val deleteNote: DeleteNote
) : ViewModel() {

    private val _notes = MutableStateFlow(getNotes())
    val notes = _notes.asStateFlow()

    fun add(note: Note) {
        addNote(note)
        _notes.value = getNotes()
    }

    fun delete(note: Note) {
        deleteNote(note)
        _notes.value = getNotes()
    }
}
