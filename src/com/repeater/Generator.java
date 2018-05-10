package com.repeater;

import java.util.ArrayList;
import java.util.Arrays;

public class Generator {
    private ArrayList<String> words;
    private int next;
    private ArrayList<String> backup;

    public Generator() {
        words = new ArrayList<>();
    }

    public Generator(String words, char separator) {
        this.words.addAll(Arrays.asList(words.split(String.valueOf(separator))));
        this.next = 0;
    }

    public String next() {
        incrementIndex();
        return words.get(next);
    }

    protected void incrementIndex() {
        next += 1;
    }

    protected void incrementIndex(int amount) {
        next += amount;
    }

    int getIndex() {
        return next;
    }

    void setIndex(int value) {
        if (value <= words.size()) {
            this.next = value;
            for (int i = backup.size(); i <= value; i++) words.remove(i);
        }

    }
}
