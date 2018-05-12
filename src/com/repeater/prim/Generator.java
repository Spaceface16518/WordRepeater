package com.repeater.prim;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class Generator {
    private ArrayList<String> words;
    private int next;
    private ArrayList<String> backup;

    public Generator() {
        words = new ArrayList<>();
    }

    public Generator(@NotNull String string, char separator) {
        words = new ArrayList<>();
        words.addAll(Arrays.asList(string.split(String.valueOf(separator))));
        this.next = 0;
    }

    public String next() {
        incrementIndex();
        String var = words.get(next - 1);
        backup.add(var);
        return var;
    }

    public void incrementIndex() {
        next += 1;
    }

    public void incrementIndex(int amount) {
        next += amount;
    }

    public int getIndex() {
        return next;
    }

    protected void setIndex(int value) {
        if (value <= words.size()) {
            this.next = value;
            for (int i = backup.size(); i <= value; i++) words.remove(i);
        }
    }

    public String getWord(int index) {
        return words.get(index);
    }

    public int size() {
        return words.size();
    }

    public String getCurrent() {
        return this.getWord(next);
    }

    public void forEach(Consumer<? super String> action) {
        words.forEach(action);
    }
}
