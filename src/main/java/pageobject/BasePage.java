package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

import static driver.driver.getDriver;
public abstract  class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected String baseUrl = "http://test.exlab.team/";

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver,this);
    }



    public void loadPage () {
        driver.get(baseUrl);
//        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getMenuLink(WebElement locator){
        return locator.getAttribute("data-scroll-to");
    }

    public void changeToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
//        return this;
    }

//    public JavascriptExecutor js;
//    public void isElementDisplayed(WebElement elementLocator){
//        js.executeScript("arguments[0].scrollIntoView();", elementLocator);
//        Assert.assertTrue(elementLocator.isDisplayed(),
//                "-----\nTEST FAILED: Element " + elementLocator.getText() + " is not displayed\n-----");
//
//        System.out.println("-----\nTEST PASSED: Element " + elementLocator.getText() + " is displayed\n-----");
//    }



    public void isDisplayed(WebElement locator) {
//        Wait <WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                        .pollingEvery(Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.visibilityOf(locator));
        Assert.assertTrue(locator.isDisplayed(),
                "TEST FAILED: Element "+ locator.getText() + " is not displayed");
        System.out.println("TEST PASSED: Element " + locator.getText() + " is displayed");
    }

    protected void moveTo(WebElement locator){
        actions.scrollToElement(locator).build().perform();
    }

    public void click(WebElement locator){
        locator.click();

    }
}

