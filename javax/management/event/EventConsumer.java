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

package javax.management.event;

import java.io.IOException;
import javax.management.ListenerNotFoundException;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectName;

/**
 * This interface specifies methods to subscribe a listener to receive events
 * from an MBean or a set of MBeans. The MBeans can already be registered in
 * an MBean server, or they can be pending registration, or they can be MBeans
 * that will never be registered, or they can be MBeans that will be registered
 * then unregistered.
 * @since JMX 2.0
 */
public interface EventConsumer {
    /**
     * <p>Subscribes a listener to receive events from an MBean or a set
     * of MBeans represented by an {@code ObjectName} pattern.</p>
     *
     * <P> An event emitted by an MBean is forwarded to every listener that was
     * subscribed with the name of that MBean, or with a pattern that matches
     * that name.</p>
     *
     * @param name The name of an MBean or an {@code ObjectName} pattern
     * representing a set of MBeans to which the listener should listen.
     * @param listener The listener object that will handle the
     * notifications emitted by the MBeans.
     * @param filter The filter object. If {@code filter} is null, no
     * filtering will be performed before notification handling.
     * @param handback The context to be sent to the listener when a
     * notification is emitted.
     *
     * @throws IllegalArgumentException If the {@code name} or
     * {@code listener} is null.
     * @throws IOException for a remote client, thrown if
     * an I/O error occurs.
     * @see #unsubscribe(ObjectName, NotificationListener)
     */
    public void subscribe(ObjectName name,
            NotificationListener listener,
            NotificationFilter filter,
            Object handback)
            throws IOException;

    /**
     * <p>Unsubscribes a listener which is listening to an MBean or a set of
     * MBeans represented by an {@code ObjectName} pattern.</p>
     *
     * <p>The listener to be removed must have been added by the {@link
     * #subscribe subscribe} method with the given {@code name}. If the {@code
     * name} is a pattern, then the {@code subscribe} must have used the same
     * pattern. If the same listener has been subscribed more than once to the
     * {@code name}, perhaps with different filters or handbacks, then all such
     * listeners are removed.</p>
     *
     * @param name The name of the MBean or an {@code ObjectName} pattern
     * representing a set of MBeans to which the listener was subscribed.
     * @param listener A listener that was previously subscribed to the
     * MBean(s).
     *
     * @throws ListenerNotFoundException The given {@code listener} was not
     * subscribed to the given {@code name}.
     * @throws IOException for a remote client, thrown if
     * an I/O error occurs.
     *
     * @see #subscribe
     */
    public void unsubscribe(ObjectName name,
            NotificationListener listener)
            throws ListenerNotFoundException, IOException;
}
