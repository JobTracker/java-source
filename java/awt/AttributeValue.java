/*
 * Copyright 1999-2007 Sun Microsystems, Inc.  All rights reserved.
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

package java.awt;

import java.util.logging.*;

abstract class AttributeValue {
    private static final Logger log = Logger.getLogger("java.awt.AttributeValue");

    private final int value;
    private final String[] names;

    protected AttributeValue(int value, String[] names) {
        if (log.isLoggable(Level.FINEST)) {
            log.log(Level.FINEST, "value = " + value + ", names = " + names);
        }
        if (log.isLoggable(Level.FINER)) {
            if ((value < 0) || (names == null) || (value >= names.length)) {
                log.log(Level.FINER, "Assertion failed");
            }
        }
        this.value = value;
        this.names = names;
    }
    // This hashCode is used by the sun.awt implementation as an array
    // index.
    public int hashCode() {
        return value;
    }
    public String toString() {
        return names[value];
    }
}
