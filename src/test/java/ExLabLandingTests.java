import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.LandingPage;

import static Utils.Config.*;
import static driver.driver.createDriver;
import static driver.driver.quite;

public class ExLabLandingTests {
    protected LandingPage landingPage;

    @BeforeMethod
    public void start () {
        createDriver();
        landingPage = new LandingPage();
        landingPage.open();
    }

    @AfterMethod
    public void finish() {
        quite();
    }

    @Test (description = "ExLab landing is available by URL", groups = "Header")
    public void test_1() {
        Assert.assertEquals(landingPage.getUrl(),BASE_URL,
                "TEST FAIL: Url not matches");
        Assert.assertEquals(landingPage.getTitle(),"ExLab Landing",
                "TEST FAIL: Title not matches");
        Assert.assertTrue(landingPage.isLogoDisplayed(),
                "TEST FAIL: Logo is not displayed");

        System.out.println("TEST PASSED: website is opened:\n" +
                "- URL is matches\n" +
                "- Title is matches" + "\n" +
                "- Logo is visible");
    }

    @Test (description = "Page opens with dark background", groups = "Header")
    public void test_2() {
        Assert.assertTrue(landingPage.takeBackgroungClass().contains("fEkGUM"),
                "TEST FAILED: Page not opens with dark background");
    }

    @Test (description = "ExLab logo is displayed", groups = "Header")
    public void test_3() {
        Assert.assertTrue(landingPage.isLogoDisplayed());
    }

    @Test (description = "Menu item About us is displayed", groups = "Header")
    public void test4(){
        Assert.assertTrue(landingPage.isMenuAboutDisplayed());
    }

    @Test (description = "About us menu link opens About us module", groups = "Header")
    public void test_5 ()  {
        Assert.assertTrue(landingPage.menuAboutUsClick().isAboutUsHeaderDisplayed());
    }

    @Test (description = "Menu item Projects is displayed", groups = "Header")
    public void test_6(){
        Assert.assertTrue(landingPage.isMenuProjectDisplayed());
    }

    @Test (description = "Menu item Projects opens Projects module", groups = "Header")
    public void test_7() throws InterruptedException {
        Assert.assertTrue(landingPage.menuProjectsClick().isProjectsHeaderDisplayed());
    }

    @Test (description = "Menu item Mentors is displayed", groups = "Header")
    public void test_8() {
        Assert.assertTrue(landingPage.isMenuMentorsDisplayed());
    }

    @Test (description = "Menu item Mentors opens Mentors module", groups = "Header")
    public void test_9() throws InterruptedException {
        Assert.assertTrue(landingPage.menuMentorsClick().isMentorsHeaderDisplayed());
    }

    @Test (description = "Menu item Mentors opens Mentors module", groups = "Header")
    public void test_9_1() throws InterruptedException {
        Assert.assertTrue(landingPage.scrollToTheEnd().moveToMentorsHeader().isMentorsHeaderDisplayed());
    }

    @Test (description = "Menu item StartUp is displayed", groups = "Header")
    public void test_10(){
        Assert.assertTrue(landingPage.isMenuStartUpDisplayed());
    }

    @Test (description = "Menu item StartUp opens Start up module", groups = "Header")
    public void test_11() throws InterruptedException {
        Assert.assertTrue(landingPage.menuStartUpClick().isStartUpHeaderDisplayed());
    }

    @Test (description = "BackgroundColor Icon is displayed", groups = "Header")
    public void test_12(){
        Assert.assertTrue(landingPage.isBackgroundColorChangeButtonDisplayed());
    }

    @Test (description = "BackgroundColor button changes background color", groups = "Header")
    public void test_13() throws InterruptedException {
        String backgroundClassBeforeClick = landingPage.takeBackgroungClass();
        String backgroundClassAfterClick = landingPage.clickBackgroundColorChangeButton().takeBackgroungClass();
        Assert.assertNotEquals(backgroundClassAfterClick, backgroundClassBeforeClick,
                "TEST FAILED: BackgroundColor button NOT changes background color");
    }

