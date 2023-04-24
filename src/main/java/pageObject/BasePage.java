package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;

import static utils.Config.*;
import static driver.Driver.getDriver;
public abstract  class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) getDriver();
    }

    public void loadPage () {      driver.get(BASE_URL);    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void changeToNewTab() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        Thread.sleep(5000);
    }

    public JavascriptExecutor js;

    public Boolean isDisplayed(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        System.out.println("TEST PASSED: Element " + locator.getText() + " is displayed");
        return locator.isDisplayed();

    }

    public Boolean isDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//        System.out.println("TEST PASSED: Element " + locator.getText() + " is displayed");
//        return locator.isDisplayed();
        return driver.findElement(locator).isDisplayed();
    }

    protected void moveTo(WebElement webElement) throws InterruptedException {
        Thread.sleep(THREAD_SLEEP_WAIT);
        actions.scrollToElement(webElement).build().perform();
//        js.executeScript("arguments[0].scrollIntoView();", locator);
    }

    protected void moveTo(By locator) throws InterruptedException {
        Thread.sleep(THREAD_SLEEP_WAIT);
        actions.scrollToElement(driver.findElement(locator)).build().perform();
    }

    public void delayAndClick(WebElement locator) throws InterruptedException {
        Thread.sleep(THREAD_SLEEP_WAIT); //клик делается с задержкой, так как прогрузка страницы идет по блокам и некорректно
        locator.click();
    }

}

