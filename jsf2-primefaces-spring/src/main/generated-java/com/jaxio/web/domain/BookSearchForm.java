/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/SearchForm.e.vm.java
 */
package com.jaxio.web.domain;

import static com.jaxio.dao.support.EntitySelector.newEntitySelector;
import static com.jaxio.dao.support.Ranges.RangeInteger.newRangeInteger;
import static com.jaxio.domain.Book_.account;
import static com.jaxio.domain.Book_.accountId;
import static com.jaxio.domain.Book_.numberOfPages;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.jaxio.dao.support.EntitySelector;
import com.jaxio.dao.support.Ranges.RangeInteger;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Account;
import com.jaxio.domain.Book;
import com.jaxio.web.domain.support.GenericSearchForm;

/**
 * Bean used to back the search page.
 * It exposes a {@link Book} instance so it can be used in search by Example query.
 */
@Named
@Scope("conversation")
public class BookSearchForm extends GenericSearchForm<Book, BookSearchForm> {
    private static final long serialVersionUID = 1L;

    private Book book = new Book();
    private RangeInteger<Book> numberOfPagesRange = newRangeInteger(numberOfPages);
    private EntitySelector<Book, Account, String> accountSelector = newEntitySelector(accountId);

    public Book getBook() {
        return book;
    }

    @Override
    protected Book getEntity() {
        return book;
    }

    // Ranges, used from the view.
    public RangeInteger<Book> getNumberOfPagesRange() {
        return numberOfPagesRange;
    }

    // Selectors for x-to-one associations
    public EntitySelector<Book, Account, String> getAccountSelector() {
        return accountSelector;
    }

    public SearchParameters toSearchParameters() {
        return new SearchParameters() //
                .anywhere() //
                .addLeftJoinAttribute(account) //
                .range(numberOfPagesRange) //
                .entitySelector(accountSelector) //
        ;
    }

    @Override
    public BookSearchForm newInstance() {
        return new BookSearchForm();
    }

    @Override
    public void resetWithOther(BookSearchForm other) {
        this.book = other.getBook();
        this.numberOfPagesRange = other.getNumberOfPagesRange();
        this.accountSelector = other.getAccountSelector();
    }
}