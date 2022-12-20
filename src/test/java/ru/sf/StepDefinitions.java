package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public static final ChooseCityPage chooseCityPage;
    public static final CityMenuPage cityMenuPage;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseCityPage = new ChooseCityPage(webDriver);
        cityMenuPage = new CityMenuPage(webDriver);
    }

    //Реализация шага
    //Текст должен строго соответствоать тексту сценария
    @Given("url of weather {string}")
    public void url_of_restaurant(String url) {
        chooseCityPage.go(url);
    }

    //Реализация шага
    @Then("chose city {string}")
    public void chose_city(String city) {
        chooseCityPage.searchCity(city);

    }

    @Then("Click on {string}")
    public void clickOnSaratov(String city) {
       chooseCityPage.button();
    }



    //Реализация шага
    @Then("assert that chosen city is {string}")
    public void assert_that_chosen_city_is(String expectedCity) {
        final var currentActiveCity = cityMenuPage.getCurrentActiveCity();
        assertEquals(expectedCity,currentActiveCity);
    }

    //Реализация шага
    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var cityNotFoundMessage = chooseCityPage.getCityNotFoundMessage();
        assertEquals(errorMessage, cityNotFoundMessage);
    }
}
