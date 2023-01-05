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
    private WebElement logo;

    public WebElement getLogo() {
        return logo;
    }

    @FindBy(xpath = "//a[@href='#about']")
    private WebElement menuAbout;

    public WebElement getMenuAbout() {
        return menuAbout;
    }

    @FindBy(xpath = "//a[@href='#projects']")
    private WebElement menuProjects;

    public WebElement getMenuProjects() {
        return menuProjects;
    }

    @FindBy(xpath = "//a[@href='#mentors']")
    private WebElement menuMentors;

    public WebElement getMenuMentors() {
        return menuMentors;
    }

    @FindBy(xpath = "//a[@href='#startup']")
    private WebElement menuStartUp;

    public WebElement getMenuStartUp() {
        return menuStartUp;
    }

    @FindBy(xpath = "//div[contains(@class,'fnykZs')]")
    private WebElement menuBackgroundChange;

    public WebElement getMenuBackgroundChange() {
        return menuBackgroundChange;
    }

    @FindBy(xpath="//div[contains(@class,'sc-gsnTZi')]")
    private WebElement sidePicture;

    public WebElement getSidePicture() {
        return sidePicture;
    }

    @FindBy(xpath = "//div[@class='sc-hAZoDl hrEelO']")
    private WebElement joinButton;

    public WebElement getJoinButton() {
        return joinButton;
    }

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

    public String getMenuLink(WebElement locator){
        return locator.getAttribute("data-scroll-to");
    }

    public BasePage changeToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        return this;
    }
}

