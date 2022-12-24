package ru.Shopiland;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * Варинаты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final SearchPageObjects SEARCH_PAGE_OBJECTS;
    public static final SearchResultPageObjects SEARCH_RESULT_PAGE_OBJECTS;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        SEARCH_PAGE_OBJECTS = new SearchPageObjects(webDriver);
        SEARCH_RESULT_PAGE_OBJECTS = new SearchResultPageObjects(webDriver);
    }

    //Реализация шага
    //Текст должен строго соответствоать тексту сценария
    @Given("url {string}")
    public void url (String url) {
        SEARCH_PAGE_OBJECTS.go(url);
    }

    //Реализация шага
    @Then("click button {string}")
    public void click_button(String string) {
      SEARCH_PAGE_OBJECTS.button();
    }
    @Then("click {string} button")
    public void click_button1(String string) {
        SEARCH_RESULT_PAGE_OBJECTS.button1();

    }
    @Then("assert that we back for {string}")
    public void assert_that_we_back_for(String string) {
     final var maiPage = SEARCH_PAGE_OBJECTS.mainPage();
     final var urlPage = SEARCH_PAGE_OBJECTS.URL();
     assertEquals(maiPage, urlPage);
    }
    @Then("look on {string}")
    public void look_on(String string) {
        SEARCH_RESULT_PAGE_OBJECTS.FIRST_BUTTON_FEEDBACK();
        SEARCH_RESULT_PAGE_OBJECTS.getRatingFirstPicture();
        webDriver.navigate().refresh();
    }
    @Then("look2 on {string}")
    public void look2_on(String string) {
        SEARCH_RESULT_PAGE_OBJECTS.SECOND_BUTTON_FEEDBACK();
        SEARCH_RESULT_PAGE_OBJECTS.getRatingSecondPicture();
    }
    @Then("assert that {string} more then {string}")
    public void assert_that_more_then(String string, String string2) {
        final int raitingOne = SEARCH_RESULT_PAGE_OBJECTS.getRatingFirstPicture();
        final int raitingTwo = SEARCH_RESULT_PAGE_OBJECTS.getRatingSecondPicture();
        Assert.assertTrue(raitingOne > raitingTwo);

    }




