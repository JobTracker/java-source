/*
 * Copyright 1999-2003 Sun Microsystems, Inc.  All rights reserved.
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

package javax.management;


/**
 * An exception occurred during the introspection of an MBean.
 *
 * @since 1.5
 */
public class IntrospectionException extends OperationsException   {

    /* Serial version */
    private static final long serialVersionUID = 1054516935875481725L;

    /**
     * Default constructor.
     */
    public IntrospectionException() {
        super();
    }

    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message the detail message.
     */
    public IntrospectionException(String message) {
        super(message);
    }
}
