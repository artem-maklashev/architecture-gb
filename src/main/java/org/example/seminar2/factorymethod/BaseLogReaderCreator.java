package org.example.seminar2.factorymethod;

public abstract class BaseLogReaderCreator {
    protected abstract LogReader createLogReaderInstance(LogType logType);
    protected LogReader createLogReader(LogType logType, Object log) {
        LogReader logReader = createLogReaderInstance(logType);
        logReader.setData(log);
        return logReader;
    }
}
