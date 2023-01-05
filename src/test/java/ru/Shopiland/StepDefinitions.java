package ru.Shopiland;
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
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(30));
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
       Assert.assertEquals(mpage,mpage1);

    }
    @Test
    public void Test2(){
        MAIN_PAGE.start();
        FREE_PAGE.buttonLOGO();
        final var mpage = MAIN_PAGE.mainPage();
        final var mpage1 = MAIN_PAGE.URL();
        Assert.assertEquals(mpage,mpage1);

    }
    @Test
    public void Test3(){
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        FREE_PAGE.setAllCoursButton();
        final var text =webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Онлайн-курсы по IT-профессиям']")).getText();
        Assert.assertEquals(text,"Онлайн-курсы по IT-профессиям");
    }
    @Test
    public void Test4(){
         MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        FREE_PAGE.DATA_SCIENCE_BUTTON();
        final var text = webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Курсы по Data Science']")).getText();
        Assert.assertEquals(text,"Курсы по Data Science" );
    }
    @Test
    public void Test5(){
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        FREE_PAGE.ANALITIK_DAN();
        final var text =webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Курсы по аналитике данных']")).getText();
        Assert.assertEquals(text,"Курсы по аналитике данных" );
    }
    @Test
    public void Test6(){
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//INPUT[@aria-label='name']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.SUBMIT_BUTTON();
        String text = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[1]")).getCssValue("display");
        Assert.assertEquals(text,"block");
        String textMail = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[2]")).getCssValue("display");
        Assert.assertEquals(textMail, "block");
        String textphone = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[3]")).getCssValue("display");
        Assert.assertEquals(textphone,"block");
    }
    @Test
    public void Test7(){
        MAIN_PAGE.start();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath("//INPUT[@aria-label='name']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        MAIN_PAGE.NAME_INPUT_BAD();
        MAIN_PAGE.SUBMIT_BUTTON();
        String text = webDriver.findElement(By.xpath("(//DIV[@class='t-input-error'][text()='Обязательное поле'])[1]")).getCssValue("display");
        Assert.assertEquals(text,"block");
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
        Assert.assertEquals(element1,false);

    }
    @Test
    public void Test9(){
        MAIN_PAGE.start();
        MAIN_PAGE.FREE_COURS_BUTTON();
        String text = webDriver.findElement(By.xpath("//div[@data-field-axisy-value='top']//h1[1]")).getText();
        Assert.assertEquals(text,"Бесплатные мероприятия и материалы");
    }
    @Test
    public void Test10() {
        MAIN_PAGE.start();
        String text = webDriver.findElement(By.xpath("(//A[@href='tel:+74952910912'][text()='+7 495 291-09-12'])[2]")).getText();
        Assert.assertEquals(text,"+7 495 291-09-12");


    }
    @Test
    public void Test11(){
        MAIN_PAGE.start();
        MAIN_PAGE.COOP_BUTTON();
        String text = webDriver.findElement(By.xpath("//IMG[@class='t228__imglogo t228__imglogomobile']")).getCssValue("display");
        Assert.assertEquals(text,"block");

    }
    @Test
    public void Test12(){
        MAIN_PAGE.start();
        FREE_PAGE.onlineCousButton();
        MAIN_PAGE.STADY_BUTTON();
        ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        String text =  webDriver.findElement(By.xpath("//DIV[@class='tn-atom'][text()='Магистратура и ДПО']")).getText();
        Assert.assertEquals(text,"Магистратура и ДПО");
    }
    @Test
    public void Test13(){
        MAIN_PAGE.start();
        MAIN_PAGE.COOP_BUTTON();
        webDriver.findElement(By.xpath("//A[@class='t-menu__link-item'][text()='Курсы']")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        String text = webDriver.findElement(By.xpath("//H1[@class='t795__title t-title t-title_xs t-margin_auto'][text()='Онлайн-курсы по IT-профессиям']")).getText();
        Assert.assertEquals(text,"Онлайн-курсы по IT-профессиям");
    }
}






