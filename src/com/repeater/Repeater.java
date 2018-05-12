package com.repeater;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Repeater {
    private static Runnable staticCloseHandler;
    private Stream stream;
    private List strings;
    private Runnable closeHandler;

    /**
     * Define an static event handler for the <code>close</code> method of the Stream interface.
     * Will be overridden by any instance event handler.
     *
     * @param action The action to be taken on <code>close</code>.
     */
    public static void setStaticCloseHandler(Consumer action) {
        staticCloseHandler = (Runnable) action;
    }

    /**
     * Clear the stream.
     * This is mainly for effective reuse of a single <code>Repeater</code> class.
     * Activates the <code>closeHandler</code> as well.
     */
    public void flushStreams() {
        stream.close();
    }

    /**
     * Clear the stream.
     * This is mainly for effective reuse of a single <code>Repeater</code> class.
     * Uses a parameter-specified, single use handler as well.
     *
     * @param handler A handler for this clear only.
     */
    public void flushStreams(Consumer<?> handler) {
        this.stream.onClose((Runnable) handler);
        stream.close();
        this.stream.onClose(closeHandler);
    }

    /**
     * Define an instance event handler for the <code>close</code> method of the Stream interface.
     *
     * @param action The action to be taken on <code>close</code>.
     */
    public void setCloseHandler(Consumer<?> action) {
        this.closeHandler = (Runnable) action;
        stream.onClose(this.closeHandler);
    }
}
