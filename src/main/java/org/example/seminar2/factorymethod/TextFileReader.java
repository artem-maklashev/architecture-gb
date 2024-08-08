package org.example.seminar2.factorymethod;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader extends LogReader {
    private List<String> lines;

    public TextFileReader() {

        this.lines = new ArrayList<>();
        loadFile();
    }

    // Загружаем файл и сохраняем строки в списке
    private void loadFile() {
        String filePath = "src/main/java/org/example/seminar2/factorymethod/sample.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getData() {
        return lines;
    }

    @Override
    public void setData(Object data) {
        if (data instanceof List) {
            this.lines = (List<String>) data;
        }
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        if (position == null || position < 0 || position >= lines.size()) {
            return new ArrayList<>();
        }
        return lines.subList(position, lines.size());
    }

    @Override
    protected LogEntry parseLogEntry(String entry) {
        return new LogEntry(entry);
    }
}
