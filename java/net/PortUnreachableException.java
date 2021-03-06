/*
 * Copyright 2001-2008 Sun Microsystems, Inc.  All rights reserved.
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

package java.net;

/**
 * Signals that an ICMP Port Unreachable message has been
 * received on a connected datagram.
 *
 * @since   1.4
 */

public class PortUnreachableException extends SocketException {
    private static final long serialVersionUID = 8462541992376507323L;

    /**
     * Constructs a new <code>PortUnreachableException</code> with a
     * detail message.
     * @param msg the detail message
     */
    public PortUnreachableException(String msg) {
        super(msg);
    }

    /**
     * Construct a new <code>PortUnreachableException</code> with no
     * detailed message.
     */
    public PortUnreachableException() {}
}
