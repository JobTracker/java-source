/*
 * Copyright 2002-2008 Sun Microsystems, Inc.  All rights reserved.
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

package javax.swing.plaf.synth;

import javax.swing.*;
import javax.swing.plaf.UIResource;

import java.awt.Container;
import java.awt.Dimension;

/**
 * The default layout manager for Popup menus and menubars.  This
 * class is an extension of BoxLayout which adds the UIResource tag
 * so that plauggable L&Fs can distinguish it from user-installed
 * layout managers on menus.
 *
 * Derived from javax.swing.plaf.basic.DefaultMenuLayout
 *
 * @author Georges Saab
 */

class DefaultMenuLayout extends BoxLayout implements UIResource {
    public DefaultMenuLayout(Container target, int axis) {
        super(target, axis);
    }

    public Dimension preferredLayoutSize(Container target) {
        if (target instanceof JPopupMenu) {
            JPopupMenu popupMenu = (JPopupMenu) target;

            popupMenu.putClientProperty(
                    SynthMenuItemLayoutHelper.MAX_ACC_OR_ARROW_WIDTH, null);
            sun.swing.MenuItemLayoutHelper.clearUsedClientProperties(popupMenu);

            if (popupMenu.getComponentCount() == 0) {
                return new Dimension(0, 0);
            }
        }

        // Make BoxLayout recalculate cached preferred sizes
        super.invalidateLayout(target);

        return super.preferredLayoutSize(target);
    }
}
