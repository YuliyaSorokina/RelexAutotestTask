package com.gmail.yuliyasor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница с результатом поиска
 */
public class ResultPage {
    public WebDriver driver;

    @FindBy(className = "search-results")
    private WebElement searchResults;

    @FindBy(partialLinkText = "Foundation Level Automotive Software Tester")
    private WebElement foundationLevelLink;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //если ничего не нашлось, контейнер search-results вообще не выводится
    public void checkSearchResult() {
        searchResults.isDisplayed();
    }

    public void clickFoundationLevelLink() {
        foundationLevelLink.click();
    }
}
