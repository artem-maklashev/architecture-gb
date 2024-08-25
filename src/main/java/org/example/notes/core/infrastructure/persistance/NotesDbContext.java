package org.example.notes.core.infrastructure.persistance;

import org.example.database.NotesDatabase;
import org.example.database.NotesRecord;
import org.example.notes.core.application.interfaces.NotesDatabaseContext;
import org.example.notes.core.domain.Note;
import org.example.notes.core.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {
    public NotesDbContext(Database db) {
        super(db);
    }

    @Override
    public void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    @Override
    public Collection<Note> getAllNotes() {
        Collection<Note> notes = new ArrayList<Note>();
        for (NotesRecord record : ((NotesDatabase)db).getNotesTable().getRecords()) {
            notes.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getContent(),
                    record.getCreationDate()
            ));
        }
        return notes;
    }
}
