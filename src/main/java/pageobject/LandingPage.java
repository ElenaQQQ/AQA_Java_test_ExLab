package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.Assert;

import java.util.List;

public class LandingPage extends BasePage {

    //HEADER

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

    // BIG LOGO, ABOUT US MODULE

    @FindBy(xpath = "//div[@id='header']//img")
    private WebElement bigLogo;

    @FindBy(xpath = "//div[@id='about']/div[2]")
    private WebElement aboutUsHeader;

    @FindBy(xpath = "//div[@id='about']/div/p")
    private WebElement aboutUsText;

    @FindBy(xpath = "//div[@id='about']/div/div")
    private WebElement aboutUsWhyXLabHeader;

    @FindBy(xpath = "//div[@id='about']/div/ol")
    private WebElement aboutUsWhyXLabText;

    @FindBy(xpath = "//div[@id='about']/div/div/a")
    private WebElement aboutUsWhyXLabJoinButton;

    // PROJECTS MODULE

    @FindBy(xpath = "//div[@id='projects']/div/div[contains(@data-scroll-target,'#projects')]")
    private WebElement projectsHeader;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]")
    private WebElement projectXLabHeader;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]/following-sibling::img")
    private WebElement projectXLabLogo;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'ExLab')]/following-sibling::p")
    private WebElement projectXLabText;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'Healthy life')]")
    private WebElement projectHealthylifeHeader;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'Healthy life')]/following-sibling::img")
    private WebElement projectHealthylifeLogo;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'Healthy life')]/following-sibling::p")
    private WebElement projectHealthylifeText;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'Easyhelp')]")
    private WebElement projectEasyhelpHeader;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'Easyhelp')]/following-sibling::img")
    private WebElement projectEasyhelpLogo;

    @FindBy(xpath = "//div[@id='projects']//h2[contains(text(),'Easyhelp')]/following-sibling::p")
    private WebElement projectEasyhelpText;

    // MENTORS MODULE

    @FindBy(xpath = "//div[@id='mentors']/div[2]")
    private WebElement mentorsHeader;

    @FindBy (xpath = "//div[@id='mentors']/div/div/div")
    private WebElement mentorsBlock1;

    @FindBy (xpath = "(//div[@id='mentors']//div/p/following-sibling::span)[1]")
    private WebElement mentors1InfoOpen;

    @FindBy (xpath = "(//div[@id='mentors']//img)[1]")
    private WebElement mentors1Foto;

    @FindBy (xpath = "((//div[@id='mentors']//ul)[1]")
    private WebElement mentors1Info;

    @FindBy (xpath = "//div[@id='mentors']//a[contains(text(),'Стать')]")
    private WebElement mentorsBecameButton;

    // START-UP MODULE

    @FindBy(xpath = "//div[@id=\"startup\"]/div/div[contains(@data-scroll-target,'#startup')]")
    private WebElement startUpHeader;

    @FindBy(xpath = "//div[@id='startup']/div/div/p")
    private WebElement startUpText;

    @FindBy (xpath = "//div[@id='startup']//a[contains(text(),'Найти')]")
    private WebElement startUpFindButton;

    // HELP PROJECT HEADER

    @FindBy (xpath = "//div[(contains(text(),'Помочь'))]")
    private WebElement helpProjectHeader;

    @FindBy (xpath = "//div[(contains(text(),'Помочь'))]/following-sibling::div//div[contains(text(),' ')][1]")
    private WebElement helpProjectText;

    @FindBy (xpath = "//div[(contains(text(),'Помочь'))]/following-sibling::div//a[contains(text(),'Boosty')]")
    private WebElement helpProjectBoostyButton;

    @FindBy (xpath = "//div[(contains(text(),'Помочь'))]/following-sibling::div//a[contains(text(),'Patreon')]")
    private WebElement helpProjectPatreonButton;

    @FindBy (xpath = "//div[(contains(text(),'Оставайся'))]")
    private WebElement stayConnectedHeader;

    @FindBy (xpath = "//div[(contains(text(),'Оставайся'))]/following-sibling::div")
    private WebElement stayConnectedText;

    // FOOTER




    public void open(){
        loadPage();
//        return this;
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

    public LandingPage moveToProjectsHeader() throws InterruptedException {
        moveTo(projectsHeader);
        return this;
    }

    public Boolean isExLabLogoDisplayed(){
        return isDisplayed(projectXLabLogo);
    }

    public Boolean isExLabTextDisplayed(){
        return isDisplayed(projectXLabText);
    }

    public Boolean isEasyhelpLogoDisplayed(){
        return isDisplayed(projectEasyhelpLogo);
    }

    public Boolean isEasyhelpTextDisplayed(){
        return isDisplayed(projectEasyhelpText);
    }

    public Boolean isHealthylifeLogoDisplayed(){
        return isDisplayed(projectHealthylifeLogo);
    }

    public Boolean isHealthylifeTextDisplayed(){
        return isDisplayed(projectHealthylifeText);
    }

    public LandingPage moveToExLabProject() throws InterruptedException {
        moveTo(projectXLabText);
        return this;
    }

    public LandingPage moveToHealthyLifeProject() throws InterruptedException {
        moveTo(projectHealthylifeText);
        return this;
    }

    public LandingPage moveToEasyHelpProject() throws InterruptedException {
        moveTo(projectEasyhelpText);
        return this;
    }

    public Boolean isMentorsFotoDisplayed(){
        return isDisplayed(mentors1Foto);
    }

    public Integer countMentors(){
        List<WebElement> list = mentorsBlock1.findElements(By.xpath("//div[@id='mentors']/div/div/div"));
        return list.size();
    }

    public LandingPage moveToWhyExLabBlock() throws InterruptedException {
        moveTo(aboutUsWhyXLabJoinButton);
        return this;
    }

    public LandingPage moveToStartUpBlock() throws InterruptedException {
        moveTo(startUpText);
        return this;
    }

    public Boolean isBecameMentorButtonDisplayed(){
        return isDisplayed(mentorsBecameButton);
    }

    public Boolean isStartUpTextDisplayed(){
        return isDisplayed(startUpText);
    }

    public LandingPage moveToStartUpButton() throws InterruptedException {
        moveTo(startUpFindButton);
        return this;
    }

    public Boolean isStartUpButtonDisplayed(){
        return isDisplayed(startUpFindButton);
    }

    public LandingPage moveToHelpProjectBlock() throws InterruptedException {
        moveTo(helpProjectBoostyButton);
        return this;
    }

    public Boolean isHelpProjectHeaderDisplayed(){
        return isDisplayed(helpProjectHeader);
    }

    public Boolean isHelpProjectTextDisplayed(){
        return isDisplayed(helpProjectText);
    }

    public Boolean isHelpProjectBoostyButtonDisplayed(){
        return isDisplayed(helpProjectBoostyButton);
    }

    public Boolean isHelpProjectPatreonButtonDisplayed(){
        return isDisplayed(helpProjectPatreonButton);
    }

    public LandingPage clickBoostyButton() throws InterruptedException {
        delayAndClick(helpProjectBoostyButton);
        return this;
    }

    public LandingPage moveToStayConnectedModule() throws InterruptedException{
        moveTo(stayConnectedText);
        return this;
    }

    public Boolean isStayConnectedHeaderDisplayed(){
        return isDisplayed(stayConnectedHeader);
    }

    public Boolean isStayConnectedTextDisplayed(){
        return isDisplayed(stayConnectedText);
    }

}
