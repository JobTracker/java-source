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
import java.util.concurrent.Executors;  // for javadoc

/**
 * This interface is used to specify a way to receive
 * notifications from a remote MBean server and then to forward the notifications
 * to an {@link EventClient}.
 *
 * @see <a href="package-summary.html#transports">Custom notification
 * transports</a>
 */
public interface EventRelay {
    /**
     * Returns an identifier that is used by this {@code EventRelay} to identify
     * the client when communicating with the {@link EventClientDelegateMBean}.
     * <P> This identifier is obtained by calling
     * {@link EventClientDelegateMBean#addClient(String, Object[], String[])
     * EventClientDelegateMBean.addClient}.
     * <P> It is the {@code EventRelay} that calls {@code EventClientDelegateMBean} to obtain
     * the client identifier because it is the {@code EventRelay} that decides
     * how to get notifications from the {@code EventClientDelegateMBean},
     * by creating the appropriate {@link EventForwarder}.
     *
     * @return A client identifier.
     * @throws IOException If an I/O error occurs when communicating with
     * the {@code EventClientDelegateMBean}.
     */
    public String getClientId() throws IOException;

    /**
     * This method is called by {@link EventClient} to register a callback
     * to receive notifications from an {@link EventClientDelegateMBean} object.
     * A {@code null} value is allowed, which means that the {@code EventClient} suspends
     * reception of notifications, so that the {@code EventRelay} can decide to stop receiving
     * notifications from its {@code EventForwarder}.
     *
     * @param eventReceiver An {@link EventClient} callback to receive
     * events.
     */
    public void setEventReceiver(EventReceiver eventReceiver);

    /**
     * Stops receiving and forwarding notifications and performs any necessary
     * cleanup.  After calling this method, the {@link EventClient} will never
     * call any other methods of this object.
     *
     * @throws IOException If an I/O exception appears.
     *
     * @see EventClient#close
     */
    public void stop() throws IOException;
}
