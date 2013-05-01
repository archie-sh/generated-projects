/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/AbstractEditPage.p.vm.java
 */
package com.jaxio.web.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jaxio.web.selenium.support.Client;

public abstract class AbstractEditPage extends HomePage {
    @FindBy(id = "form:messages")
    public WebElement messages;

    // buttons
    @FindBy(id = "form:quit")
    public WebElement quitButton;
    @FindBy(id = "form:delete")
    public WebElement deleteButton;
    @FindBy(name = "form:saveAndClose")
    public WebElement saveButton;
    @FindBy(name = "form:close")
    public WebElement closeButton;
    @FindBy(name = "form:ok")
    public WebElement okButton;

    protected Client client;

    public void delete() {
        client.click(quitButton);
    }

    public void save() {
        client.click(saveButton);
    }

    public void close() {
        client.click(closeButton);
    }

    public void ok() {
        client.click(okButton);
    }

    protected void clickEdit(String value) {
        client.clickLinkTitle("Edit " + value);
    }

    protected void clickSearch(String value) {
        client.clickLinkTitle("Search " + value);
    }

    protected void clickAdd(String value) {
        client.clickLinkTitle("Add " + value);
    }

    protected void clickDelete(String value) {
        client.clickLinkTitle("Remove " + value);
    }

    protected void clickSelect(String value) {
        client.clickLinkTitle("Select " + value);
    }
}