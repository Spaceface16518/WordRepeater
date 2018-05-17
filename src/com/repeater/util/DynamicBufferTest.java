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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@DisplayName("Dynamic Buffer class tests")
class DynamicBufferTest {
    private DynamicBuffer<?> buffer;
    private ByteArrayOutputStream out;
    private List<String> sample;

    @BeforeEach
    void setUp() throws IOException {
        buffer = new DynamicBuffer<String>(new ObjectOutputStream(out = new
                ByteArrayOutputStream()));
        sample = getRand();
    }

    private synchronized static List<String> getRand() {
        ArrayList<String> builder = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++)
            builder.add(String.valueOf(rand.nextDouble() * 15));
        return builder;
    }

    @Test
    @Disabled
    @DisplayName("Write method test")
    void writeTest() {
//        buffer.write(sample);
// TODO: fix or use the capture part of buffer.write()
    }

    @Test
    @Disabled
    @DisplayName("Flush method test")
    void flushTest() {
    }

    @Test
    @Disabled
    @DisplayName("Clean Buffer method test")
    void cleanBufferTest() {
    }

    @Test
    @Disabled
    @DisplayName("Set Output Stream method test")
    void setOutputStreamTest() {
    }

    @Test
    @Disabled
    @DisplayName("Dynamic test")
    void DynamicTest() {
    }
}