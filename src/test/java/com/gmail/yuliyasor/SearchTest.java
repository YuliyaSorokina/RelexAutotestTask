package com.gmail.yuliyasor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    public static WebDriver driver;
    public static SearchPage searchPage;
    public static ResultPage resultPage;
    public static ArticlePage articlePage;

    //Начальные настройки. chromedriver должен находиться по пути C:\Program Files (x86)\Google\chromedriver.exe
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
        articlePage = new ArticlePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.istqb.org/");
    }

    @Test
    public void searchTest() {
        //Принимаем соглашение, иначе это окно блокирует элементы
        searchPage.clickAcceptedBtn();
        //Вводим фразу в поле поиска
        searchPage.inputSearchPhrase("Foundation Level 2018");
        //нажимаем enter
        searchPage.pressEnterSearch();
        //проверяем, что результат поиска не пустой
        resultPage.checkSearchResult();
        //кликаем по требуемой ссылке
        resultPage.clickFoundationLevelLink();
        //Проверяем, что на странице присутствует требуемый заголовок
        articlePage.checkTitle();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
