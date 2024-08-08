package org.example.seminar2.templatemethod;




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
        LogReader reader = new PoemReader(data);
        reader.setCurrentPosition(3);
        for (LogEntry entry : reader.readLogEntry()){
            System.out.println(entry.getMessage());
        }


    }
}
