package com.example.noteappcompose.presentation.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.noteappcompose.domain.model.Note

@Composable
fun NotesScreen(
    viewModel: NotesViewModel,
    onAddClick: () -> Unit
) {
    val notes = viewModel.notes.collectAsState().value

    Column {
        LazyColumn {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    onDeleteClick = { viewModel.delete(note) }
                )
            }
        }

        FloatingActionButton(onClick = onAddClick) {
            Text("+")
        }
    }
}

