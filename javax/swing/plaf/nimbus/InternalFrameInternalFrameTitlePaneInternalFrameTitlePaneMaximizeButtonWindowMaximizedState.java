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


class InternalFrameInternalFrameTitlePaneInternalFrameTitlePaneMaximizeButtonWindowMaximizedState extends State {
    InternalFrameInternalFrameTitlePaneInternalFrameTitlePaneMaximizeButtonWindowMaximizedState() {
        super("WindowMaximized");
    }

    @Override protected boolean isInState(JComponent c) {

                               Component parent = c;
                               while (parent.getParent() != null) {
                                   if (parent instanceof JInternalFrame) {
                                       break;
                                   }
                                   parent = parent.getParent();
                               }
                               if (parent instanceof JInternalFrame) {
                                   return ((JInternalFrame)parent).isMaximum();
                               }
                               return false;
    }
}

