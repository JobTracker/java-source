/*
 * Copyright 2007-2008 Sun Microsystems, Inc.  All rights reserved.
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

package javax.management.event;

import javax.management.JMException;

/**
 * Thrown if an event client identifier is unknown.
 */
public class EventClientNotFoundException extends JMException {

    /* Serial version */
    private static final long serialVersionUID = -3910667345840643089L;

    /**
     *Constructs a {@code ClientNotFoundException} without a detail message.
     */
    public EventClientNotFoundException() {
        super();
    }

    /**
     * Constructs a {@code ClientNotFoundException} with the specified detail message.
     * @param message The message.
     */
    public EventClientNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a {@code ClientNotFoundException} with the specified detail message
     * and cause.
     *
     * @param message The message.
     * @param cause The cause (which is saved for later retrieval by the
     * {@code Throwable.getCause()} method). A null value is permitted, and indicates
     * that the cause is non-existent or unknown.
     */
    public EventClientNotFoundException(String message, Throwable cause) {
        super(message);

        initCause(cause);
    }

    /**
     * Constructs a new exception with the specified cause.
     * @param cause The cause (which is saved for later retrieval by the
     * {@code Throwable.getCause()} method). A null value is permitted, and indicates
     * that the cause is non-existent or unknown.
     */
    public EventClientNotFoundException(Throwable cause) {
        super();

        initCause(cause);
    }
}
