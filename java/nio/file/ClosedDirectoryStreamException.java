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
 * Unchecked exception thrown when an attempt is made to invoke an operation on
 * a directory stream that is closed.
 *
 * @since 1.7
 */

public class ClosedDirectoryStreamException
    extends IllegalStateException
{
    static final long serialVersionUID = 4228386650900895400L;

    /**
     * Constructs an instance of this class.
     */
    public ClosedDirectoryStreamException() {
    }
}
