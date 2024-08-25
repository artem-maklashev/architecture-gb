package org.example.notes.core.application.interfaces;

import org.example.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

public interface Editor <T, TId>{
    boolean addNote(T note);
    boolean removeNote(T note);
    boolean editNote(T note);
    Collection<T> getAllNotes();
    Optional<T> getNote(int id);
}
