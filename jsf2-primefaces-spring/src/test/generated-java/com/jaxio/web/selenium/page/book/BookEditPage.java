/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.jaxio.web.selenium.page.book;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.jaxio.web.selenium.page.AbstractEditPage;
import com.jaxio.web.selenium.support.Page;

@Page
public class BookEditPage extends AbstractEditPage {
    // edit box
    @FindBy(id = "form:title")
    public WebElement title;
    @FindBy(id = "form:numberOfPages")
    public WebElement numberOfPages;

    // many-to-one owner
    @FindBy(id = "form:owner")
    public WebElement owner;
    @FindBy(id = "form:viewOwner")
    public WebElement ownerViewButton;

}