package org.example.seminar2.templatemethod;

import org.example.seminar2.templatemethod.LogEntry;

import java.util.ArrayList;
import java.util.List;


public abstract class LogReader {

    private int currentPosition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Iterable<LogEntry> readLogEntry() {
        List<LogEntry> entries = new ArrayList<>();
        for (String entry : readEntries(currentPosition)) {
            LogEntry logEntry = parseLogEntry(entry);
            entries.add(logEntry);
        }
        return entries;
    }

    public abstract Object getData();

    public abstract void setData(Object data);

    protected abstract Iterable<String> readEntries(Integer position);

    protected abstract LogEntry parseLogEntry(String entry);

}

