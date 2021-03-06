/*
 * Copyright 2005-2008 Sun Microsystems, Inc.  All rights reserved.
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

import com.sun.jmx.mbeanserver.MBeanInjector;
import com.sun.jmx.mbeanserver.MBeanIntrospector;
import static javax.management.JMX.MBeanOptions;

/**
 * <p>An MBean whose management interface is determined by reflection
 * on a Java interface, and that emits notifications.</p>
 *
 * <p>The following example shows how to use the public constructor
 * {@link #StandardEmitterMBean(Object, Class, NotificationEmitter)
 * StandardEmitterMBean(implementation, mbeanInterface, emitter)} to
 * create an MBean emitting notifications with any
 * implementation class name <i>Impl</i>, with a management
 * interface defined (as for current Standard MBeans) by any interface
 * <i>Intf</i>, and with any implementation of the interface
 * {@link NotificationEmitter}. The example uses the class
 * {@link NotificationBroadcasterSupport} as an implementation
 * of the interface {@link NotificationEmitter}.</p>
 *
 *     <pre>
 *     MBeanServer mbs;
 *     ...
 *     final String[] types = new String[] {"sun.disc.space","sun.disc.alarm"};
 *     final MBeanNotificationInfo info = new MBeanNotificationInfo(
 *                                          types,
 *                                          Notification.class.getName(),
 *                                          "Notification about disc info.");
 *     final NotificationEmitter emitter =
 *                    new NotificationBroadcasterSupport(info);
 *
 *     final Intf impl = new Impl(...);
 *     final Object mbean = new StandardEmitterMBean(
 *                                     impl, Intf.class, emitter);
 *     mbs.registerMBean(mbean, objectName);
 *     </pre>
 *
 * @see StandardMBean
 *
 * @since 1.6
 */
