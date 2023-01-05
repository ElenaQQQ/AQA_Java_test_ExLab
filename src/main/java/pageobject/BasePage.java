package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

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

    @FindBy(xpath = "//a[@href='#about']")
    public WebElement menuAbout;

    @FindBy(xpath = "//a[@href='#projects']")
    public WebElement menuProjects;

    @FindBy(xpath = "//a[@href='#mentors']")
    public WebElement menuMentors;

    @FindBy(xpath = "//a[@href='#startup']")
    public WebElement menuStartUp;

    @FindBy(xpath = "//div[contains(@class,'fnykZs')]")
    public WebElement menuBackgroundChange;

    @FindBy(xpath="//div[contains(@class,'sc-gsnTZi')]")
    public WebElement sidePicture;

    @FindBy(xpath = "//div[@class='sc-hAZoDl hrEelO']")
    private WebElement joinButton;

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

    public WebElement getJoinButton() {
        return joinButton;
    }

    public BasePage changeToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
//        System.out.println("Tabs: " + tabs);
        getDriver().switchTo().window(tabs.get(1));
        return this;
    }
}

