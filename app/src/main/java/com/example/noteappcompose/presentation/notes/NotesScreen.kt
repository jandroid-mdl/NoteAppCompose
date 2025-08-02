package com.example.noteappcompose.presentation.notes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.noteappcompose.domain.model.Note

@Composable
fun NotesScreen(
    notes: List<Note>,
    onAddNoteClicked: () -> Unit = {},
    onDeleteNoteClicked: (Note) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNoteClicked) {
                Text("+")
            }
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(notes) { note ->
                NoteItem(note = note, onDeleteClick = onDeleteNoteClicked)
            }
        }
    }
}
