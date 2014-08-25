/*
 * Copyright 1999 Sun Microsystems, Inc.  All rights reserved.
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
/*
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package org.omg.CORBA.portable;
import java.io.Serializable;

public interface BoxedValueHelper {
    Serializable read_value(InputStream is);
    void write_value(OutputStream os, Serializable value);
    String get_id();
}
