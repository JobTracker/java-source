/*
 * Copyright 2007-2008 Sun Microsystems, Inc.  All rights reserved.
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

package javax.management;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Indicates that a method in an MBean class defines an MBean attribute.
 * This annotation must be applied to a public method of a public class
 * that is itself annotated with an {@link MBean @MBean} or
 * {@link MXBean @MXBean} annotation, or inherits such an annotation from
 * a superclass.</p>
 *
 * <p>The annotated method must be a getter or setter.  In other words,
 * it must look like one of the following...</p>
 *
 * <pre>
 * <i>T</i> get<i>Foo</i>()
 * void set<i>Foo</i>(<i>T</i> param)
 * </pre>
 *
 * <p>...where <i>{@code T}</i> is any type and <i>{@code Foo}</i> is the
 * name of the attribute.  For any attribute <i>{@code Foo}</i>, if only
 * a {@code get}<i>{@code Foo}</i> method has a {@code ManagedAttribute}
 * annotation, then <i>{@code Foo}</i> is a read-only attribute.  If only
 * a {@code set}<i>{@code Foo}</i> method has a {@code ManagedAttribute}
 * annotation, then <i>{@code Foo}</i> is a write-only attribute.  If
 * both {@code get}<i>{@code Foo}</i> and {@code set}<i>{@code Foo}</i>
 * methods have the annotation, then <i>{@code Foo}</i> is a read-write
 * attribute.  In this last case, the type <i>{@code T}</i> must be the
 * same in both methods.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ManagedAttribute {
}
