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

import java.io.IOException;

/**
 * A file store attribute view that supports reading of space attributes.
 *
 * <p> Where dynamic access to file attributes is required, the attributes
 * supported by this attribute view have the following names and types:
 * <blockquote>
 * <table border="1" cellpadding="8">
 *   <tr>
 *     <th> Name </th>
 *     <th> Type </th>
 *   </tr>
 *  <tr>
 *     <td> "totalSpace" </td>
 *     <td> {@link Long} </td>
 *   </tr>
 *  <tr>
 *     <td> "usableSpace" </td>
 *     <td> {@link Long} </td>
 *   </tr>
 *  <tr>
 *     <td> "unallocatedSpace" </td>
 *     <td> {@link Long} </td>
 *   </tr>
 * </table>
 * </blockquote>
 * <p> The {@link #getAttribute getAttribute} or {@link #readAttributes
 * readAttributes(String,String[])} methods may be used to read any of these
 * attributes as if by invoking the {@link #readAttributes readAttributes()}
 * method.
 *
 * @since 1.7
 */

public interface FileStoreSpaceAttributeView
    extends FileStoreAttributeView
{
    /**
     * Returns the name of the attribute view. Attribute views of this type
     * have the name {@code "space"}.
     */
    @Override
    String name();

    /**
     * Reads the disk space attributes as a bulk operation.
     *
     * <p> It is file system specific if all attributes are read as an
     * atomic operation with respect to other file system operations.
     *
     * @return  The disk space attributes
     *
     * @throws  IOException
     *          If an I/O error occurs
     */
    FileStoreSpaceAttributes readAttributes() throws IOException;
}
