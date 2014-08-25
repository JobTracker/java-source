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

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.management.remote.NotificationResult;

/**
 * The {@link RMIPushEventRelay} exports an RMI object of this class and
 * sends a client stub for that object to the associated
 * {@link RMIPushEventForwarder} in a remote MBean server.  The
 * {@code RMIPushEventForwarder} then sends notifications to the
 * RMI object.
 */
public interface RMIPushServer extends Remote {
    /**
     * <p>Dispatch the notifications in {@code nr} to the {@link RMIPushEventRelay}
     * associated with this object.</p>
     * @param nr the notification result to dispatch.
     * @throws java.rmi.RemoteException if the remote invocation of this method
     * failed.
     */
    public void receive(NotificationResult nr) throws RemoteException;
}
