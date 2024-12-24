package org.muskan;

public class Main {
    public static void main(String[] args) {

        LogProcessor logObject = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));
        logObject.log(LogProcessor.DEBUG, "need to debug this");
//        logObject.log(LogProcessor.ERROR, "exception happens");
//        logObject.log(LogProcessor.INFO, "just for info");

    }
}