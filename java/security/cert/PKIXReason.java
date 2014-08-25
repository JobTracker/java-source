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

package java.security.cert;

/**
 * The <code>PKIXReason</code> enumerates the potential PKIX-specific reasons
 * that an X.509 certification path may be invalid according to the PKIX
 * (RFC 3280) standard. These reasons are in addition to those of the
 * <code>CertPathValidatorException.BasicReason</code> enumeration.
 *
 * @since 1.7
 */
public enum PKIXReason implements CertPathValidatorException.Reason {
    /**
     * The certificate does not chain correctly.
     */
    NAME_CHAINING,

    /**
     * The certificate's key usage is invalid.
     */
    INVALID_KEY_USAGE,

    /**
     * The policy constraints have been violated.
     */
    INVALID_POLICY,

    /**
     * No acceptable trust anchor found.
     */
    NO_TRUST_ANCHOR,

    /**
     * The certificate contains one or more unrecognized critical
     * extensions.
     */
    UNRECOGNIZED_CRIT_EXT,

    /**
     * The certificate is not a CA certificate.
     */
    NOT_CA_CERT,

    /**
     * The path length constraint has been violated.
     */
    PATH_TOO_LONG,

    /**
     * The name constraints have been violated.
     */
    INVALID_NAME
}
