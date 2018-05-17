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

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public interface GeneratorModString {
    /**
     * Splits the string with a space.
     * This returns a List compatible with the generator class.
     *
     * @param string The string to split.
     *
     * @return A {@code List} created from the string.
     */
    @NotNull
    static List<String> StringToList(@NotNull String string) {
        return StringToList(string, "(\\s)");
    }

    /**
     * Splits the string by a certain regex.
     * This returns a List compatible with the generator class.
     *
     * @param string The string to split.
     * @param regex  The regex to to split the string by.
     *
     * @return A {@code List} created from the string.
     */
    @NotNull
    static List<String> StringToList(@NotNull String string, @NotNull String regex) {
        return Arrays.asList(string.split(regex));
    }
}
