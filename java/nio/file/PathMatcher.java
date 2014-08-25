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
 * An interface that is implemented by objects that perform match operations on
 * paths.
 *
 * @since 1.7
 *
 * @see FileSystem#getPathMatcher
 * @see Path#newDirectoryStream(String)
 */

public interface PathMatcher {
    /**
     * Tells if given path matches this matcher's pattern.
     *
     * @param   path
     *          the path to match
     *
     * @return  {@code true} if, and only if, the path matches this
     *          matcher's pattern
     */
    boolean matches(Path path);
}
