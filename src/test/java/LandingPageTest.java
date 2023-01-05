import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageobject.BasePage;
import pageobject.LandingPage;

import java.time.Duration;

import static driver.driver.*;

public class LandingPageTest extends BasePageTest {

    public LandingPage landingPage;
    public BasePage basePage1;
    public JavascriptExecutor js;

    @BeforeMethod
    public void start () {

        createDriver();
        landingPage = new LandingPage();
        landingPage.open();
        basePage1 = new BasePage();
        js = (JavascriptExecutor) getDriver();
    }

    @AfterMethod
    public void finish() {
        quite();
    }

    public void isElementDisplayed(WebElement elementLocator){
        js.executeScript("arguments[0].scrollIntoView();", elementLocator);
        Assert.assertTrue(elementLocator.isDisplayed(),
                "-----\nTEST FAILED: Element " + elementLocator.getText() + " is not displayed\n-----");
        System.out.println("-----\nTEST PASSED: Element " + elementLocator.getText() + " is displayed\n-----");
    }

    @Test
    public void aboutUsHeaderIsDisplayed(){
        isElementDisplayed(landingPage.getAboutUsHeader());
    }

    @Test
    public void aboutUsTextIsDisplayed(){
        isElementDisplayed(landingPage.getAboutUsText());
    }

}
