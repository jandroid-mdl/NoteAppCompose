package com.example.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.noteappcompose.ui.NotesScreen
import com.example.noteappcompose.utils.sampleNotes
import com.example.noteappcompose.ui.theme.NoteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppComposeTheme {
                NotesScreen(
                    notes = sampleNotes,
                    onAddNoteClicked = {
                        // Aquí más adelante abriremos un formulario para agregar nota
                        println("Botón + presionado")
                    }
                )
            }
        }

    }
}
