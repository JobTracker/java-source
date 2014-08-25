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

package java.net;

import java.io.IOException;

/**
 * Thrown to indicate that a malformed URL has occurred. Either no
 * legal protocol could be found in a specification string or the
 * string could not be parsed.
 *
 * @author  Arthur van Hoff
 * @since   JDK1.0
 */
public class MalformedURLException extends IOException {
    private static final long serialVersionUID = -182787522200415866L;

    /**
     * Constructs a <code>MalformedURLException</code> with no detail message.
     */
    public MalformedURLException() {
    }

    /**
     * Constructs a <code>MalformedURLException</code> with the
     * specified detail message.
     *
     * @param   msg   the detail message.
     */
    public MalformedURLException(String msg) {
        super(msg);
    }
}