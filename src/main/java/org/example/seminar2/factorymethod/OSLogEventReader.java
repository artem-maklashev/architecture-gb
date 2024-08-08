package org.example.seminar2.factorymethod;

public class OSLogEventReader extends LogReader{
    @Override
    public Object getData() {
        return null;
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String entry) {
        return null;
    }
}
