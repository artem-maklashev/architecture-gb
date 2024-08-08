package org.example.seminar2.factorymethod;

public class ConcreteReaderCreator extends BaseLogReaderCreator{
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {

        return switch (logType){
            case TEXT -> new TextFileReader();
            case DATABASE -> new DataBaseReader();
            case SYSTEM -> new OSLogEventReader();
            case POEM -> new PoemReader();
        };
    }
}
