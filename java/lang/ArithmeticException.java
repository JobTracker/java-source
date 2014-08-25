/*
 * Copyright 1994-2008 Sun Microsystems, Inc.  All rights reserved.
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
 * Thrown when an exceptional arithmetic condition has occurred. For
 * example, an integer "divide by zero" throws an
 * instance of this class.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class ArithmeticException extends RuntimeException {
    private static final long serialVersionUID = 2256477558314496007L;

    /**
     * Constructs an <code>ArithmeticException</code> with no detail
     * message.
     */
    public ArithmeticException() {
        super();
    }

    /**
     * Constructs an <code>ArithmeticException</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public ArithmeticException(String s) {
        super(s);
    }
}
