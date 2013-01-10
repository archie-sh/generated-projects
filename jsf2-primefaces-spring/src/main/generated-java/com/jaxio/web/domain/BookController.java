/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Controller.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import com.jaxio.domain.Book;
import com.jaxio.repository.BookRepository;
import com.jaxio.web.conversation.Conversation;
import com.jaxio.web.conversation.ConversationFactory;
import com.jaxio.web.domain.AccountContext;
import com.jaxio.web.domain.support.GenericController;

/**
 * Stateless controller for {@link Book}.
 */
@Named
@Singleton
public class BookController extends GenericController<Book, Integer> implements ConversationFactory {

    @Inject
    public BookController(BookRepository bookRepository) {
        super(bookRepository);
    }

    // --------------------------------------------
    // ConversationFactory impl
    // --------------------------------------------

    @Override
    public boolean canCreateConversation(HttpServletRequest request) {
        return BookContext.selectUri.equals(request.getServletPath());
    }

    @Override
    public Conversation createConversation(HttpServletRequest request) {
        String uri = request.getServletPath();
        if (BookContext.selectUri.equals(uri)) {
            Conversation conversation = Conversation.newInstance(request);
            BookContext ctx = new BookContext();
            ctx.setLabelWithKey("book");
            ctx.setViewUri(BookContext.selectUri);
            conversation.push(ctx);
            return conversation;
        }

        throw new IllegalStateException("Unexpected conversation creation demand");
    }

    // --------------------------------------------
    // account association
    // --------------------------------------------

    public String viewAccount() {
        AccountContext ctx = new AccountContext(bookContext().getBook().getAccount());
        ctx.setLabelWithKey("book_account");
        ctx.setViewUri(AccountContext.editUri);
        conversation().pushSubReadOnly(ctx);
        return ctx.view();
    }

    protected final BookContext bookContext() {
        return conversation().getCurrentContext();
    }
}