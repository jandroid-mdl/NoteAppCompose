package com.example.noteappcompose.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.noteappcompose.model.Note
import com.example.noteappcompose.ui.components.NoteItem

@Composable
fun NotesScreen(
    notes: List<Note>,
    onAddNoteClicked: () -> Unit = {}
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
                NoteItem(note = note)
            }
        }
    }
}
