package org.example.notes.core.presentation.queries.views;

import org.example.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements Presenter {
    @Override
    public void printAllNotes(Collection<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
