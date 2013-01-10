/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.jaxio.web.domain;

import java.util.Map;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;
import com.jaxio.dao.support.OrderBy;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Role;
import com.jaxio.repository.RoleRepository;
import com.jaxio.repository.support.Repository;
import com.jaxio.web.conversation.ConversationContext;
import com.jaxio.web.converter.RoleJsfConverter;
import com.jaxio.web.domain.support.GenericLazyDataModel;
import com.jaxio.web.domain.support.GenericSearchForm;

/**
 * Provides server-side pagination for search.
 * TODO: dependencies wiring after deserialization (get inspiration from http://jira.springframework.org/browse/SWF-1224 )
 */
@Named
@Scope("conversation")
public class RoleLazyDataModel extends GenericLazyDataModel<Role, Integer, RoleSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private RoleRepository roleRepository;
    @Inject
    transient private RoleJsfConverter roleConverter;
    @Inject
    transient private RoleSearchForm roleSearchForm;

    @Override
    protected Repository<Role, Integer> getRepository() {
        return roleRepository;
    }

    @Override
    protected Converter getConverter() {
        return roleConverter;
    }

    @Override
    protected GenericSearchForm<Role, RoleSearchForm> getSearchForm() {
        return roleSearchForm;
    }

    @Override
    protected SearchParameters populateSearchParameters(SearchParameters sp, int first, int pageSize, String sortField, SortOrder sortOrder,
            Map<String, String> filters) {
        super.populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters);
        if (!sp.hasOrders()) {
            sp.addOrderBy(new OrderBy("roleName"));
        }
        return sp;
    }

    @Override
    protected ConversationContext<Role> getSelectedContext(Role selected) {
        RoleContext roleContext = new RoleContext(selected);
        roleContext.setViewUri(RoleContext.editUri);
        return roleContext;
    }
}