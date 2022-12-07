package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    @FindBy(id = "logo-mobile")
    private WebElement logo;

    @FindBy(xpath = "//button[@class='sc-ftvSup llXOnR']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@href='#about']")
    private WebElement menuAbout;

    @FindBy(xpath = "//a[@href='#//a[@href='#projects']']")
    private WebElement menuProjects;

    @FindBy(xpath = "//a[@href='#mentors']")
    private WebElement menuMentors;

    @FindBy(xpath = "//a[@href='#startup']")
    private WebElement menuStartUp;

    @FindBy(xpath = "//div[@class='sc-fnykZs fEkGUM']")
    private WebElement menuSunIcon;
}
