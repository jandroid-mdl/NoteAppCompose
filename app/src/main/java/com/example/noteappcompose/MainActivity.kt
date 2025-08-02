package com.example.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.noteappcompose.domain.model.Note
import com.example.noteappcompose.presentation.addnote.AddNoteScreen
import com.example.noteappcompose.presentation.notes.NotesScreen
import com.example.noteappcompose.ui.Screen
import com.example.noteappcompose.utils.sampleNotes
import com.example.noteappcompose.ui.theme.NoteAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppComposeTheme {
                val notes = remember { mutableStateListOf<Note>() }
                var currentScreen by remember { mutableStateOf(Screen.Notes) }

                if (notes.isEmpty()) {
                    notes.addAll(sampleNotes)
                }

                when (currentScreen) {
                    Screen.Notes -> NotesScreen(
                        notes = notes,
                        onAddNoteClicked = {
                            currentScreen = Screen.AddNote
                        },
                        onDeleteNoteClicked = { noteToDelete ->
                            notes.remove(noteToDelete)
                        }
                    )
                    Screen.AddNote -> AddNoteScreen(
                        onSaveNote = { title, content ->
                            notes.add(
                                Note(
                                    id = notes.size + 1,
                                    title = title,
                                    content = content
                                )
                            )
                            currentScreen = Screen.Notes
                        }
                    )
                }
            }
        }



    }
}
