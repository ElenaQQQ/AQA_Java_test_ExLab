package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage extends BasePage {

//    private final By logo = By.id("logo_mobile");
//    private final By menuAbout = By.xpath("//a[@href='#about']");
//    private final By menuProjects = By.xpath("//a[@href='#projects']");
//    private final By menuMentors = By.xpath("//a[@href='#mentors']");
//    private final By menuStartUp = By.xpath("//a[@href='#startup']");
//    private final By menuBackgroundChange = By.xpath("//div[contains(@class,'fnykZs')]");
//    private final By sidePicture = By.xpath("//div[contains(@class,'sc-gsnTZi')]");
//    private final By joinButton = By.xpath("//div[@class='sc-hAZoDl hrEelO']");
//    private final By bigLogo = By.xpath("//div[@id='header']//img");
//    private final By aboutUsHeader = By.xpath("//div[@id='about']/div[1]");
//    private final By aboutUsText = By.xpath("//div[@id='about']/div/p");
//    private final By aboutUsWhyXLabHeader = By.xpath("//div[@id='about']/div/div");
//    private final By aboutUsWhyXLabText = By.xpath("//div[@id='about']/div/ol");
//    private final By aboutUsWhyXLabJoinButton = By.xpath("//div[@id='about']/div/div/a");
//    private final By projectsHeader = By.xpath("//div[@id='projects']/div/div[@data-scroll='true']");
//    private final By mentorsHeader = By.xpath("//div[@id='mentors']/div[1]");
//    private final By startUpHeader = By.xpath("//div[@id='startup']//div[contains(@data-scroll-target,'#startup')]");

    @FindBy(id = "logo_mobile")
    private WebElement logo;

    @FindBy(xpath = "//a[@href='#about']")
    private WebElement menuAbout;

    @FindBy(xpath = "//a[@href='#projects']")
    private WebElement menuProjects;

    @FindBy(xpath = "//a[@href='#mentors']")
    private WebElement menuMentors;

    @FindBy(xpath = "//a[@href='#startup']")
    private WebElement menuStartUp;

    @FindBy(xpath = "//div[contains(@class,'fnykZs')]")
    private WebElement menuBackgroundChange;

    @FindBy(xpath="//div[contains(@class,'sc-gsnTZi')]")
    private WebElement sidePicture;

    @FindBy(xpath = "//div[@class='sc-hAZoDl hrEelO']")
    private WebElement joinButton;

    @FindBy(xpath = "//div[@id='header']//img")
    private WebElement bigLogo;

    @FindBy(xpath = "//div[@id='about']/div[1]")
    private WebElement aboutUsHeader;

    @FindBy(xpath = "//div[@id='about']/div/p")
    private WebElement aboutUsText;

    @FindBy(xpath = "//div[@id='about']/div/div")
    private WebElement aboutUsWhyXLabHeader;

    @FindBy(xpath = "//div[@id='about']/div/ol")
    private WebElement aboutUsWhyXLabText;

    @FindBy(xpath = "//div[@id='about']/div/div/a")
    private WebElement aboutUsWhyXLabJoinButton;

    @FindBy(xpath = "//div[@id='projects']/div/div[contains(@data-scroll-target,'#projects')]")
    private WebElement projectsHeader;

    @FindBy(xpath = "//div[@id=\"startup\"]/div/div[contains(@data-scroll-target,'#startup')]")
    private WebElement startUpHeader;

    @FindBy(xpath = "//div[@id='mentors']/div[1]")
    private WebElement mentorsHeader;

    @FindBy (xpath = "//div[@id='mentors']//p[contains(text(),'Харлап')]/following-sibling::span")
    private WebElement mentors1InfoOpen;

    @FindBy (xpath = "//div[@id='mentors']//img[contains(@alt,'Харлап')]") //переписать!
    private WebElement mentors1Foto;

    @FindBy (xpath = "(//div[@class='sc-bUbCnL fJhsUc'])[1]") //переписать!
    private WebElement mentors1Info;

    @FindBy(xpath = "//div[@id='header']//div[contains(@class,'sc-fnykZs')]")
    private WebElement backgroundColorIcon;



    //    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]")
//    private WebElement projectsXLabHeader;
//
//    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]/following-sibling::img")
//    private WebElement projectsXLabLogo;
//
//    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]/following-sibling::p")
//    private WebElement projectsXLabText;



//    private WebElement getProjectHeader (String projectName) {
//        return driver.findElement(By.xpath("//div[@id='projects']//h2[contains(text()," + projectName + ")]"));
//    }
//
//    private WebElement getProjectLogo (String projectName) {
//        return driver.findElement(By.xpath(getProjectHeader(projectName) + "/following-sibling::img"));
//    }
//
//    private WebElement getProjectText (String projectName) {
//        return driver.findElement(By.xpath(getProjectHeader(projectName) + "/following-sibling::p"));
//    }

    public LandingPage open(){
        loadPage();
        return this;
}

    public void ifUrlExLabMatches(){
        Assert.assertEquals("http://test.exlab.team/", getUrl(),
                "TEST FAILED: Url is not the same");
    }

    public void ifTitleExLabMatches(){
        Assert.assertEquals(getTitle(),"ExLab Landing", "TEST FAILED: title is not the same");
    }

    public void ifLogoDisplayed(){
        isDisplayed(logo);
    }

    public LandingPage isMenuAboutDisplayed(){
        isDisplayed(menuAbout);
        return this;
    }

    public String takeBackgroungClass(){

        return backgroundColorIcon.getAttribute("class");
    }

    public LandingPage menuAboutUsClick(){
        menuAbout.click();
        return this;
    }

    public LandingPage moveToAboutUsMenu() throws InterruptedException {
        moveTo(menuAbout);
        return this;
    }

    public void isAboutUsHeaderDisplayed()  {
        isDisplayed(aboutUsHeader);
    }

    public void isMenuProjectDisplayed(){
        isDisplayed(menuProjects);
    }

    public LandingPage menuProjectsClick() throws InterruptedException {
        delayAndClick(menuProjects);
        return this;
    }

    public LandingPage isProjectsHeaderDisplayed(){
        isDisplayed(projectsHeader);
        return this;
    }

    public void isMenuMentorsDisplayed(){
        isDisplayed(menuMentors);
    }

    public LandingPage menuMentorsClick() throws InterruptedException {
        delayAndClick(menuMentors);
        return this;
    }

    public LandingPage isMentorsHeaderDisplayed() throws InterruptedException {
        isDisplayed(mentorsHeader);
        return this;
    }

    public void isMenuStartUpDisplayed(){
        isDisplayed(menuStartUp);
    }

    public LandingPage menuStartUpClick() throws InterruptedException {
        delayAndClick(menuStartUp);
        return this;
    }

    public void isStartUpHeaderDisplayed(){
        isDisplayed(startUpHeader);
    }

    public void backgroundColorIconDisplayed(){
        isDisplayed(backgroundColorIcon);
    }

    public LandingPage moveToMentorsHeader() throws InterruptedException {
        moveTo(mentorsHeader);
//        js.executeScript("arguments[0].scrollIntoView();", mentorsHeader);

        return this;
    }

    public LandingPage clickMentorsInfoOpen() throws InterruptedException {
        delayAndClick(mentors1InfoOpen);
        return this;
    }

    public Boolean checkMentorsInfo()  {
        return mentors1Info.isDisplayed();
    }



    public LandingPage scrollToTheEnd() throws InterruptedException {
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", aboutUsWhyXLabHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", projectsHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", mentorsHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", startUpHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", menuAbout);
//        Thread.sleep(500);
//        js.executeScript("arguments[0].scrollIntoView();", );
//        js.executeScript("arguments[0].scrollIntoView();", );
//        js.executeScript("arguments[0].scrollIntoView();", );
//        js.executeScript("arguments[0].scrollIntoView();", );
        return this;
    }

}
