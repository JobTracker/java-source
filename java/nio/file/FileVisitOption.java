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
 * Defines the file tree traversal options.
 *
 * @since 1.7
 *
 * @see Files#walkFileTree
 */

public enum FileVisitOption {
    /**
     * Follow symbolic links.
     */
    FOLLOW_LINKS,
    /**
     * Detect cycles in the file tree.
     */
    DETECT_CYCLES;
}
