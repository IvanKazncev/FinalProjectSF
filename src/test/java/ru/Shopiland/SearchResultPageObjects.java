package ru.Shopiland;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;

public record SearchResultPageObjects(WebDriver webDriver) {

    private final static String RATING_FIRST_PICTURE = "css-1t0tstb";
    private final static String RATING_SECOND_PICTURE = "css-1t0tstb";
    private final static String FIRST_BUTTON_FEEDBACK = "(//BUTTON[@tabindex='0'][text()='отзывы'])[1]";
    private final static String SECOND_BUTTON_FEEDBACK = "(//BUTTON[@tabindex='0'][text()='отзывы'])[2]";
    private final static String LOGO = "//SPAN[@class='MuiBox-root css-xe57hi'][text()='Shopiland']";
    private final static String CLOSE_POPUP_BUTTON = "//body";

    public void  FIRST_BUTTON_FEEDBACK() {
         webDriver.findElement(By.xpath(FIRST_BUTTON_FEEDBACK)).click();
    }
    public void SECOND_BUTTON_FEEDBACK() {
        webDriver.findElement(By.xpath(SECOND_BUTTON_FEEDBACK)).click();
    }
    public void button1(){
     webDriver.findElement(By.xpath(LOGO)).click();
    }

    public int getRatingFirstPicture() {
        int ratingOne = Integer.parseInt(webDriver.findElement(By.className(RATING_FIRST_PICTURE)).getText().replaceAll("\\D+",""));
        return ratingOne;

    }
    public int getRatingSecondPicture() {
        int ratingTwo = Integer.parseInt(webDriver.findElement(By.className(RATING_SECOND_PICTURE)).getText().replaceAll("\\D+",""));
        return ratingTwo;


    }


}

