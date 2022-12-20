package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record CityMenuPage(WebDriver webDriver) {

    private final static String ACTIVE_CITY_SPAN_CLASSNAME = "//H1[@id='main_title']";

    public String getCurrentActiveCity() {
        return webDriver.findElement(By.xpath(ACTIVE_CITY_SPAN_CLASSNAME)).getText();

    }
}