public class StandardEmitterMBean extends StandardMBean
        implements NotificationEmitter, SendNotification {

    private final NotificationEmitter emitter;
    private final MBeanNotificationInfo[] notificationInfo;

    /**
     * <p>Make an MBean whose management interface is specified by
     * {@code mbeanInterface}, with the given implementation and
     * where notifications are handled by the given {@code NotificationEmitter}.
     * The resultant MBean implements the {@code NotificationEmitter} interface
     * by forwarding its methods to {@code emitter}.  It is legal and useful
     * for {@code implementation} and {@code emitter} to be the same object.</p>
     *
     * <p>If {@code emitter} is an instance of {@code
     * SendNotification} (for example, a {@link NotificationBroadcasterSupport}),
     * then the MBean's {@link #sendNotification
     * sendNotification} method will call {@code emitter.}{@link
     * SendNotification#sendNotification sendNotification}.</p>
     *
     * <p>The array returned by {@link #getNotificationInfo()} on the
     * new MBean is a copy of the array returned by
     * {@code emitter.}{@link NotificationBroadcaster#getNotificationInfo
     * getNotificationInfo()} at the time of construction.  If the array
     * returned by {@code emitter.getNotificationInfo()} later changes,
     * that will have no effect on this object's
     * {@code getNotificationInfo()}.</p>
     *
     * @param implementation the implementation of the MBean interface.
     * @param mbeanInterface a Standard MBean interface.
     * @param emitter the object that will handle notifications.  If null,
     * a new {@code NotificationEmitter} will be constructed that also
     * implements {@link SendNotification}.
     *
     * @throws IllegalArgumentException if the {@code mbeanInterface}
     *    does not follow JMX design patterns for Management Interfaces, or
     *    if the given {@code implementation} does not implement the
     *    specified interface.
     */
    public <T> StandardEmitterMBean(T implementation, Class<T> mbeanInterface,
                                    NotificationEmitter emitter) {
        this(implementation, mbeanInterface, false, emitter);
    }

    /**
     * <p>Make an MBean whose management interface is specified by
     * {@code mbeanInterface}, with the given implementation and where
     * notifications are handled by the given {@code
     * NotificationEmitter}.  This constructor can be used to make
     * either Standard MBeans or MXBeans.  The resultant MBean
     * implements the {@code NotificationEmitter} interface by
     * forwarding its methods to {@code emitter}.  It is legal and
     * useful for {@code implementation} and {@code emitter} to be the
     * same object.</p>
     *
     * <p>If {@code emitter} is an instance of {@code
     * SendNotification} (for example, a {@link NotificationBroadcasterSupport}),
     * then the MBean's {@link #sendNotification
     * sendNotification} method will call {@code emitter.}{@link
     * SendNotification#sendNotification sendNotification}.</p>
     *
     * <p>The array returned by {@link #getNotificationInfo()} on the
     * new MBean is a copy of the array returned by
     * {@code emitter.}{@link NotificationBroadcaster#getNotificationInfo
     * getNotificationInfo()} at the time of construction.  If the array
     * returned by {@code emitter.getNotificationInfo()} later changes,
     * that will have no effect on this object's
     * {@code getNotificationInfo()}.</p>
     *
     * @param implementation the implementation of the MBean interface.
     * @param mbeanInterface a Standard MBean interface.
     * @param isMXBean If true, the {@code mbeanInterface} parameter
     * names an MXBean interface and the resultant MBean is an MXBean.
     * @param emitter the object that will handle notifications.  If null,
     * a new {@code NotificationEmitter} will be constructed that also
     * implements {@link SendNotification}.
     *
     * @throws IllegalArgumentException if the {@code mbeanInterface}
     *    does not follow JMX design patterns for Management Interfaces, or
     *    if the given {@code implementation} does not implement the
     *    specified interface.
     */
    public <T> StandardEmitterMBean(T implementation, Class<T> mbeanInterface,
                                    boolean isMXBean,
                                    NotificationEmitter emitter) {
        this(implementation, mbeanInterface,
                isMXBean ? MBeanOptions.MXBEAN : null, emitter);
    }

    /**
     * <p>Make an MBean whose management interface is specified by {@code
     * mbeanInterface}, with the given implementation and options, and where
     * notifications are handled by the given {@code NotificationEmitter}.
     * Options select whether to make a Standard MBean or an MXBean, and
     * whether the result of {@link #getWrappedObject()} is the {@code
     * StandardEmitterMBean} object or the given implementation. The resultant
     * MBean implements the {@code NotificationEmitter} interface by forwarding
     * its methods to {@code emitter}. It is legal and useful for {@code
     * implementation} and {@code emitter} to be the same object.</p>
     *
     * <p>If {@code emitter} is an instance of {@code
     * SendNotification} (for example, a {@link NotificationBroadcasterSupport}),
     * then the MBean's {@link #sendNotification
     * sendNotification} method will call {@code emitter.}{@link
     * SendNotification#sendNotification sendNotification}.</p>
     *
     * <p>The array returned by {@link #getNotificationInfo()} on the
     * new MBean is a copy of the array returned by
     * {@code emitter.}{@link NotificationBroadcaster#getNotificationInfo
     * getNotificationInfo()} at the time of construction.  If the array
     * returned by {@code emitter.getNotificationInfo()} later changes,
     * that will have no effect on this object's
     * {@code getNotificationInfo()}.</p>
     *
     * @param implementation the implementation of the MBean interface.
     * @param mbeanInterface a Standard MBean interface.
     * @param options MBeanOptions that control the operation of the resulting
     * MBean.
     * @param emitter the object that will handle notifications.  If null,
     * a new {@code NotificationEmitter} will be constructed that also
     * implements {@link SendNotification}.
     *
     * @throws IllegalArgumentException if the {@code mbeanInterface}
     *    does not follow JMX design patterns for Management Interfaces, or
     *    if the given {@code implementation} does not implement the
     *    specified interface.
     */
    public <T> StandardEmitterMBean(T implementation, Class<T> mbeanInterface,
                                    MBeanOptions options,
                                    NotificationEmitter emitter) {
        super(implementation, mbeanInterface, options);
        MBeanNotificationInfo[] defaultMBNIs = defaultMBNIs(implementation);
        if (emitter == null)
            emitter = defaultEmitter(defaultMBNIs);
        this.emitter = emitter;
        this.notificationInfo =
                firstNonEmpty(emitter.getNotificationInfo(), defaultMBNIs);
        injectEmitter();
    }

    /**
     * <p>Make an MBean whose management interface is specified by
     * {@code mbeanInterface}, and
     * where notifications are handled by the given {@code NotificationEmitter}.
     * The resultant MBean implements the {@code NotificationEmitter} interface
     * by forwarding its methods to {@code emitter}.</p>
     *
     * <p>If {@code emitter} is an instance of {@code
     * SendNotification} (for example, a {@link NotificationBroadcasterSupport}),
     * then the MBean's {@link #sendNotification
     * sendNotification} method will call {@code emitter.}{@link
     * SendNotification#sendNotification sendNotification}.</p>
     *
     * <p>The array returned by {@link #getNotificationInfo()} on the
     * new MBean is a copy of the array returned by
     * {@code emitter.}{@link NotificationBroadcaster#getNotificationInfo
     * getNotificationInfo()} at the time of construction.  If the array
     * returned by {@code emitter.getNotificationInfo()} later changes,
     * that will have no effect on this object's
     * {@code getNotificationInfo()}.</p>
     *
     * <p>This constructor must be called from a subclass that implements
     * the given {@code mbeanInterface}.</p>
     *
     * @param mbeanInterface a StandardMBean interface.
     * @param emitter the object that will handle notifications.  If null,
     * a new {@code NotificationEmitter} will be constructed that also
     * implements {@link SendNotification}.
     *
     * @throws IllegalArgumentException if the {@code mbeanInterface}
     *    does not follow JMX design patterns for Management Interfaces, or
     *    if {@code this} does not implement the specified interface.
     */
    protected StandardEmitterMBean(Class<?> mbeanInterface,
                                   NotificationEmitter emitter) {
        this(mbeanInterface, false, emitter);
    }

    /**
     * <p>Make an MBean whose management interface is specified by
     * {@code mbeanInterface}, and where notifications are handled by
     * the given {@code NotificationEmitter}.  This constructor can be
     * used to make either Standard MBeans or MXBeans.  The resultant
     * MBean implements the {@code NotificationEmitter} interface by
     * forwarding its methods to {@code emitter}.</p>
     *
     * <p>If {@code emitter} is an instance of {@code
     * SendNotification} (for example, a {@link NotificationBroadcasterSupport}),
     * then the MBean's {@link #sendNotification
     * sendNotification} method will call {@code emitter.}{@link
     * SendNotification#sendNotification sendNotification}.</p>
     *
     * <p>The array returned by {@link #getNotificationInfo()} on the
     * new MBean is a copy of the array returned by
     * {@code emitter.}{@link NotificationBroadcaster#getNotificationInfo
     * getNotificationInfo()} at the time of construction.  If the array
     * returned by {@code emitter.getNotificationInfo()} later changes,
     * that will have no effect on this object's
     * {@code getNotificationInfo()}.</p>
     *
     * <p>This constructor must be called from a subclass that implements
     * the given {@code mbeanInterface}.</p>
     *
     * @param mbeanInterface a StandardMBean interface.
     * @param isMXBean If true, the {@code mbeanInterface} parameter
     * names an MXBean interface and the resultant MBean is an MXBean.
     * @param emitter the object that will handle notifications.  If null,
     * a new {@code NotificationEmitter} will be constructed that also
     * implements {@link SendNotification}.
     *
     * @throws IllegalArgumentException if the {@code mbeanInterface}
     *    does not follow JMX design patterns for Management Interfaces, or
     *    if {@code this} does not implement the specified interface.
     */
    protected StandardEmitterMBean(Class<?> mbeanInterface, boolean isMXBean,
                                   NotificationEmitter emitter) {
        this(mbeanInterface, isMXBean ? MBeanOptions.MXBEAN : null, emitter);
    }

    /**
     * <p>Make an MBean whose management interface is specified by {@code
     * mbeanInterface}, with the given options, and where notifications are
     * handled by the given {@code NotificationEmitter}. This constructor can
     * be used to make either Standard MBeans or MXBeans. The resultant MBean
     * implements the {@code NotificationEmitter} interface by forwarding its
     * methods to {@code emitter}.</p>
     *
     * <p>If {@code emitter} is an instance of {@code
     * SendNotification} (for example, a {@link NotificationBroadcasterSupport}),
     * then the MBean's {@link #sendNotification
     * sendNotification} method will call {@code emitter.}{@link
     * SendNotification#sendNotification sendNotification}.</p>
     *
     * <p>The array returned by {@link #getNotificationInfo()} on the
     * new MBean is a copy of the array returned by
     * {@code emitter.}{@link NotificationBroadcaster#getNotificationInfo
     * getNotificationInfo()} at the time of construction.  If the array
     * returned by {@code emitter.getNotificationInfo()} later changes,
     * that will have no effect on this object's
     * {@code getNotificationInfo()}.</p>
     *
     * <p>This constructor must be called from a subclass that implements
     * the given {@code mbeanInterface}.</p>
     *
     * @param mbeanInterface a StandardMBean interface.
     * @param options MBeanOptions that control the operation of the resulting
     * MBean.
     * @param emitter the object that will handle notifications.  If null,
     * a new {@code NotificationEmitter} will be constructed that also
     * implements {@link SendNotification}.
     *
     * @throws IllegalArgumentException if the {@code mbeanInterface}
     *    does not follow JMX design patterns for Management Interfaces, or
     *    if {@code this} does not implement the specified interface.
     */
    protected StandardEmitterMBean(Class<?> mbeanInterface, MBeanOptions options,
                                   NotificationEmitter emitter) {
        super(mbeanInterface, options);
        MBeanNotificationInfo[] defaultMBNIs = defaultMBNIs(this);
        if (emitter == null)
            emitter = defaultEmitter(defaultMBNIs);
        this.emitter = emitter;
        this.notificationInfo =
                firstNonEmpty(emitter.getNotificationInfo(), defaultMBNIs);
        injectEmitter();
    }

    private static MBeanNotificationInfo[] defaultMBNIs(Object mbean) {
        return MBeanIntrospector.findNotificationsFromAnnotations(
                mbean.getClass());
    }

    private NotificationEmitter defaultEmitter(MBeanNotificationInfo[] defaultMBNIs) {
        MBeanNotificationInfo[] mbnis =
                firstNonEmpty(getNotificationInfo(), defaultMBNIs);
        // Will be null unless getNotificationInfo() is overridden,
        // since the notificationInfo field has not been set at this point.
        if (mbnis == null)
            mbnis = getMBeanInfo().getNotifications();
        return new NotificationBroadcasterSupport(mbnis);
    }

    private static <T> T[] firstNonEmpty(T[]... items) {
        for (T[] t : items) {
            if (t != null && t.length != 0)
                return t;
        }
        return null;
    }

    private void injectEmitter() {
        if (emitter instanceof SendNotification) {
            try {
                Object resource = getImplementation();
                SendNotification send = (SendNotification) emitter;
                MBeanInjector.injectSendNotification(resource, send);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public void removeNotificationListener(NotificationListener listener)
            throws ListenerNotFoundException {
        emitter.removeNotificationListener(listener);
    }

    public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter,
                                           Object handback)
            throws ListenerNotFoundException {
        emitter.removeNotificationListener(listener, filter, handback);
    }

    public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter,
                                        Object handback) {
        emitter.addNotificationListener(listener, filter, handback);
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return notificationInfo;
    }

    /**
     * <p>Sends a notification.</p>
     *
     * <p>If the {@code emitter} parameter to the constructor was
     * an instance of {@link SendNotification}, such as {@link
     * NotificationBroadcasterSupport}, then this method will call {@code
     * emitter.}{@link SendNotification#sendNotification
     * sendNotification}.</p>
     *
     * @param n the notification to send.
     *
     * @throws ClassCastException if the {@code emitter} parameter to the
     * constructor was not a {@code NotificationBroadcasterSupport}.
     */
    public void sendNotification(Notification n) {
        if (emitter instanceof SendNotification)
            ((SendNotification) emitter).sendNotification(n);
        else {
            final String msg =
                "Cannot sendNotification when emitter is not an " +
                "instance of SendNotification: " + emitter.getClass().getName();
            throw new ClassCastException(msg);
        }
    }

    /**
     * <p>Get the MBeanNotificationInfo[] that will be used in the
     * MBeanInfo returned by this MBean.</p>
     *
     * <p>The default implementation of this method returns
     * {@link #getNotificationInfo()}.</p>
     *
     * @param info The default MBeanInfo derived by reflection.
     * @return the MBeanNotificationInfo[] for the new MBeanInfo.
     */
    @Override
    MBeanNotificationInfo[] getNotifications(MBeanInfo info) {
        return getNotificationInfo();
    }
}
