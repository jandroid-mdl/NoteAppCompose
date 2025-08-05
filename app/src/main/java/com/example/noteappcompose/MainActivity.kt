package com.example.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.noteappcompose.data.repository.NoteRepositoryImpl

import com.example.noteappcompose.domain.usecase.AddNote
import com.example.noteappcompose.domain.usecase.DeleteNote
import com.example.noteappcompose.domain.usecase.GetNotes
import com.example.noteappcompose.presentation.addnote.AddNoteScreen
import com.example.noteappcompose.presentation.notes.NotesScreen
import com.example.noteappcompose.presentation.notes.NotesViewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val repository = NoteRepositoryImpl()
            val getNotes = GetNotes(repository)
            val addNote = AddNote(repository)
            val deleteNote = DeleteNote(repository)

            val viewModel = NotesViewModel(getNotes, addNote, deleteNote)

            var currentScreen by remember { mutableStateOf("notes") }

            when (currentScreen) {
                "notes" -> NotesScreen(
                    viewModel = viewModel,
                    onAddClick = { currentScreen = "add" }
                )
                "add" -> AddNoteScreen(
                    viewModel = viewModel,
                    onNoteSaved = { currentScreen = "notes" }
                )
            }
        }
    }
}
