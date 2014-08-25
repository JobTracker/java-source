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

package java.nio.file.attribute;

/**
 * File attributes associated with a file in a file system that supports
 * legacy "DOS" attributes.
 *
 * <p> The DOS attributes of a file are retrieved using a {@link
 * DosFileAttributeView} by invoking its {@link DosFileAttributeView#readAttributes
 * readAttributes} method.
 *
 * @since 1.7
 *
 * @see Attributes#readDosFileAttributes
 */

public interface DosFileAttributes
    extends BasicFileAttributes
{
    /**
     * Returns the value of the read-only attribute.
     *
     * <p> This attribute is often used as a simple access control mechanism
     * to prevent files from being deleted or updated. Whether the file system
     * or platform does any enforcement to prevent <em>read-only</em> files
     * from being updated is implementation specific.
     *
     * @return  the value of the read-only attribute
     */
    boolean isReadOnly();

    /**
     * Returns the value of the hidden attribute.
     *
     * <p> This attribute is often used to indicate if the file is visible to
     * users.
     *
     * @return  the value of the hidden attribute
     */
    boolean isHidden();

    /**
     * Returns the value of the archive attribute.
     *
     * <p> This attribute is typically used by backup programs.
     *
     * @return  the value of the archive attribute
     */
    boolean isArchive();

    /**
     * Returns the value of the system attribute.
     *
     * <p> This attribute is often used to indicate that the file is a component
     * of the operating system.
     *
     * @return  the value of the system attribute
     */
    boolean isSystem();
}
