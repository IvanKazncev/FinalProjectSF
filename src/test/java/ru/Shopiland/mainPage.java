package ru.Shopiland;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;




public record mainPage(WebDriver webDriver) {

    private static final String SUBMIT_BUTTON = "//BUTTON[@type='submit'][text()='Получить консультацию']";
    private static final String NAME_UNPUT = "//INPUT[@aria-label='name']";
    private static final String URL = "https://skillfactory.ru/";
    private static final String EMAIL_INPUT = "(//INPUT[@aria-label='email'])[1]";
    private static final String TEL_INPUT = "(//INPUT[@type='tel'])[1]";
    private static final String CAPTHA_FEEDBACK = "\\/\\/div\\[\\@role\\=\\'presentation\\'\\]";
    private static final String FREE_COURS_BUTTON ="//A[@class='tn-atom'][text()='Бесплатно']";
    private static final String COOP_EDUCATION_BUTTON = "Корпоративное обучение";

    public void start () {
        webDriver.get(URL);

    }
    public void COOP_EDUCATION_BUTTON(){
        webDriver.findElement(By.linkText(COOP_EDUCATION_BUTTON)).click();
    }
    public void FREE_COURS_BUTTON(){
        webDriver.findElement(By.xpath(FREE_COURS_BUTTON)).click();
    }
    public void CAPTHA_FEEDBACK(){
        webDriver.findElement(By.className(CAPTHA_FEEDBACK)).click();
    }

    public void SUBMIT_BUTTON() {
        webDriver.findElement(By.xpath(SUBMIT_BUTTON)).click();

    }

    public void NAME_INPUT_BAD() {
        webDriver.findElement(By.xpath(NAME_UNPUT)).sendKeys("Иван123");
    }
    public void NAME_INPUT_GOOD(){
        webDriver.findElement(By.xpath(NAME_UNPUT)).sendKeys("Иван");
    }
    public void EMAIL_INPUT(){
        webDriver.findElement(By.xpath(EMAIL_INPUT)).sendKeys("Mail@mail.ru");
    }
    public void TEL_INPUT(){
        webDriver.findElement(By.xpath(TEL_INPUT)).sendKeys("1341112233");
    }



    public String mainPage() {
        return webDriver.getCurrentUrl();

    }
    public String URL(){
        return URL;
    }

}
