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
 * Defines access modes used to test the accessibility of a file.
 *
 * @since 1.7
 *
 * @see FileRef#checkAccess
 */

public enum AccessMode {
    /**
     * Test read access.
     */
    READ,
    /**
     * Test write access.
     */
    WRITE,
    /**
     * Test execute access.
     */
    EXECUTE;
}
