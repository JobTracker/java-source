/*
 * Copyright 1999-2008 Sun Microsystems, Inc.  All rights reserved.
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
 * Represents a notification emitted by the MBean Server through the MBeanServerDelegate MBean.
 * The MBean Server emits the following types of notifications: MBean registration, MBean
 * unregistration.
 * <P>
 * To receive MBeanServerNotifications, you need to register a listener with
 * the {@link MBeanServerDelegate MBeanServerDelegate} MBean
 * that represents the MBeanServer. The ObjectName of the MBeanServerDelegate is
 * {@link MBeanServerDelegate#DELEGATE_NAME}, which is
 * <CODE>JMImplementation:type=MBeanServerDelegate</CODE>.
 *
 * <p>The following code prints a message every time an MBean is registered
 * or unregistered in the MBean Server {@code mbeanServer}:</p>
 *
 * <pre>
 * private static final NotificationListener printListener = new NotificationListener() {
 *     public void handleNotification(Notification n, Object handback) {
 *         if (!(n instanceof MBeanServerNotification)) {
 *             System.out.println("Ignored notification of class " + n.getClass().getName());
 *             return;
 *         }
 *         MBeanServerNotification mbsn = (MBeanServerNotification) n;
 *         String what;
 *         if (n.getType().equals(MBeanServerNotification.REGISTRATION_NOTIFICATION))
 *             what = "MBean registered";
 *         else if (n.getType().equals(MBeanServerNotification.UNREGISTRATION_NOTIFICATION))
 *             what = "MBean unregistered";
 *         else
 *             what = "Unknown type " + n.getType();
 *         System.out.println("Received MBean Server notification: " + what + ": " +
 *                 mbsn.getMBeanName());
 *     }
 * };
 *
 * ...
 *     mbeanServer.addNotificationListener(
 *             MBeanServerDelegate.DELEGATE_NAME, printListener, null, null);
 * </pre>
 * <p id="group">
 * An MBean which is not an {@link MBeanServerDelegate} may also emit
 * MBeanServerNotifications. In particular, a custom subclass of the
 * {@link javax.management.namespace.JMXDomain JMXDomain} MBean or a custom
 * subclass of the {@link javax.management.namespace.JMXNamespace JMXNamespace}
 * MBean may emit an MBeanServerNotification for a group of MBeans.<br>
 * An MBeanServerNotification emitted to denote the registration or
 * unregistration of a group of MBeans has the following characteristics:
 * <ul><li>Its {@linkplain Notification#getType() notification type} is
 *     {@code "JMX.mbean.registered.group"} or
 *     {@code "JMX.mbean.unregistered.group"}, which can also be written {@link
 *     MBeanServerNotification#REGISTRATION_NOTIFICATION}{@code + ".group"} or
 *     {@link
 *     MBeanServerNotification#UNREGISTRATION_NOTIFICATION}{@code + ".group"}.
 * </li>
 * <li>Its {@linkplain #getMBeanName() MBean name} is an ObjectName pattern
 *     that selects the set (or a superset) of the MBeans being registered
 *     or unregistered</li>
 * <li>Its {@linkplain Notification#getUserData() user data} can optionally
 *     be set to an array of ObjectNames containing the names of all MBeans
 *     being registered or unregistered.</li>
 * </ul>
 * </p>
 * <p>
 * MBeans which emit these group registration/unregistration notifications will
 * declare them in their {@link MBeanInfo#getNotifications()
 * MBeanNotificationInfo}.
 * </p>
 * <P>
 * To receive a group MBeanServerNotification, you need to register a listener
 * with the MBean that emits it. For instance, assuming that the {@link
 * javax.management.namespace.JMXNamespace JMXNamespace} MBean handling
 * namespace {@code "foo"} has declared that it emits such a notification,
 * you will need to register your notification listener with that MBean, which
 * will be named {@link
 * javax.management.namespace.JMXNamespaces#getNamespaceObjectName(java.lang.String)
 * foo//:type=JMXNamespace}.
 * </p>
 * <p>The following code prints a message every time a group of MBean is
 * registered or unregistered in the namespace {@code "foo"}, assumimg its
 * {@link javax.management.namespace.JMXNamespace handler} supports
 * group MBeanServerNotifications:</p>
 *
 * <pre>
 * private static final NotificationListener printListener = new NotificationListener() {
 *     public void handleNotification(Notification n, Object handback) {
 *         if (!(n instanceof MBeanServerNotification)) {
 *             System.out.println("Ignored notification of class " + n.getClass().getName());
 *             return;
 *         }
 *         MBeanServerNotification mbsn = (MBeanServerNotification) n;
 *         String what;
 *         ObjectName[] names = null;
 *         if (n.getType().equals(MBeanServerNotification.REGISTRATION_NOTIFICATION)) {
 *             what = "MBean registered";
 *         } else if (n.getType().equals(MBeanServerNotification.UNREGISTRATION_NOTIFICATION)) {
 *             what = "MBean unregistered";
 *         } else if (n.getType().equals(MBeanServerNotification.REGISTRATION_NOTIFICATION+".group")) {
 *             what = "Group of MBeans registered matching";
 *             if (mbsn.getUserData() instanceof ObjectName[])
 *                names =  (ObjectName[]) mbsn.getUserData();
 *         } else if (n.getType().equals(MBeanServerNotification.UNREGISTRATION_NOTIFICATION+".group")) {
 *             what = "Group of MBeans unregistered matching";
 *             if (mbsn.getUserData() instanceof ObjectName[])
 *                names = (ObjectName[]) mbsn.getUserData();
 *         } else
 *             what = "Unknown type " + n.getType();
 *         System.out.println("Received MBean Server notification: " + what + ": " +
 *                 mbsn.getMBeanName());
 *         if (names != null) {
 *              for (ObjectName mb : names)
 *                  System.out.println("\t"+mb);
 *         }
 *     }
 * };
 *
 * ...
 *     mbeanServer.addNotificationListener(
 *             JMXNamespaces.getNamespaceObjectName("foo"), printListener, null, null);
 * </pre>
 *
 * @since 1.5
 */
