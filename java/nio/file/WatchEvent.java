/*
 * Copyright 2007-2009 Sun Microsystems, Inc.  All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.nio.file;

/**
 * An event or a repeated event for an object that is registered with a {@link
 * WatchService}.
 *
 * <p> An event is classified by its {@link #kind() kind} and has a {@link
 * #count() count} to indicate the number of times that the event has been
 * observed. This allows for efficient representation of repeated events. The
 * {@link #context() context} method returns any context associated with
 * the event. In the case of a repeated event then the context is the same for
 * all events.
 *
 * <p> Watch events are immutable and safe for use by multiple concurrent
 * threads.
 *
 * @param   <T>     The type of the context object associated with the event
 *
 * @since 1.7
 */

public abstract class WatchEvent<T> {

    /**
     * An event kind, for the purposes of identification.
     *
     * @since 1.7
     * @see StandardWatchEventKind
     */
    public static interface Kind<T> {
        /**
         * Returns the name of the event kind.
         */
        String name();

        /**
         * Returns the type of the {@link WatchEvent#context context} value.
         */
        Class<T> type();
    }

    /**
     * Initializes a new instance of this class.
     */
    protected WatchEvent() { }

    /**
     * An event modifier that qualifies how a {@link Watchable} is registered
     * with a {@link WatchService}.
     *
     * <p> This release does not define any <em>standard</em> modifiers.
     *
     * @since 1.7
     * @see Watchable#register
     */
    public static interface Modifier {
        /**
         * Returns the name of the modifier.
         */
        String name();
    }

    /**
     * Returns the event kind.
     *
     * @return  the event kind
     */
    public abstract Kind<T> kind();

    /**
     * Returns the event count. If the event count is greater than {@code 1}
     * then this is a repeated event.
     *
     * @return  the event count
     */
    public abstract int count();

    /**
     * Returns the context for the event.
     *
     * <p> In the case of {@link StandardWatchEventKind#ENTRY_CREATE ENTRY_CREATE},
     * {@link StandardWatchEventKind#ENTRY_DELETE ENTRY_DELETE}, and {@link
     * StandardWatchEventKind#ENTRY_MODIFY ENTRY_MODIFY} events the context is
     * a {@code Path} that is the {@link Path#relativize relative} path between
     * the directory registered with the watch service, and the entry that is
     * created, deleted, or modified.
     *
     * @return  the event context; may be {@code null}
     */
    public abstract T context();
}