/*
 * Copyright 1997-2008 Sun Microsystems, Inc.  All rights reserved.
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

package javax.swing;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;



/**
 *
 * @author Hans Muller
 */
class MultiUIDefaults extends UIDefaults
{
    private UIDefaults[] tables;

    public MultiUIDefaults(UIDefaults[] defaults) {
        super();
        tables = defaults;
    }

    public MultiUIDefaults() {
        super();
        tables = new UIDefaults[0];
    }

    @Override
    public Object get(Object key)
    {
        Object value = super.get(key);
        if (value != null) {
            return value;
        }

        for (UIDefaults table : tables) {
            value = (table != null) ? table.get(key) : null;
            if (value != null) {
                return value;
            }
        }

        return null;
    }

    @Override
    public Object get(Object key, Locale l)
    {
        Object value = super.get(key,l);
        if (value != null) {
            return value;
        }

        for (UIDefaults table : tables) {
            value = (table != null) ? table.get(key,l) : null;
            if (value != null) {
                return value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        int n = super.size();
        for (UIDefaults table : tables) {
            n += (table != null) ? table.size() : 0;
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Enumeration<Object> keys()
    {
        Enumeration[] enums = new Enumeration[1 + tables.length];
        enums[0] = super.keys();
        for(int i = 0; i < tables.length; i++) {
            UIDefaults table = tables[i];
            if (table != null) {
                enums[i + 1] = table.keys();
            }
        }
        return new MultiUIDefaultsEnumerator(enums);
    }

    @Override
    public Enumeration<Object> elements()
    {
        Enumeration[] enums = new Enumeration[1 + tables.length];
        enums[0] = super.elements();
        for(int i = 0; i < tables.length; i++) {
            UIDefaults table = tables[i];
            if (table != null) {
                enums[i + 1] = table.elements();
            }
        }
        return new MultiUIDefaultsEnumerator(enums);
    }

    @Override
    public Set<Entry<Object, Object>> entrySet() {
        Set<Entry<Object, Object>> set = new HashSet<Entry<Object, Object>>();
        if (tables == null) return set;
        for (UIDefaults table : tables) {
            if (table != null) {
                set.addAll(table.entrySet());
            }
        }
        return set;
    }

    @Override
    protected void getUIError(String msg) {
        if (tables.length > 0) {
            tables[0].getUIError(msg);
        } else {
            super.getUIError(msg);
        }
    }

    private static class MultiUIDefaultsEnumerator implements Enumeration<Object>
    {
        Enumeration[] enums;
        int n = 0;

        MultiUIDefaultsEnumerator(Enumeration[] enums) {
            this.enums = enums;
        }

        public boolean hasMoreElements() {
            for(int i = n; i < enums.length; i++) {
                Enumeration e = enums[i];
                if ((e != null) && (e.hasMoreElements())) {
                    return true;
                }
            }
            return false;
        }

        public Object nextElement() {
            for(; n < enums.length; n++) {
                Enumeration e = enums[n];
                if ((e != null) && (e.hasMoreElements())) {
                    return e.nextElement();
                }
            }
            return null;
        }
    }

    @Override
    public Object remove(Object key)
    {
        Object value = super.remove(key);
        if (value != null) {
            return value;
        }

        for (UIDefaults table : tables) {
            value = (table != null) ? table.remove(key) : null;
            if (value != null) {
                return value;
            }
        }

        return null;
    }

    @Override
    public void clear() {
        super.clear();
        for (UIDefaults table : tables) {
            if (table != null) {
                table.clear();
            }
        }
    }

    @Override
    public synchronized String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("{");
        Enumeration keys = keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            buf.append(key + "=" + get(key) + ", ");
        }
        int length = buf.length();
        if (length > 1) {
            buf.delete(length-2, length);
        }
        buf.append("}");
        return buf.toString();
    }
}
