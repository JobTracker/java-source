/*
 * Copyright 2005-2009 Sun Microsystems, Inc.  All rights reserved.
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

package javax.lang.model.element;

/**
 * Represents a package program element.  Provides access to information
 * about the package and its members.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see javax.lang.model.util.Elements#getPackageOf
 * @since 1.6
 */
public interface PackageElement extends Element, QualifiedNameable {

    /**
     * Returns the fully qualified name of this package.
     * This is also known as the package's <i>canonical</i> name.
     *
     * @return the fully qualified name of this package, or an
     * empty name if this is an unnamed package
     * @jls3 6.7 Fully Qualified Names and Canonical Names
     */
    Name getQualifiedName();

    /**
     * Returns {@code true} is this is an unnamed package and {@code
     * false} otherwise.
     *
     * @return {@code true} is this is an unnamed package and {@code
     * false} otherwise
     * @jls3 7.4.2 Unnamed Packages
     */
    boolean isUnnamed();
}
