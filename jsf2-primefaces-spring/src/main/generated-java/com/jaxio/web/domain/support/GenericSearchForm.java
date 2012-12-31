/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/support/GenericSearchForm.p.vm.java
 */
package com.jaxio.web.domain.support;

import java.io.Serializable;
import com.jaxio.dao.support.SearchParameters;

public abstract class GenericSearchForm<E, F extends GenericSearchForm<E, F>> implements Serializable {
    private static final long serialVersionUID = 1L;

    abstract protected E getEntity();

    abstract public SearchParameters toSearchParameters();

    // Reset related

    abstract public F newInstance();

    abstract public void resetWithOther(F other);

    public void reset() {
        resetWithOther(newInstance());
    }
}