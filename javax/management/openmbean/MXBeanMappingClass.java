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

package javax.management.openmbean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.management.NotCompliantMBeanException;

/**
 * Specifies the MXBean mapping to be used for this Java type.
 * @see MXBeanMapping
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented @Inherited
public @interface MXBeanMappingClass {
    /**
     * <p>The {@link MXBeanMapping} class to be used to map the
     * annotated type.  This class must have a public constructor with
     * a single argument of type {@link java.lang.reflect.Type}.  The
     * constructor will be called with the annotated type as an
     * argument.  See the {@code MXBeanMapping} documentation
     * for an example.</p>
     *
     * <p>If the {@code MXBeanMapping} cannot in fact handle that
     * type, the constructor should throw an {@link
     * OpenDataException}.  If the constructor throws this or any other
     * exception then an MXBean in which the annotated type appears is
     * invalid, and registering it in the MBean Server will produce a
     * {@link NotCompliantMBeanException}.
     */
    public Class<? extends MXBeanMapping> value();
}
