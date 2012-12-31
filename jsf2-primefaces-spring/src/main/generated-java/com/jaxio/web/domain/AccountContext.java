/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Context.e.vm.java
 */
package com.jaxio.web.domain;

import com.jaxio.domain.Account;
import com.jaxio.domain.Book;
import com.jaxio.domain.Document;
import com.jaxio.domain.Role;
import com.jaxio.web.conversation.ConversationContext;
import com.jaxio.web.util.TabBean;

/**
 * The context for {@link Account} edit/select views.
 */
public class AccountContext extends ConversationContext<Account> {
    private static final long serialVersionUID = 1L;
    public final static String editUri = "/domain/accountEdit.faces";
    public final static String selectUri = "/domain/accountSelect.faces";

    public AccountContext() {
    }

    public AccountContext(Account account) {
        setVar("account", account);
        setVar("tabBean", new TabBean());
        setDataModel("books", account.getBooks());
        setDataModel("documents", account.getDocuments());
        setDataModel("roles", account.getRoles());
    }

    /**
     * Developer friendly method to get the entity. Use it from Java code for better clarity.
     */
    public Account getAccount() {
        return getEntity();
    }

    @Override
    public Account getEntity() {
        return getVar("account", Account.class);
    }

    public Book getSelectedBook() {
        return getDataModel("books", Book.class).getSelectedRow();
    }

    public Document getSelectedDocument() {
        return getDataModel("documents", Document.class).getSelectedRow();
    }

    public Role getSelectedRole() {
        return getDataModel("roles", Role.class).getSelectedRow();
    }
}