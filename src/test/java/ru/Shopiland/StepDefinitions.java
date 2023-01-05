package ru.Shopiland;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.awt.*;
import java.time.Duration;

import static org.junit.Assert.*;


/**
 * Варинаты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final mainPage MAIN_PAGE;
    public static final freePage FREE_PAGE;
    public static WebDriverWait wait;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        MAIN_PAGE = new mainPage(webDriver);
        FREE_PAGE = new freePage(webDriver);
    }

    @Test
    public void Test1() {
        MAIN_PAGE.start();
        MAIN_PAGE.mainPage();
        final var mpage1 = MAIN_PAGE.mainPage();
        final var mpage = MAIN_PAGE.URL();
        assertEquals(mpage, mpage1);

    }

    @Test
    public void Test2() {
        MAIN_PAGE.start();
        FREE_PAGE.buttonLOGO();
        final var mpage = MAIN_PAGE.mainPage();
        final var mpage1 = MAIN_PAGE.URL();
        assertEquals(mpage, mpage1);

    }

    @Test
    public void Test3() {
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        FREE_PAGE.setAllCoursButton();
        final var text = webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Онлайн-курсы по IT-профессиям']")).getText();
        assertEquals(text, "Онлайн-курсы по IT-профессиям");
    }

    @Test
    public void Test4() {
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        FREE_PAGE.DATA_SCIENCE_BUTTON();
        final var text = webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Курсы по Data Science']")).getText();
        assertEquals(text, "Курсы по Data Science");
    }

    @Test
    public void Test5() {
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        FREE_PAGE.ANALITIK_DAN();
        final var text = webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Курсы по аналитике данных']")).getText();
        assertEquals(text, "Курсы по аналитике данных");
    }

    @Test
    public void Test6() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//INPUT[@aria-label='name']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.SUBMIT_BUTTON();
        String text = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[1]")).getCssValue("display");
        assertEquals(text, "block");
        String textMail = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[2]")).getCssValue("display");
        assertEquals(textMail, "block");
        String textphone = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[3]")).getCssValue("display");
        assertEquals(textphone, "block");
    }

    @Test
    public void Test7() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//INPUT[@aria-label='name']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.NAME_INPUT_BAD();
        MAIN_PAGE.SUBMIT_BUTTON();
        String text = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[1]")).getCssValue("display");
        assertEquals(text, "block");
    }

    @Test
    public void Test8() throws Exception {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//INPUT[@aria-label='name']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.NAME_INPUT_GOOD();
        MAIN_PAGE.SUBMIT_BUTTON();
        Boolean element1 = Boolean.valueOf(MAIN_PAGE.verifyElementAbsent());
        assertEquals(element1, false);

    }

    @Test
    public void Test9() {
        MAIN_PAGE.start();
        MAIN_PAGE.FREE_COURS_BUTTON();
        String text = webDriver.findElement(By.xpath("//div[@data-field-axisy-value='top']//h1[1]")).getText();
        assertEquals(text, "Бесплатные мероприятия и материалы");
    }

    @Test
    public void Test10() {
        MAIN_PAGE.start();
        String text = webDriver.findElement(By.xpath("(//A[@href='tel:+74952910912'][text()='+7 495 291-09-12'])[2]")).getText();
        assertEquals(text, "+7 495 291-09-12");


    }

    @Test
    public void Test11() {
        MAIN_PAGE.start();
        MAIN_PAGE.COOP_BUTTON();
        String text = webDriver.findElement(By.xpath("//IMG[@class='t228__imglogo t228__imglogomobile']")).getCssValue("display");
        assertEquals(text, "block");

    }

    @Test
    public void Test12() {
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        MAIN_PAGE.STADY_BUTTON();
        ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        String text = webDriver.findElement(By.xpath("//DIV[@class='tn-atom'][text()='Магистратура и ДПО']")).getText();
        assertEquals(text, "Магистратура и ДПО");
    }

    @Test
    public void Test13() {
        MAIN_PAGE.start();
        MAIN_PAGE.COOP_BUTTON();
        webDriver.findElement(By.xpath("//A[@class='t-menu__link-item'][text()='Курсы']")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        String text = webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Онлайн-курсы по IT-профессиям']")).getText();
        assertEquals(text, "Онлайн-курсы по IT-профессиям");
    }

    @Test
    public void Test14() throws Exception {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        Boolean element1 = Boolean.valueOf(MAIN_PAGE.verifyElementAbsent1());
        assertTrue(element1);
    }

    @Test
    public void Test15() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        String text = webDriver.findElement(By.xpath("//DIV[@class='t-input-error'][text()='Обязательное поле']")).getText();
        assertEquals(text, "Обязательное поле");
    }

    @Test
    public void Test16() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//INPUT[@type='text'])[5]")).sendKeys("Иван123");
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        String text = webDriver.findElement(By.xpath("//DIV[@class='t-input-error'][text()='Укажите, пожалуйста, имя']")).getText();
        assertEquals(text, "Укажите, пожалуйста, имя");
    }

    @Test
    public void Test17() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).sendKeys("vowkaz@inbox.r1");
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        String text = webDriver.findElement(By.xpath("//DIV[@class='t-input-error'][text()='Укажите, пожалуйста, корректный email']")).getText();
        assertEquals(text, "Укажите, пожалуйста, корректный email");
    }

    @Test
    public void Test18() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//INPUT[@type='tel'])[2]")).sendKeys("1111111111");
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        Boolean text = webDriver.findElement(By.xpath("//div[text()='Укажите, пожалуйста, корректный номер телефона']")).isDisplayed();
        assertTrue(text);
    }

    @Test
    public void Test19() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//INPUT[@type='tel'])[2]")).sendKeys("9873548103");
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        String text = webDriver.findElement(By.xpath("(//div[@class='t-input t-input-phonemask__wrap'])[2]")).getCssValue("border");
        assertEquals(text, "1px solid rgb(235, 235, 235)");
    }

    @Test
    public void Test20() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys("Иван");
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        String text = webDriver.findElement(By.xpath("(//input[@name='name'])[2]")).getCssValue("border");
        assertNotEquals(text, "1px solid rgb(255, 0, 0)");
    }

    @Test
    public void Test21() {
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//U[text()='Посмотреть все курсы']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.GET_CONS_BUTTON();
        webDriver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).sendKeys("vowkaz@inbox.ru");
        webDriver.findElement(By.xpath("(//BUTTON[@type='submit'][text()='Отправить заявку'])[1]")).click();
        String text = webDriver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).getCssValue("border");
        assertNotEquals(text, "1px solid rgb(255, 0, 0)");

    }

    @After
    public void AfterAll() {
        webDriver.quit();
    }
}







