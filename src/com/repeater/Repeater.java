package com.repeater;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Repeater {
    private Stream stream;
    private List strings;

    public void flushStreams() {
        stream.close();
    }


    public void closeHandler(Consumer action) {
        stream.onClose((Runnable) action);
    }
}
