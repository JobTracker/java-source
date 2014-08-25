/*
 * Copyright 1999-2006 Sun Microsystems, Inc.  All rights reserved.
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

package javax.swing.plaf;

import javax.swing.ActionMap;


/**
 * A subclass of javax.swing.ActionMap that implements UIResource.
 * UI classes which provide an ActionMap should use this class.
 *
 * @author Scott Violet
 * @since 1.3
 */
public class ActionMapUIResource extends ActionMap implements UIResource {
    public ActionMapUIResource() {
    }
}
