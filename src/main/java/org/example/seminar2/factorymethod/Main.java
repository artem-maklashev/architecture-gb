package org.example.seminar2.factorymethod;



public class Main {
    public static String data = """
            У лукоморья дуб зелёный;
            Златая цепь на дубе том:
            И днём и ночью кот учёный
            Всё ходит по цепи кругом;
            Идёт направо — песнь заводит,
            Налево — сказку говорит.
            Там чудеса: там леший бродит,
            Русалка на ветвях сидит;
            """;
    public static void main(String[] args) {
        LogReader reader = new ConcreteReaderCreator().createLogReader(LogType.POEM, data);
        reader.setCurrentPosition(5);//начальную позицию можно задать при реализации LogReader
        for (LogEntry entry : reader.readLogEntry()){
            System.out.println(entry.getMessage());
        }

        LogReader reader2 = new TextFileReader();
        reader2.setCurrentPosition(1);
        System.out.println("\n______Пример чтения логов из файла_____");
        for (LogEntry entry : reader2.readLogEntry()){
            System.out.println(entry.getMessage());
        }

    }
}
