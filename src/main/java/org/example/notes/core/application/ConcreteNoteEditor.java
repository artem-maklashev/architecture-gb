package org.example.notes.core.application;

import org.example.notes.core.application.interfaces.NoteEditor;
import org.example.notes.core.application.interfaces.NotesDatabaseContext;
import org.example.notes.core.application.interfaces.NotesPresenter;
import org.example.notes.core.domain.Note;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext databaseContext;
    private final NotesPresenter presenter;

    public ConcreteNoteEditor(NotesDatabaseContext databaseContext, NotesPresenter presenter) {
        this.databaseContext = databaseContext;
        this.presenter = presenter;
    }

    @Override
    public void printAll() {
        presenter.printAllNotes(getAllNotes());
    }

    @Override
    public boolean addNote(Note note) {
        databaseContext.getAllNotes().add(note);
        return databaseContext.saveChanges();
    }

    @Override
    public boolean removeNote(Note note) {
        databaseContext.getAllNotes().remove(note);
        return databaseContext.saveChanges();
    }

    @Override
    public boolean editNote(Note note) {
        if (note == null) {
            return false;
        }
        Optional<Note> oldNote = getNote(note.getId());
        if (oldNote.isPresent()) {
            oldNote.get().setTitle(note.getTitle());
            oldNote.get().setContent(note.getContent());
            oldNote.get().setUpdateDate(note.getUpdateDate());
            return databaseContext.saveChanges();
        }
        return false;
    }

    @Override
    public Collection<Note> getAllNotes() {
        return databaseContext.getAllNotes();
    }

    @Override
    public Optional<Note> getNote(int id) {
        return databaseContext.getAllNotes().stream().filter(note -> note.getId() == id).findFirst();
    }


}
