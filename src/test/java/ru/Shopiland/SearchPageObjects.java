package ru.Shopiland;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



//Имплементация паттерна Page Object Model
public record SearchPageObjects(WebDriver webDriver) {

    private static final String SEARCH_BUTTON = "(//A[@class='css-1xrqwep'])[1]\n";
    private static final String SARATOV = "Волжский район, Саратов";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "//H1[@class='title title_level_1'][text()='По вашему запросу ничего не нашлось']";
    private static final String URL = "https://shopiland.ru/";

    public void go(String url) {
        webDriver.get(url);

    }

    public void button(String city) {
        final var searchInput = webDriver.findElement(By.xpath(SEARCH_BUTTON));
        searchInput.sendKeys(city, Keys.ENTER);

    }

    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.xpath(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
    public void button (){
        webDriver.findElement(By.xpath(SEARCH_BUTTON)).click();

    }
    public String mainPage() {
        return webDriver.getCurrentUrl();
    }
    public String URL(){
        return URL;
    }
}
