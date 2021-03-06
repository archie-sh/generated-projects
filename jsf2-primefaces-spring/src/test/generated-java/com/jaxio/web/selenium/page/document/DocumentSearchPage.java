/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/SearchPage.e.vm.java
 */
package com.jaxio.web.selenium.page.document;

import static org.openqa.selenium.By.name;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jaxio.web.selenium.support.Page;
import com.jaxio.web.selenium.page.AbstractSearchPage;

@Page
public class DocumentSearchPage extends AbstractSearchPage {
    // search box
    @FindBy(id = "form:ownerSelector_input")
    public WebElement owner;

    public void editDocument(String document) {
        clickEdit(document);
    }

    public void addDocument(String document) {
        clickAdd(document);
    }

    public void deleteDocument(String document) {
        clickDelete(document);
        client.click(name("form:askForRemoveDocumentDialogYes"));
    }

    public void selectDocument(String document) {
        clickSelect(document);
    }
}