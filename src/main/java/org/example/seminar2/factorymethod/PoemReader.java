package org.example.seminar2.factorymethod;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoemReader extends LogReader {

    private String data; //данные для чтения

    public PoemReader() {
    }

    public PoemReader(String data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data.toString();
    }


    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(data);
        List<String> lines = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if (counter >= position) {
                String line = scanner.nextLine();
                lines.add(line);
            } else {
                scanner.nextLine(); //переходим к следующему логу
            }
        }
        return lines;
    }

    @Override
    protected LogEntry parseLogEntry(String entry) {
        return new LogEntry(entry);
    }


}
