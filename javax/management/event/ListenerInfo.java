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

import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectName;

/**
 * This class specifies all the information required to register a user listener into
 * a remote MBean server. This class is not serializable because a user listener
 * is not serialized in order to be sent to the remote server.
 *
 * @since JMX 2.0
 */
public class ListenerInfo {

    /**
     * Constructs a {@code ListenerInfo} object.
     *
     * @param name The name of the MBean to which the listener should
     * be added.
     * @param listener The listener object which will handle the
     * notifications emitted by the MBean.
     * @param filter The filter object. If the filter is null, no
     * filtering will be performed before notifications are handled.
     * @param handback The context to be sent to the listener when a
     * notification is emitted.
     * @param isSubscription If true, the listener is subscribed via
     * an {@code EventManager}. Otherwise it is added to a registered MBean.
     */
    public ListenerInfo(ObjectName name,
            NotificationListener listener,
            NotificationFilter filter,
            Object handback,
            boolean isSubscription) {
        this.name = name;
        this.listener = listener;
        this.filter = filter;
        this.handback = handback;
        this.isSubscription = isSubscription;
    }

    /**
     * Returns an MBean or an MBean pattern that the listener listens to.
     *
     * @return An MBean or an MBean pattern.
     */
    public ObjectName getObjectName() {
        return name;
    }

    /**
     * Returns the listener.
     *
     * @return The listener.
     */
    public NotificationListener getListener() {
        return listener;
    }

    /**
     * Returns the listener filter.
     *
     * @return The filter.
     */
    public NotificationFilter getFilter() {
        return filter;
    }

    /**
     * Returns the listener handback.
     *
     * @return The handback.
     */
    public Object getHandback() {
        return handback;
    }

    /**
     * Returns true if this is a subscription listener.
     *
     * @return True if this is a subscription listener.
     *
     * @see EventClient#addListeners
     */
    public boolean isSubscription() {
        return isSubscription;
    }

    /**
     * <p>Indicates whether some other object is "equal to" this one.
     * The return value is true if and only if {@code o} is an instance of
     * {@code ListenerInfo} and has equal values for all of its properties.</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ListenerInfo)) {
            return false;
        }

        ListenerInfo li = (ListenerInfo)o;

        boolean ret = name.equals(li.name) &&
                (listener == li.listener) &&
                (isSubscription == li.isSubscription);

        if (filter != null) {
            ret &= filter.equals(li.filter);
        } else {
            ret &= (li.filter == null);
        }

        if (handback != null) {
            ret &= handback.equals(li.handback);
        } else {
            ret &= (li.handback == null);
        }

        return ret;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + listener.hashCode();
    }

    @Override
    public String toString() {
        return name.toString() + "_" +
                listener + "_" +
                filter + "_" +
                handback + "_" +
                isSubscription;
    }

    private final ObjectName name;
    private final NotificationListener listener;
    private final NotificationFilter filter;
    private final Object handback;
    private final boolean isSubscription;
}
