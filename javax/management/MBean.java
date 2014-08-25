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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Indicates that the annotated class is a Standard MBean.  A Standard
 * MBean class can be defined as in this example:</p>
 *
 * <pre>
 * {@code @MBean}
 * public class Configuration {
 *     {@link ManagedAttribute @ManagedAttribute}
 *     public int getCacheSize() {...}
 *     {@code @ManagedAttribute}
 *     public void setCacheSize(int size);
 *
 *     {@code @ManagedAttribute}
 *     public long getLastChangedTime();
 *
 *     {@link ManagedOperation @ManagedOperation}
 *     public void save();
 * }
 * </pre>
 *
 * <p>The class must be public.  Public methods within the class can be
 * annotated with {@code @ManagedOperation} to indicate that they are
 * MBean operations.  Public getter and setter methods within the class
 * can be annotated with {@code @ManagedAttribute} to indicate that they define
 * MBean attributes.</p>
 *
 * <p>If the MBean is to be an MXBean rather than a Standard MBean, then
 * the {@link MXBean @MXBean} annotation must be used instead of
 * {@code @MBean}.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MBean {
}
