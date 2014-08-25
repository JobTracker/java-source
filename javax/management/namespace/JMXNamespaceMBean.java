/*
 * Copyright 2008 Sun Microsystems, Inc.  All rights reserved.
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

package javax.management.namespace;

import java.io.IOException;
import java.util.UUID;

/**
 * A {@link JMXNamespace} is an MBean that handles a name space in the
 * MBeanServer hierarchical name space.
 * @see JMXNamespace
 * @since 1.7
 */
public interface JMXNamespaceMBean {

    // Note: since getDomains(), getDefaultDomain(), and getMBeanCount()
    // don't take any ObjectName parameters, the only efficient way
    // to get these data is to call the corresponding method on the
    // JMXNamespaceMBean that handles the name space.
    //
    // We need these methods to implement 'cd' (JMXNamespaces.narrowToNamespace)
    // correctly.
    //

    /**
     * Returns the list of domains currently implemented in the name space
     * handled by this {@link JMXNamespace}.
     * @throws IOException if the domain list cannot be obtained due to
     *         I/O problems (communication failures etc...).
     * @return the list of domains currently implemented in the name space
     * handled by this {@link JMXNamespace}.
     * @see javax.management.MBeanServerConnection#getDomains
     *      MBeanServerConnection.getDomains
     **/
    public String[] getDomains() throws IOException;

    /**
     * Returns the default domain for the name space handled by
     * this {@link JMXNamespace}.
     * @throws IOException if the default domain cannot be obtained due to
     *         I/O problems (communication failures etc...).
     * @return the default domain for the name space handled by
     * this {@link JMXNamespace}.
     * @see javax.management.MBeanServerConnection#getDefaultDomain
     *      MBeanServerConnection.getDefaultDomain
     **/
    public String   getDefaultDomain() throws IOException;

    /**
     * Returns the number of MBeans registered in the  name space handled by
     *         this  {@link JMXNamespace}.
     *
     * @return the number of MBeans registered in the  name space handled by
     *         this  {@link JMXNamespace}.
     *
     * @throws IOException if the MBean count cannot be obtained due to
     *         I/O problems (communication failures etc...).
     * @see javax.management.MBeanServerConnection#getMBeanCount
     *      MBeanServerConnection.getMBeanCount
     */
    public Integer  getMBeanCount() throws IOException;

    /**
     * Returns a {@link java.util.UUID UUID string} which uniquely identifies
     * this {@linkplain JMXNamespace} MBean.
     * This information can be used to detect loops in the JMX name space graph.
     * @return A unique ID identifying this MBean.
     * @throws IOException if the MBean UUID cannot be obtained due to
     *         I/O problems (communication failures etc...).
     */
    public String getUUID() throws IOException;

}
