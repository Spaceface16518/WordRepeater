/*
 * Copyright 2018 Amrit Rathie
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.repeater.prim;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@DisplayName("Generator class tests")
class GeneratorTest {
    private List<String> list;
    private Generator<String> generator;
    private StringBuilder expected, actual;

    @BeforeEach
    void setUp() {
        list = getRand();
        generator = new Generator<>(list);
        expected = new StringBuilder();
        actual = new StringBuilder();
    }

    private synchronized static ArrayList<String> getRand() {
        ArrayList<String> builder = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
            builder.add(String.valueOf(rand.nextDouble() * 15));
        return builder;
    }

    @Test
    @DisplayName("Generator default constructor test")
    void defaultConstructorTest() {
        Generator generator = new Generator();
        Assertions.assertNotNull(generator);
    }

    @Test
    @DisplayName("StorageListConstruction test")
    void StorageListConstructionTest() {
        Assertions.assertNotNull(generator.storageList);
    }

    @Test
    @DisplayName("iterator method test")
    void iteratorTest() {
        list.iterator().forEachRemaining(actual::append);
        generator.iterator().forEachRemaining(expected::append);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("forEach method test")
    void forEachTest() {
        generator.forEach(actual::append);
        list.forEach(expected::append);
        Assertions.assertEquals(this.expected.toString(), this.actual.toString
                ());
    }

    @AfterEach
    void tearDown() {
        System.gc();
    }
}
