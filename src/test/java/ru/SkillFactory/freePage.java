package ru.SkillFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record freePage(WebDriver webDriver) {

    private final static String ONLINE_COURSE_BUTTON = "//a[contains(@class,'tn-atom t978__tm-link')]";
    private final static String ALL_COURSE_BUTTON = "//SPAN[@class='t978__link-inner'][text()='Все онлайн-курсы']";
    private final static String DATA_SCIENCE_BUTTON = "//SPAN[@class='t978__link-inner'][text()='Data Science']";
    private final static String ANALITIK_DAN = "//SPAN[@class='t978__link-inner'][text()='Аналитика данных']";
    private final static String LOGO = "(//IMG[@class='tn-atom__img t-img loaded'])[9]";
    private final static String CLOSE_POPUP_BUTTON = "//body";
    public static String COOP_URL = "https://new.skillfactory.ru/corporativnoye-obuchenye?_ga=2.215273616.607538396.1672844459-827315559.1672844459";

    public void  DATA_SCIENCE_BUTTON() {
         webDriver.findElement(By.xpath(DATA_SCIENCE_BUTTON)).click();
    }
    public void ANALITIK_DAN() {
        webDriver.findElement(By.xpath(ANALITIK_DAN)).click();
    }
    public void buttonLOGO(){
     webDriver.findElement(By.xpath(LOGO)).click();
    }

    public void onlineCousButton(){
        webDriver.findElement(By.xpath(ONLINE_COURSE_BUTTON)).click();
    }
    public void setAllCoursButton(){
        webDriver.findElement(By.xpath(ALL_COURSE_BUTTON)).click();
    }

    }



