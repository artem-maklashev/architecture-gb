package org.example.notes.core.presentation.queries.controllers;

import org.example.notes.core.application.interfaces.NoteEditor;
import org.example.notes.core.domain.Note;

public class NotesController extends Controller {
    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }
    public void routeAddNote(Note note) {
        this.noteEditor.addNote(note);
    }
    public void routeRemoveNote(Note note) {
        this.noteEditor.removeNote(note);
    }
    public void routeGetAllNotes() {
        this.noteEditor.printAll();
    }

}