public class MBeanServerNotification extends Notification {


    /* Serial version */
    private static final long serialVersionUID = 2876477500475969677L;
    /**
     * Notification type denoting that an MBean has been registered.
     * Value is "JMX.mbean.registered".
     */
    public static final String REGISTRATION_NOTIFICATION =
            "JMX.mbean.registered";
    /**
     * Notification type denoting that an MBean has been unregistered.
     * Value is "JMX.mbean.unregistered".
     */
    public static final String UNREGISTRATION_NOTIFICATION =
            "JMX.mbean.unregistered";
    /**
     * @serial The object names of the MBeans concerned by this notification
     */
    private final ObjectName objectName;

    /**
     * Creates an MBeanServerNotification object specifying object names of
     * the MBeans that caused the notification and the specified notification
     * type.
     *
     * @param type A string denoting the type of the
     * notification. Set it to one these values: {@link
     * #REGISTRATION_NOTIFICATION}, {@link
     * #UNREGISTRATION_NOTIFICATION}.
     * @param source The MBeanServerNotification object responsible
     * for forwarding MBean server notification.
     * @param sequenceNumber A sequence number that can be used to order
     * received notifications.
     * @param objectName The object name of the MBean that caused the
     * notification.
     *
     */
    public MBeanServerNotification(String type, Object source,
            long sequenceNumber, ObjectName objectName) {
        super(type, source, sequenceNumber);
        this.objectName = objectName;
    }

    /**
     * Returns the  object name of the MBean that caused the notification.
     *
     * @return the object name of the MBean that caused the notification.
     */
    public ObjectName getMBeanName() {
        return objectName;
    }

    @Override
    public String toString() {
        return super.toString() + "[mbeanName=" + objectName + "]";

    }

 }
