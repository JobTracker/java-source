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
 * Thrown when a stack overflow occurs because an application
 * recurses too deeply.
 *
 * @author unascribed
 * @since   JDK1.0
 */
public
class StackOverflowError extends VirtualMachineError {
    private static final long serialVersionUID = 8609175038441759607L;

    /**
     * Constructs a <code>StackOverflowError</code> with no detail message.
     */
    public StackOverflowError() {
        super();
    }

    /**
     * Constructs a <code>StackOverflowError</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public StackOverflowError(String s) {
        super(s);
    }
}
