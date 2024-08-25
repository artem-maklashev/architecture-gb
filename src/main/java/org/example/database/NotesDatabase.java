package org.example.database;

import org.example.notes.core.infrastructure.persistance.Database;

public class NotesDatabase implements Database {
    private NotesTable notesTable = new NotesTable();

    public NotesTable getNotesTable() {
        if (notesTable == null) {
            notesTable = new NotesTable();
        }
        return notesTable;
    }
}
