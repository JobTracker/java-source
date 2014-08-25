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

import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.io.IOError;

/**
 * A simple visitor of files with default behavior to visit all files and to
 * re-throw I/O errors.
 *
 * <p> Methods in this class may be overridden subject to their general contract.
 *
 * @param   <T>     The type of reference to the files
 *
 * @since 1.7
 */

public class SimpleFileVisitor<T extends FileRef> implements FileVisitor<T> {
    /**
     * Initializes a new instance of this class.
     */
    protected SimpleFileVisitor() {
    }

    /**
     * Invoked for a directory before entries in the directory are visited.
     *
     * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
     * CONTINUE}.
     */
    @Override
    public FileVisitResult preVisitDirectory(T dir) {
        return FileVisitResult.CONTINUE;
    }

    /**
     * Invoked for a directory that could not be opened.
     *
     * <p> Unless overridden, this method throws {@link IOError} with the I/O
     * exception as cause.
     *
     * @throws  IOError
     *          with the I/O exception thrown when the attempt to open the
     *          directory failed
     */
    @Override
    public FileVisitResult preVisitDirectoryFailed(T dir, IOException exc) {
        throw new IOError(exc);
    }

    /**
     * Invoked for a file in a directory.
     *
     * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
     * CONTINUE}.
     */
    @Override
    public FileVisitResult visitFile(T file, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    /**
     * Invoked for a file when its basic file attributes could not be read.
     *
     * <p> Unless overridden, this method throws {@link IOError} with the I/O
     * exception as cause.
     *
     * @throws  IOError
     *          with the I/O exception thrown when the attempt to read the file
     *          attributes failed
     */
    @Override
    public FileVisitResult visitFileFailed(T file, IOException exc) {
        throw new IOError(exc);
    }

    /**
     * Invoked for a directory after entries in the directory, and all of their
     * descendants, have been visited.
     *
     * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
     * CONTINUE} if the directory iteration completes without an I/O exception;
     * otherwise this method throws {@link IOError} with the I/O exception as
     * cause.
     *
     * @throws  IOError
     *          if iteration of the directory completed prematurely due to an
     *          I/O error
     */
    @Override
    public FileVisitResult postVisitDirectory(T dir, IOException exc) {
        if (exc != null)
            throw new IOError(exc);
        return FileVisitResult.CONTINUE;
    }
}
