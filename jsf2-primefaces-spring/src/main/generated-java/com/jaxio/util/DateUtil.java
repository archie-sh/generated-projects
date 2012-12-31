/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/util/DateUtil.p.vm.java
 */
package com.jaxio.util;

import java.util.Date;

public class DateUtil {
    /**
     * Compare 2 dates using seconds precision.
     * Useful for JPA equality concern when comparing Date from Java world (with millisec precision) with date
     * retrieved from Oracle (second precision only).
     */
    public boolean secondPrecisionDateEquality(Date date1, Date date2) {
        return secondPrecisionDate(date1).equals(date2);
    }

    public static String secondPrecisionDate(Date date) {
        String ret = Long.toString(date.getTime());
        return ret.substring(0, ret.length() - 3);
    }
}