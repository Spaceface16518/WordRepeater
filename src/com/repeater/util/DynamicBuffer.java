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

import java.io.Flushable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DynamicBuffer<T> implements Flushable, Backupable {
    private static final int minLimit = 10;
    private static final int maxLimit = 30;
    private static final int limitSpacer = 10;
    private OutputStream outputStream;
    private List<T> buffer;
    // TODO: replace current backup system with separate class
    // Also don't make test for the backup system. Or do? Maybe ask an actual
    // developer?
    private List<List<T>> backup;
    private boolean backupEnabled = false;
    private int limit;

    public DynamicBuffer() {
        buffer = new ArrayList<>();
    }

    DynamicBuffer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public DynamicBuffer(OutputStream outputStream, int minBufferSize) {
        buffer = new ArrayList<>(minBufferSize);
        this.outputStream = outputStream;
    }

    public synchronized void write(List<? extends T> elements)
            throws IOException {
        int sizeAfterPush = elements.size() + buffer.size();
        if (sizeAfterPush >= limit && sizeAfterPush >= minLimit) flush();
        respaceBuffer();
        buffer.addAll(elements);
        if (limit <= buffer.size()) respaceBuffer();
    }

    /**
     * Flush the buffer.
     * This empties the buffer into the output stream.
     *
     * @throws IOException if flush of output stream fails.
     */
    @Override
    public void flush() throws IOException {
        this.buffer.clear();
        this.outputStream.flush();
    }

    private void respaceBuffer() {
        limit = buffer.size() + limitSpacer;
        if (limit > maxLimit) {
            limit = maxLimit;
        }
    }

    /**
     * This cleans out the buffer settings and resets it to a normal state.
     * Use this if the buffer's size or settings get out of hand (This happens sometimes with dynamic objects).
     * THIS DOES NOT RESET THE BUFFER'S CONTENTS; IT WILL NOT WIPE THE BUFFER ITSELF!
     */
    public void cleanBuffer() {
        limit = minLimit + limitSpacer;
        // More resets to come.
    }

    @Override
    public void cleanBackup() {
        this.backup.clear();
    }

    @Override
    public void cleanBackup(int... locations) {
        for (int location : locations) {
            this.backup.remove(location);
        }
    }

    @Override
    public void cleanBackup(int lookBack) {
        int last = backup.size() - 1;
        int[] locations = new int[lookBack];
        for (int i = 0; i < locations.length; i++) locations[i] = last - i;
        this.cleanBackup(locations);
    }

    /**
     * Backs up the buffer to the backup array.
     */
    @Override
    public synchronized void backup() {
        ArrayList<T> buf = new ArrayList<>(buffer); // Localize the array for security.
        if (this.backupEnabled) backup.add(buf);
    }

    @Override
    public void backup(int numOfBackups) {

    }

    /**
     * Change the output stream.
     * This flushes the buffer.
     *
     * @param outputStream The new output stream.
     */
    public void setOutputStream(ObjectOutputStream outputStream) {
        try {
            this.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.outputStream = outputStream;
    }

    /**
     * Enables the backup of buffer.
     * Backing up the buffer makes it significatly slower, but enables the buffer to be rewinded.
     */
    public void enableBackup() {
        backup = new ArrayList<>();
        backupEnabled = true;
    }

    /**
     * Disables the backup buffer.
     * This also clears the backup.
     */
    public void disableBackup() {
        backup.clear();
        backupEnabled = false;
    }

    public void reset() {

    }

    public void rewind() {
        this.buffer.clear();
        this.buffer.addAll(backup.get(backup.size() - 1));
    }

    public void rewind(int lookBack) {
        this.buffer.clear();
        this.buffer.addAll(backup.get(lookBack));
    }
}