    @Test (description = "Join button is displayed", groups = "Header")
    public void test_14(){
        Assert.assertTrue(landingPage.isJoinButtonDisplayed(),
                "TEST FAIL: Join button is NOT displayed");
    }

    @Test (description = "Join button opens telegram inviting page", groups = "Header")
    public void test_15() throws InterruptedException {
        landingPage.joinButtonClick().changeToNewTab();
        Assert.assertEquals(landingPage.getUrl(),"https://t.me/ExLab_registration_bot",
                "TEST FAIL: Join button NOT opens telegram inviting page");
    }

    @Test (description = "About Us header is displayed")
    public void test_16() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToAboutUsHeader().isAboutUsHeaderDisplayed());
    }

    @Test (description = "About Us text is displayed")
    public void test_17() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToAboutUsHeader().isAboutUsTextDisplayed());
    }

    @Test (description = "Why ExLab subheader is displayed")
    public void test_18() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToWhyExLabBlock().isAboutUsWhyExLabSubheaderDisplayed());
    }

    @Test (description = "Why ExLab text is displayed")
    public void test_19() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToWhyExLabBlock().isAboutUsWhyExLabTextDisplayed());
    }

    @Test (description = "Join button is displayed")
    public void test_20() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToWhyExLabBlock().isAboutUsWhyExLabJoinButtonDisplayed());
    }

    @Test (description = "Join button opens telegram inviting page")
    public void test_21() throws InterruptedException {
        landingPage.moveToAboutUsJoinButton().whyExLabJoinButtonClick().changeToNewTab();
        Assert.assertEquals(landingPage.getUrl(),"https://t.me/ExLab_registration_bot",
                "TEST FAIL: Join button NOT opens telegram inviting page");
    }

    @Test (description = "Projects header is displayed")
    public void test_22() throws InterruptedException{
        Assert.assertTrue(landingPage.moveToProjectsHeader().isProjectsHeaderDisplayed());
    }

    @Test (description = "ExLab logo is displayed at Projects module")
    public void test_23_1() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToExLabProject().isExLabLogoDisplayed());
    }

    @Test (description = "HealthyLife logo is displayed at Projects module")
    public void test_23_2() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToHealthyLifeProject().isHealthylifeLogoDisplayed());
    }

    @Test (description = "Easyhelp logo is displayed at Projects module")
    public void test_23_3() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToEasyHelpProject().isEasyhelpLogoDisplayed());
    }

    @Test (description = "ExLab text is displayed at Projects module")
    public void test_24_1() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToExLabProject().isExLabTextDisplayed());
    }

    @Test (description = "HealthyLife text is displayed at Projects module")
    public void test_24_2() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToHealthyLifeProject().isHealthylifeTextDisplayed());
    }

    @Test (description = "Easyhelp text is displayed at Projects module")
    public void test_24_3() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToEasyHelpProject().isEasyhelpTextDisplayed());
    }

    @Test(description = "Mentors header is displayed", groups = "Mentors")
    public void test_25() throws InterruptedException {
        Assert.assertTrue(landingPage.scrollToTheEnd().moveToMentorsHeader().isMentorsHeaderDisplayed());
    }

    @Test(description = "Mentors info opens by + click")
    public void test_26() throws InterruptedException {
        Assert.assertTrue(landingPage.menuMentorsClick().clickMentorsInfoOpen().checkMentorsInfo());
    }

    @Test (description = "Mentors foto is displayed")
    public void test_27() throws InterruptedException {
        Assert.assertTrue(landingPage.moveToMentorsHeader().clickMentorsInfoOpen().isMentorsFotoDisplayed());
    }

    @Test (description = "Info about 4 mentors is displayed")
    public void test_28() throws InterruptedException {
        Assert.assertEquals(landingPage.moveToMentorsHeader().countMentors(),4);
    }

    @Test (description = "Mentors info is closed by clicking - click")
    public void test_29() throws InterruptedException {
        Assert.assertFalse(landingPage.menuMentorsClick().
                clickMentorsInfoOpen().clickMentorsInfoOpen().checkMentorsInfo());
    }

//    @Test (description = "")
}
