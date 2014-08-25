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
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.management.remote.JMXConnectionNotification;

/**
 * <p>Specifies the kinds of notification an MBean can emit, when this
 * cannot be represented by a single {@link NotificationInfo
 * &#64;NotificationInfo} annotation.</p>
 *
 * <p>For example, this annotation specifies that an MBean can emit
 * {@link AttributeChangeNotification} and {@link
 * JMXConnectionNotification}:</p>
 *
 * <pre>
 * {@code @NotificationInfos}(
 *     {@code @NotificationInfo}(
 *         types = {{@link AttributeChangeNotification#ATTRIBUTE_CHANGE}},
 *         notificationClass = AttributeChangeNotification.class),
 *     {@code @NotificationInfo}(
 *         types = {{@link JMXConnectionNotification#OPENED},
 *                  {@link JMXConnectionNotification#CLOSED}},
 *         notificationClass = JMXConnectionNotification.class)
 * )
 * </pre>
 *
 * <p>If an MBean has both {@code NotificationInfo} and {@code
 * NotificationInfos} on the same class or interface, the effect is
 * the same as if the {@code NotificationInfo} were moved inside the
 * {@code NotificationInfos}.</p>
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotificationInfos {
    /**
     * <p>The {@link NotificationInfo} annotations.</p>
     */
    NotificationInfo[] value();
}
