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

package javax.xml.ws.soap;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.spi.Provider;


/**
 * This feature represents the use of MTOM with a
 * web service.
 *
 * <p>
 * The following describes the affects of this feature with respect
 * to being enabled or disabled:
 * <ul>
 *  <li> ENABLED: In this Mode, MTOM will be enabled.
 *  <li> DISABLED: In this Mode, MTOM will be disabled
 * </ul>
 * <p>
 * The {@link #threshold} property can be used to set the threshold
 * value used to determine when binary data should be XOP encoded.
 *
 * @since JAX-WS 2.1
 */
public final class MTOMFeature extends WebServiceFeature {
    /**
     * Constant value identifying the MTOMFeature
     */
    public static final String ID = "http://www.w3.org/2004/08/soap/features/http-optimization";


    /**
     * Property for MTOM threshold value. This property serves as a hint when
     * MTOM is enabled, binary data above this size in bytes SHOULD be sent
     * as attachment.
     * The value of this property MUST always be >= 0. Default value is 0.
     */
    protected int threshold = 0;


    /**
     * Create an <code>MTOMFeature</code>.
     * The instance created will be enabled.
     */
    public MTOMFeature() {
        this.enabled = true;
    }

    /**
     * Creates an <code>MTOMFeature</code>.
     *
     * @param enabled specifies if this feature should be enabled or not
     */
    public MTOMFeature(boolean enabled) {
        this.enabled = enabled;
    }


    /**
     * Creates an <code>MTOMFeature</code>.
     * The instance created will be enabled.
     *
     * @param threshold the size in bytes that binary data SHOULD be before
     * being sent as an attachment.
     *
     * @throws WebServiceException if threshold is < 0
     */
    public MTOMFeature(int threshold) {
        if (threshold < 0)
            throw new WebServiceException("MTOMFeature.threshold must be >= 0, actual value: "+threshold);
        this.enabled = true;
        this.threshold = threshold;
    }

    /**
     * Creates an <code>MTOMFeature</code>.
     *
     * @param enabled specifies if this feature should be enabled or not
     * @param threshold the size in bytes that binary data SHOULD be before
     * being sent as an attachment.
     *
     * @throws WebServiceException if threshold is < 0
     */
    public MTOMFeature(boolean enabled, int threshold) {
        if (threshold < 0)
            throw new WebServiceException("MTOMFeature.threshold must be >= 0, actual value: "+threshold);
        this.enabled = enabled;
        this.threshold = threshold;
    }

    /**
     * {@inheritDoc}
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the threshold value used to determine when binary data
     * should be sent as an attachment.
     *
     * @return the current threshold size in bytes
     */
    public int getThreshold() {
        return threshold;
    }
}
