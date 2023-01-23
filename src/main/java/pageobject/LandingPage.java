package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage extends BasePage {

    @FindBy(id = "logo_mobile")
    private WebElement logo;

    @FindBy(xpath = "//a[@href='#about']")
    private WebElement menuAboutUs;

    @FindBy(xpath = "//a[@href='#projects']")
    private WebElement menuProjects;

    @FindBy(xpath = "//a[@href='#mentors']")
    private WebElement menuMentors;

    @FindBy(xpath = "//a[@href='#startup']")
    private WebElement menuStartUp;

    @FindBy(xpath = "//div[@id='header']//div[contains(@class,'sc-fnykZs')]")
    private WebElement backgroundColorChangeButton;

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

    public void ifTitleExLabMatches(){
        Assert.assertEquals(getTitle(),"ExLab Landing", "TEST FAILED: title is not the same");
    }

    public Boolean isLogoDisplayed(){
        return isDisplayed(logo);
    }

    public Boolean isMenuAboutDisplayed(){
        return isDisplayed(menuAboutUs);
    }

    public String takeBackgroungClass(){
        return backgroundColorChangeButton.getAttribute("class");
    }

    public LandingPage menuAboutUsClick(){
        menuAboutUs.click();
        return this;
    }

    public LandingPage moveToAboutUsMenu() throws InterruptedException {
        moveTo(menuAboutUs);
        return this;
    }

    public Boolean isAboutUsHeaderDisplayed()  {
        return isDisplayed(aboutUsHeader);
    }

    public Boolean isMenuProjectDisplayed(){
        return isDisplayed(menuProjects);
    }

    public LandingPage menuProjectsClick() throws InterruptedException {
        delayAndClick(menuProjects);
        return this;
    }

    public Boolean isProjectsHeaderDisplayed(){
        return isDisplayed(projectsHeader);
    }

    public Boolean isMenuMentorsDisplayed(){
        return isDisplayed(menuMentors);
    }

    public LandingPage menuMentorsClick() throws InterruptedException {
        delayAndClick(menuMentors);
        return this;
    }

    public Boolean isMentorsHeaderDisplayed()  {
        return isDisplayed(mentorsHeader);
    }

    public Boolean isMenuStartUpDisplayed(){
        return isDisplayed(menuStartUp);
    }

    public LandingPage menuStartUpClick() throws InterruptedException {
        delayAndClick(menuStartUp);
        return this;
    }

    public Boolean isStartUpHeaderDisplayed(){
        return isDisplayed(startUpHeader);
    }

    public Boolean isBackgroundColorChangeButtonDisplayed(){
        return isDisplayed(backgroundColorChangeButton);
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

    public Boolean checkMentorsInfo() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("mentors1Info.isDisplayed() - " + mentors1Foto.isDisplayed());
        return mentors1Foto.isDisplayed();
    }

    public LandingPage scrollToTheEnd()  {
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", aboutUsWhyXLabHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", projectsHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", mentorsHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", startUpHeader);
//        Thread.sleep(500);
        js.executeScript("arguments[0].scrollIntoView();", menuAboutUs);
//        Thread.sleep(500);
//        js.executeScript("arguments[0].scrollIntoView();", );
//        js.executeScript("arguments[0].scrollIntoView();", );
//        js.executeScript("arguments[0].scrollIntoView();", );
//        js.executeScript("arguments[0].scrollIntoView();", );
        return this;
    }

    public LandingPage clickBackgroundColorChangeButton() throws InterruptedException {
        delayAndClick(backgroundColorChangeButton);
        return this;
    }

    public Boolean isJoinButtonDisplayed(){
        return isDisplayed(joinButton);
    }

    public LandingPage joinButtonClick() throws InterruptedException {
        delayAndClick(joinButton);
        return this;
    }

    public LandingPage moveToAboutUsHeader() throws InterruptedException {
        moveTo(aboutUsHeader);
        return this;
    }

    public Boolean isAboutUsTextDisplayed(){
        return isDisplayed(aboutUsText);
    }

    public Boolean isAboutUsWhyExLabSubheaderDisplayed(){
        return isDisplayed(aboutUsWhyXLabHeader);
    }

    public Boolean isAboutUsWhyExLabTextDisplayed(){
        return isDisplayed(aboutUsWhyXLabText);
    }

    public Boolean isAboutUsWhyExLabJoinButtonDisplayed(){
        return isDisplayed(aboutUsWhyXLabJoinButton);
    }

    public LandingPage moveToAboutUsJoinButton() throws InterruptedException {
        moveTo(aboutUsWhyXLabJoinButton);
        return this;
    }
    public LandingPage whyExLabJoinButtonClick() throws InterruptedException {
        delayAndClick(aboutUsWhyXLabJoinButton);
        return this;
    }

}
