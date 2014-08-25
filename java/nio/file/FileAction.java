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

import java.io.IOException;

/**
 * An interface that is implemented by objects that operate on a file. An
 * implementation of this interface is provided to the {@link Files#withDirectory
 * withDirectory} utility method so that the file action is {@link #invoke
 * invoked} for all accepted entries in the directory, after which, the directory
 * is automatically closed.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we require to perform a task on all class files in a directory:
 * <pre>
 *     Path dir = ...
 *     Files.withDirectory(dir, "*.class", new FileAction&lt;Path&gt;() {
 *         public void invoke(Path entry) {
 *             :
 *         }
 *     });
 * </pre>
 *
 * @param   <T>     the type of file reference
 *
 * @since 1.7
 */

public interface FileAction<T extends FileRef> {
    /**
     * Invoked for a file.
     *
     * @param   file
     *          the file
     *
     * @throws  IOException
     *          if the block terminates due an uncaught I/O exception
     */
    void invoke(T file) throws IOException;
}
