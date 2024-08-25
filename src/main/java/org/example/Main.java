package org.example;

import org.example.database.NotesDatabase;
import org.example.notes.core.application.ConcreteNoteEditor;
import org.example.notes.core.infrastructure.persistance.NotesDbContext;
import org.example.notes.core.presentation.queries.controllers.NotesController;
import org.example.notes.core.presentation.queries.views.NotesConsolePresenter;

public class Main {
    public static void main(String[] args) {

        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));
        controller.routeGetAllNotes();
    }
}
