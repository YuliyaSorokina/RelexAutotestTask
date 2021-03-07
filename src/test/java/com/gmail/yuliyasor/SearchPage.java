package com.gmail.yuliyasor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница, на которой осуществляется поиск
 */
public class SearchPage {

    public WebDriver driver;

    @FindBy(partialLinkText = "Accept cookies")
    private WebElement acceptCookiesBtn;

    @FindBy(id = "mod-search-searchword") //Поле поиска
    private WebElement searchField;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickAcceptedBtn() {
        acceptCookiesBtn.click();
    }

    public void inputSearchPhrase(String phrase) {
        searchField.click();
        searchField.sendKeys(phrase);
    }

    public void pressEnterSearch() {
        searchField.sendKeys(Keys.ENTER);
    }

}
