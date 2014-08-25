/*
 * Copyright 2007-2008 Sun Microsystems, Inc.  All rights reserved.
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

package javax.management;

/**
 * <p>Defines the impact of an MBean operation, in particular whether it
 * has an effect on the MBean or simply returns information.  This enum
 * is used in the {@link ManagedOperation @ManagedOperation} annotation.
 * Its {@link #getCode()} method can be used to get an {@code int} suitable
 * for use as the {@code impact} parameter in an {@link MBeanOperationInfo}
 * constructor.</p>
 */
public enum Impact {
    /**
     * The operation is read-like: it returns information but does not change
     * any state.
     * @see MBeanOperationInfo#INFO
     */
    INFO(MBeanOperationInfo.INFO),

    /**
     * The operation is write-like: it has an effect but does not return
     * any information from the MBean.
     * @see MBeanOperationInfo#ACTION
     */
    ACTION(MBeanOperationInfo.ACTION),

    /**
     * The operation is both read-like and write-like: it has an effect,
     * and it also returns information from the MBean.
     * @see MBeanOperationInfo#ACTION_INFO
     */
    ACTION_INFO(MBeanOperationInfo.ACTION_INFO),

    /**
     * The impact of the operation is unknown or cannot be expressed
     * using one of the other values.
     * @see MBeanOperationInfo#UNKNOWN
     */
    UNKNOWN(MBeanOperationInfo.UNKNOWN);

    private final int code;

    /**
     * An instance of this enumeration, with the corresponding {@code int}
     * code used by the {@link MBeanOperationInfo} constructors.
     *
     * @param code the code used by the {@code MBeanOperationInfo} constructors.
     */
    Impact(int code) {
        this.code = code;
    }

    /**
     * The equivalent {@code int} code used by the {@link MBeanOperationInfo}
     * constructors.
     * @return the {@code int} code.
     */
    public int getCode() {
        return code;
    }

    /**
     * Return the {@code Impact} value corresponding to the given {@code int}
     * code.  The {@code code} is the value that would be used in an
     * {@code MBeanOperationInfo} constructor.
     *
     * @param code the {@code int} code.
     *
     * @return an {@code Impact} value {@code x} such that
     * {@code code == x.}{@link #getCode()}, or {@code Impact.UNKNOWN}
     * if there is no such value.
     */
    public static Impact forCode(int code) {
        switch (code) {
            case MBeanOperationInfo.ACTION: return ACTION;
            case MBeanOperationInfo.INFO: return INFO;
            case MBeanOperationInfo.ACTION_INFO: return ACTION_INFO;
            default: return UNKNOWN;
        }
    }
}
