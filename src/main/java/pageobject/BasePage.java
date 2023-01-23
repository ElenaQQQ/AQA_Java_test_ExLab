package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

//import static driver.driver.actions;
import static driver.driver.getDriver;
public abstract  class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    protected String baseUrl = "http://test.exlab.team/";

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) getDriver();



    }

    public void loadPage () {      driver.get(baseUrl);    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void changeToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
//        return this;
    }

    public JavascriptExecutor js;

    public void isDisplayed(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        Assert.assertTrue(locator.isDisplayed(),
                "TEST FAILED: Element "+ locator.getText() + " is not displayed");
        System.out.println("TEST PASSED: Element " + locator.getText() + " is displayed");
    }

    public void isDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        Assert.assertTrue(driver.findElement(locator).isDisplayed(),
                "TEST FAILED: Element "+ driver.findElement(locator).getText() + " is not displayed");
        System.out.println("TEST PASSED: Element " + locator.toString() + " is displayed");
    }

    protected void moveTo(WebElement webElement) throws InterruptedException {
//        Assert.assertNotNull(actions, "actions is null");
//        Thread.sleep(500);
        actions.scrollToElement(webElement).build().perform();

//        js.executeScript("arguments[0].scrollIntoView();", locator);
    }

    protected void moveTo(By locator) throws InterruptedException {
//        Assert.assertNotNull(actions, "actions is null");
        Thread.sleep(200);
        actions.scrollToElement(driver.findElement(locator)).build().perform();

//        js.executeScript("arguments[0].scrollIntoView();", locator);
    }

    public void delayAndClick(WebElement locator) throws InterruptedException {
        Thread.sleep(500);
        locator.click();
    }




}

