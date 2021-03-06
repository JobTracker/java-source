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

import javax.management.openmbean.CompositeData;


/**
 * Represents "user defined" exceptions thrown by MBean methods
 * in the agent. It "wraps" the actual "user defined" exception thrown.
 * This exception will be built by the MBeanServer when a call to an
 * MBean method results in an unknown exception.
 *
 * @since 1.5
 */
public class MBeanException extends JMException   {


    /* Serial version */
    private static final long serialVersionUID = 4066342430588744142L;

    /**
     * @serial This field is null for instances of this class that were
     * produced by its public constructors.  It is non-null for instances
     * of this class that represent serialized instances of {@link
     * GenericMBeanException}.
     *
     * @see GenericMBeanException#getErrorCode()
     */
    final String errorCode;

    /**
     * @serial This field is null for instances of this class that were
     * produced by its public constructors.  It may be non-null for instances
     * of this class that represent serialized instances of {@link
     * GenericMBeanException}.
     *
     * @see GenericMBeanException#getUserData()
     */
    final CompositeData userData;

    /**
     * @serial Encapsulated {@link Exception}
     */
    private java.lang.Exception exception ;


    /**
     * Creates an <CODE>MBeanException</CODE> that wraps the actual <CODE>java.lang.Exception</CODE>.
     *
     * @param e the wrapped exception.
     */
    public MBeanException(Exception e) {
        this(null, null, null, e);
    }

    /**
     * Creates an <CODE>MBeanException</CODE> that wraps the actual <CODE>java.lang.Exception</CODE> with
     * a detail message.
     *
     * @param e the wrapped exception.
     * @param message the detail message.
     */
    public MBeanException(Exception e, String message) {
        this(message, null, null, e);
    }

    MBeanException(
            String message, String errorCode, CompositeData userData, Throwable cause) {
        super(message);
        initCause(cause);
        if (cause instanceof Exception)
            this.exception = (Exception) cause;
        this.errorCode = errorCode;
        this.userData = userData;
    }

    /**
     * Return the actual {@link Exception} thrown.
     *
     * @return the wrapped exception.
     */
    public Exception getTargetException()  {
        return exception;
    }

    /**
     * This method is invoked when deserializing instances of this class.
     * If the {@code errorCode} field of the deserialized instance is not
     * null, this method returns an instance of {@link GenericMBeanException}
     * instead.  Otherwise it returns {@code this}.
     * @return {@code this}, or a {@code GenericMBeanException}.
     */
    Object readResolve() {
        if (errorCode == null) {
            // serial compatibility: earlier versions did not set
            // Throwable.cause because they overrode getCause().
            if (getCause() == null && exception != null)
                initCause(exception);
            return this;
        } else {
            Throwable t = new GenericMBeanException(
                    getMessage(), errorCode, userData, getCause());
            t.setStackTrace(this.getStackTrace());
            return t;
        }
    }
}
