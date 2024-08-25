package org.example.notes.core.application.interfaces;

import org.example.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {
    Collection<Note> getAllNotes();
    boolean saveChanges();
}
