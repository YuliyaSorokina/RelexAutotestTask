package com.gmail.yuliyasor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница, на которую мы перешли из поиска
 */
public class ArticlePage {
    public WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Foundation Level Automotive Software Tester')]")
    private WebElement articleTitle;

    public ArticlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkTitle() {
        articleTitle.isDisplayed();
    }
}
