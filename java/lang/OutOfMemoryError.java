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
 * Thrown when the Java Virtual Machine cannot allocate an object
 * because it is out of memory, and no more memory could be made
 * available by the garbage collector.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class OutOfMemoryError extends VirtualMachineError {
    private static final long serialVersionUID = 8228564086184010517L;

    /**
     * Constructs an <code>OutOfMemoryError</code> with no detail message.
     */
    public OutOfMemoryError() {
        super();
    }

    /**
     * Constructs an <code>OutOfMemoryError</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public OutOfMemoryError(String s) {
        super(s);
    }
}
