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
 * <p>Indicates that a method in an MBean class defines an MBean operation.
 * This annotation can be applied to:</p>
 *
 * <ul>
 * <li>A public method of a public class
 * that is itself annotated with an {@link MBean @MBean} or
 * {@link MXBean @MXBean} annotation, or inherits such an annotation from
 * a superclass.</li>
 * <li>A method of an MBean or MXBean interface.
 * </ul>
 *
 * <p>Every method in an MBean or MXBean interface defines an MBean
 * operation even without this annotation, but the annotation allows
 * you to specify the impact of the operation:</p>
 *
 * <pre>
 * public interface ConfigurationMBean {
 *     {@code @ManagedOperation}(impact = {@link Impact#ACTION Impact.ACTION})
 *     public void save();
 *     ...
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ManagedOperation {
    /**
     * <p>The impact of this operation, as shown by
     * {@link MBeanOperationInfo#getImpact()}.
     */
    Impact impact() default Impact.UNKNOWN;
}
