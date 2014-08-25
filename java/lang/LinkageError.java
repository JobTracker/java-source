/*
 * Copyright 1995-2008 Sun Microsystems, Inc.  All rights reserved.
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

package java.lang;

/**
 * Subclasses of <code>LinkageError</code> indicate that a class has
 * some dependency on another class; however, the latter class has
 * incompatibly changed after the compilation of the former class.
 *
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 */
public
class LinkageError extends Error {
    private static final long serialVersionUID = 3579600108157160122L;

    /**
     * Constructs a <code>LinkageError</code> with no detail message.
     */
    public LinkageError() {
        super();
    }

    /**
     * Constructs a <code>LinkageError</code> with the specified detail
     * message.
     *
     * @param   s   the detail message.
     */
    public LinkageError(String s) {
        super(s);
    }
}
