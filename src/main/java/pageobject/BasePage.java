package pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static driver.driver.*;
public class BasePage {

    protected WebDriver driver;

    protected String baseUrl = "http://test.exlab.team/";

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "logo_mobile")
    public WebElement logo;

    @FindBy(xpath = "//button[@class='sc-ftvSup llXOnR']")
    public WebElement menuButton;

    @FindBy(xpath = "//a[@href='#about']")
    public WebElement menuAbout;

    @FindBy(xpath = "//a[@href='#projects']")
    public WebElement menuProjects;

    @FindBy(xpath = "//a[@href='#mentors']")
    public WebElement menuMentors;

    @FindBy(xpath = "//a[@href='#startup']")
    public WebElement menuStartUp;

    @FindBy(xpath = "//div[@class='sc-fnykZs fEkGUM']")
    public WebElement menuSunIcon;

    public BasePage open () {
        driver.get(baseUrl);
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

//    public String getBackgroundClass() {
//        return menuSunIcon.getClass();
//    }

//    public WebElement getLogo() {
//        return logo;
//    }

    public String getMenuLink(WebElement locator){
        return locator.getAttribute("data-scroll-to");
    }
}

