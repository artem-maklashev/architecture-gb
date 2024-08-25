package org.example.notes.core.presentation.queries.views;

import org.example.notes.core.application.interfaces.NotesPresenter;
import org.example.notes.core.domain.Note;

import java.util.Collection;

public interface Presenter extends NotesPresenter {
    @Override
    default void printAllNotes(Collection<Note> notes) { }
}
