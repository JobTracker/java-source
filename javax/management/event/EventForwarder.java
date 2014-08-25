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
import javax.management.Notification;

/**
 * This interface can be used to specify a custom forwarding mechanism for
 * {@code EventClientDelegateMBean} to forward events to the client.
 *
 * @see <a href="package-summary.html#transports">Custom notification
 * transports</a>
 */
public interface EventForwarder {
    /**
     * Forwards a notification.
     * @param n The notification to be forwarded to a remote listener.
     * @param listenerId The identifier of the listener to receive the notification.
     * @throws IOException If it is closed or an I/O error occurs.
     */
    public void forward(Notification n, Integer listenerId)
        throws IOException;

    /**
     * Informs the {@code EventForwarder} to shut down.
     * <p> After this method is called, any call to the method
     * {@link #forward forward(Notification, Integer)} may get an {@code IOException}.
     * @throws IOException If an I/O error occurs.
     */
    public void close() throws IOException;

    /**
     * Sets an event client identifier created by {@link EventClientDelegateMBean}.
     * <P> This method will be called just after this {@code EventForwarder}
     * is constructed and before calling the {@code forward} method to forward any
     * notifications.
     */
    public void setClientId(String clientId) throws IOException;
}
