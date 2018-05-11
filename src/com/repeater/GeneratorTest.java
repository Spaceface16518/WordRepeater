package com.repeater;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    private Generator repeater;

    @Test
    @Tag("Default")
    void testDefault() {
        repeater = new Generator("This is a test", ' ');
        repeater.forEach(System.out::println);
    }

}