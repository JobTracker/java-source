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

/**
 * <p>Specifies the MXBean mapping factory to be used for Java types
 * in an MXBean interface, or in all MXBean interfaces in a package.</p>
 *
 * <p>Applying a mapping factory to all Java types in an MXBean interface
 * looks like this:</p>
 *
 * <pre>
 * {@literal @MXBeanMappingFactoryClass}(MyLinkedListMappingFactory.class)
 * public interface SomethingMXBean {
 *     public MyLinkedList getSomething();
 * }
 * </pre>
 *
 * <p>Applying a mapping factory to all Java types in all MXBean interfaces
 * in a package, say {@code com.example.mxbeans}, looks like this.  In the
 * package source directory, create a file called {@code package-info.java}
 * with these contents:</p>
 *
 * <pre>
 * {@literal @MXBeanMappingFactoryClass}(MyLinkedListMappingFactory.class)
 * package com.example.mxbeans;
 * </pre>
 *
 * @see MXBeanMappingFactory
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PACKAGE})
@Documented @Inherited
public @interface MXBeanMappingFactoryClass {
    /**
     * <p>The {@link MXBeanMappingFactory} class to be used to map
     * types in the annotated interface or package.  This class must
     * have a public constructor with no arguments.  See the {@code
     * MXBeanMappingFactory} documentation for an example.</p>
     */
    public Class<? extends MXBeanMappingFactory> value();
}
