package com.repeater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratorTest {

    private Generator repeater;

    @BeforeEach
    void init() {
        repeater = new Generator("This is a test", ' ');
    }

    @Test
    @DisplayName("next method")
    void testNext() {
        assertEquals(repeater.getWord(repeater.getIndex() + 1), repeater.next());
    }

    @Test
    @DisplayName("Auto-increment method")
    void testIncrementIndex() {
        for (int i = 0; i < repeater.size(); i++) {
            assertEquals(i, repeater.getIndex());
            repeater.incrementIndex();
        }
    }

    @Test
    @DisplayName("Method to increment by an amount")
    void testIncrementIndexByAmount() {
        int rand = new Random().nextInt(repeater.size());
        repeater.incrementIndex(rand);
        assertEquals(rand, repeater.getIndex());
    }

    @Test
    void getIndex() {
        assertEquals(0, repeater.getIndex());
    }

    @Test
    void setIndex() {
        repeater.setIndex(1);
        assertEquals(1, repeater.getIndex());
    }

    @Test
    @Disabled
    void getWord() {
    }

    @Test
    @Disabled
    void size() {
    }

    @Test
    @Disabled
    void getCurrent() {
    }

    @Test
    @Disabled
    void forEach() {
    }
}