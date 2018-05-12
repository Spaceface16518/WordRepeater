package com.repeater.prim;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    @Test
    @Tag("Default")
    void testDefault() {
        Generator repeater = new Generator("This is a test", ' ');
        repeater.forEach(System.out::println);
    }
}