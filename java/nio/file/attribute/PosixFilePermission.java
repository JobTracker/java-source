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

import java.util.*;

/**
 * Defines the bits for use with the {@link PosixFileAttributes#permissions()
 * permissions} attribute.
 *
 * <p> The {@link PosixFileAttributes} class defines method methods for
 * manipulating {@link Set sets} of permissions.
 *
 * @since 1.7
 */

public enum PosixFilePermission {

    /**
     * Read permission, owner.
     */
    OWNER_READ,

    /**
     * Write permission, owner.
     */
    OWNER_WRITE,

    /**
     * Execute/search permission, owner.
     */
    OWNER_EXECUTE,

    /**
     * Read permission, group.
     */
    GROUP_READ,

    /**
     * Write permission, group.
     */
    GROUP_WRITE,

    /**
     * Execute/search permission, group.
     */
    GROUP_EXECUTE,

    /**
     * Read permission, others.
     */
    OTHERS_READ,

    /**
     * Write permission, others.
     */
    OTHERS_WRITE,

    /**
     * Execute/search permission, others.
     */
    OTHERS_EXECUTE;
}
