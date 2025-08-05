package com.example.noteappcompose.presentation.addnote


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteappcompose.domain.model.Note
import com.example.noteappcompose.presentation.notes.NotesViewModel

@Composable
fun AddNoteScreen(
    viewModel: NotesViewModel,
    onNoteSaved: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Contenido") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (title.isNotBlank() || content.isNotBlank()) {
                val note = Note(
                    id = generateRandomId(),
                    title = title,
                    content = content
                )
                viewModel.add(note)
                onNoteSaved()
            }
        }) {
            Text("Guardar")
        }
    }
}

fun generateRandomId(): Int {
    return (0..999999).random()
}

