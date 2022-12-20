package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//Что такое record 'https://www.baeldung.com/java-record-keyword'

//Имплементация паттерна Page Object Model
public record ChooseCityPage(WebDriver webDriver) {

    private static final String SEARCH_FIELD_CLASS = "//INPUT[@class='mini-suggest-form__input mini-suggest__input']";
    private static final String SARATOV = "Волжский район, Саратов";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "//H1[@class='title title_level_1'][text()='По вашему запросу ничего не нашлось']";

    public void go(String url) {
        webDriver.get(url);
    }

    public void searchCity(String city) {
        final var searchInput = webDriver.findElement(By.xpath(SEARCH_FIELD_CLASS));
        searchInput.sendKeys(city, Keys.ENTER);

    }

    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.xpath(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
    public void button (){
        webDriver.findElement(By.linkText(SARATOV)).click();

    }
}
