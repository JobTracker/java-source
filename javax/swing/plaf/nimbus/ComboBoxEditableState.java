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


class ComboBoxEditableState extends State {
    ComboBoxEditableState() {
        super("Editable");
    }

    @Override protected boolean isInState(JComponent c) {

                          return ((JComboBox)c).isEditable();
    }
}

