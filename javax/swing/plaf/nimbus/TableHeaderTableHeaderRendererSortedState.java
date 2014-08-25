/*
 * Copyright 2005-2006 Sun Microsystems, Inc.  All rights reserved.
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
package javax.swing.plaf.nimbus;

import java.awt.*;
import javax.swing.*;


class TableHeaderTableHeaderRendererSortedState extends State {
    TableHeaderTableHeaderRendererSortedState() {
        super("Sorted");
    }

    @Override protected boolean isInState(JComponent c) {

                    String sortOrder = (String)c.getClientProperty("Table.sortOrder");
                    return  sortOrder != null && ("ASCENDING".equals(sortOrder) || "DESCENDING".equals(sortOrder)); 
    }
}

