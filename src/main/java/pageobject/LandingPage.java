package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//div[@id='header']//img")
    private WebElement bigLogo;

    public WebElement getBigLogo() {
        return bigLogo;
    }

    @FindBy(xpath = "//div[@id='about']/div[1]")
    private WebElement aboutUsHeader;

    public WebElement getAboutUsHeader() {
        return aboutUsHeader;
    }

    @FindBy(xpath = "//div[@id='about']/div/p")
    private WebElement aboutUsText;

    public WebElement getAboutUsText() {
        return aboutUsText;
    }

    @FindBy(xpath = "//div[@id='about']/div/div")
    private WebElement aboutUsWhyXLabHeader;

    public WebElement getAboutUsWhyXLabHeader() {
        return aboutUsWhyXLabHeader;
    }

    @FindBy(xpath = "//div[@id='about']/div/ol")
    private WebElement aboutUsWhyXLabText;

    public WebElement getAboutUsWhyXLabText() {
        return aboutUsWhyXLabText;
    }

    @FindBy(xpath = "//div[@id='about']/div/div/a")
    private WebElement aboutUsWhyXLabJoinButton;

    public WebElement getAboutUsWhyXLabJoinButton() {
        return aboutUsWhyXLabJoinButton;
    }

    @FindBy(xpath = "//div[@id='projects']/div/div[@data-scroll='true']")
    private WebElement projectsHeader;

    public WebElement getProjectsHeader() {
        return projectsHeader;
    }

    //    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]")
//    private WebElement projectsXLabHeader;
//
//    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]/following-sibling::img")
//    private WebElement projectsXLabLogo;
//
//    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]/following-sibling::p")
//    private WebElement projectsXLabText;



    private WebElement getProjectHeader (String projectName) {
        return driver.findElement(By.xpath("//div[@id='projects']//h2[contains(text()," + projectName + ")]"));
    }

    private WebElement getProjectLogo (String projectName) {
        return driver.findElement(By.xpath(getProjectHeader(projectName) + "/following-sibling::img"));
    }

    private WebElement getProjectText (String projectName) {
        return driver.findElement(By.xpath(getProjectHeader(projectName) + "/following-sibling::p"));
    }




}
