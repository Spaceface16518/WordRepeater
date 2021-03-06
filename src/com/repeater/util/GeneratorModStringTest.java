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

package com.repeater.util;

import com.repeater.prim.Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeneratorModStringTest {

    private static final String testString = "This is a test";
    private static final String testRegex = "(\\s)";
    private static final String expected = "Thisisatest";

    @Test
    void stringToList() {
        Generator<String> generator = new Generator<>(GeneratorModString.StringToList(testString, testRegex));
        StringBuilder builder = new StringBuilder();
        generator.forEach(builder::append);
        String fin = builder.toString();
        Assertions.assertEquals(expected, fin);
    }

    @Test
    void stringToListSpace() {
        Generator<String> generator = new Generator<>(GeneratorModString.StringToList(testString));
        StringBuilder builder = new StringBuilder();
        generator.forEach(builder::append);
        String fin = builder.toString();
        Assertions.assertEquals(expected, fin);
    }
}