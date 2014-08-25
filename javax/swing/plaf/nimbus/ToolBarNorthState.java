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


class ToolBarNorthState extends State {
    ToolBarNorthState() {
        super("North");
    }

    @Override protected boolean isInState(JComponent c) {

        JToolBar toolbar = (JToolBar)c;
        return NimbusLookAndFeel.resolveToolbarConstraint(toolbar) == BorderLayout.NORTH;
               
    }
}

