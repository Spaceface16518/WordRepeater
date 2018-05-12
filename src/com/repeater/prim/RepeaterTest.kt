package com.repeater.prim

import org.junit.jupiter.api.*

internal class RepeaterTest {

    private var repeater: Repeater? = null

    @BeforeAll
    fun init() {
        repeater = Repeater()
    }

    @BeforeEach
    fun setUp() {

    }

    @Test
    @Tag("Class")
    @DisplayName("Default, full class test")
    fun testClass() {
        // Constructor not yet defined
    }

    @Test
    @Tag("flushStreams")
    @DisplayName("test flushStreams")
    fun testFlushStreams() {

    }

    @AfterEach
    fun tearDown() {
        repeater!!.flushStreams()
    }

    @AfterAll
    fun close() {

    }
}