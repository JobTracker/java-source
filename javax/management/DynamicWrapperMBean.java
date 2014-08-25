/*
 * Copyright 2005-2008 Sun Microsystems, Inc.  All rights reserved.
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

/**
 * <p>An MBean can implement this interface to affect how the MBeanServer's
 * {@link MBeanServer#getClassLoaderFor getClassLoaderFor} and
 * {@link MBeanServer#isInstanceOf isInstanceOf} methods behave.
 * If these methods should refer to a wrapped object rather than the
 * MBean object itself, then the {@link #getWrappedObject} method should
 * return that wrapped object.</p>
 *
 * @see MBeanServer#getClassLoaderFor
 * @see MBeanServer#isInstanceOf
 */
public interface DynamicWrapperMBean extends DynamicMBean {
    /**
     * <p>The resource corresponding to this MBean.  This is the object whose
     * class name should be reflected by the MBean's
     * {@link MBeanServer#getMBeanInfo getMBeanInfo()}.<!--
     * -->{@link MBeanInfo#getClassName getClassName()} for example.  For a "plain"
     * DynamicMBean it will be "this".  For an MBean that wraps another
     * object, in the manner of {@link javax.management.StandardMBean}, it will be the
     * wrapped object.</p>
     *
     * @return The resource corresponding to this MBean.
     */
    public Object getWrappedObject();

    /**
     * <p>The {@code ClassLoader} for this MBean, which can be used to
     * retrieve resources associated with the MBean for example.  Usually,
     * it will be
     * {@link #getWrappedObject()}.{@code getClass().getClassLoader()}.
     *
     * @return The {@code ClassLoader} for this MBean.
     */
    public ClassLoader getWrappedClassLoader();
}
