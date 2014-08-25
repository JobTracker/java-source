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

/**
 * Interface implemented by objects that can be asked to send a notification.
 */
public interface SendNotification {
    /**
     * Sends a notification.
     *
     * @param notification The notification to send.
     */
    public void sendNotification(Notification notification);
}
