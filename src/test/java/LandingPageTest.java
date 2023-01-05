import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.example.factory.WebDriverFactory;

import pageobject.BasePage;
import pageobject.LandingPage;

import java.time.Duration;

import static driver.driver.*;

public class LandingPageTest extends BasePageTest {

    public LandingPage landingPage;

    public BasePage basePage1;

    @BeforeMethod
    public void start () {

        createDriver();
        landingPage = new LandingPage();
        landingPage.open();
        basePage1 = new BasePage();
    }

    @AfterMethod
    public void finish() {
        quite();
    }



    @Test
    public void isAboutUsHeaderIsDisplayed(){

        basePage1.menuAbout.click();
        WebElement firstResult = new WebDriverWait(getDriver(),Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='about']/div[1]")));
        Assert.assertTrue(landingPage.aboutUsHeader.isDisplayed());
    }
}
