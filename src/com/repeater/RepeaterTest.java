package com.repeater;

import org.junit.jupiter.api.*;

class RepeaterTest {

    private Repeater repeater;

    @BeforeAll
    void init() {
        repeater = new Repeater();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    @Tag("Class")
    @DisplayName("Default, full class test")
    void testClass() {

    }

    @AfterEach
    void tearDown() {
        repeater.flushStreams();
    }

    @AfterAll
    void close() {

    }
}