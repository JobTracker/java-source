/*
 * Copyright 1997-1998 Sun Microsystems, Inc.  All rights reserved.
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

package javax.swing.event;

import javax.swing.undo.*;

/**
 * Interface implemented by a class interested in hearing about
 * undoable operations.
 *
 * @author Ray Ryan
 */

public interface UndoableEditListener extends java.util.EventListener {

    /**
     * An undoable edit happened
     */
    void undoableEditHappened(UndoableEditEvent e);
}
