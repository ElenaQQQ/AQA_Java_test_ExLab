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
    }

    @AfterMethod
    public void finish() {
        quite();
    }

    @Test (description = "ExLab landing is available by URL", groups = "Header")
    public void test_1() {
        Assert.assertEquals(landingPage.open().getUrl(),BASE_URL,
                "TEST FAIL: Url not matches");
        Assert.assertEquals(landingPage.open().getTitle(),"ExLab Landing",
                "TEST FAIL: Title not matches");
        Assert.assertTrue(landingPage.open().isLogoDisplayed(),
                "TEST FAIL: Logo is not displayed");

        System.out.println("TEST PASSED: website is opened:\n" +
                "- URL is matches\n" +
                "- Title is matches" + "\n" +
                "- Logo is visible");
    }

    @Test (description = "Page opens with dark background", groups = "Header")
    public void test_2() {
        Assert.assertTrue(landingPage.open().takeBackgroungClass().contains("fEkGUM"),
                "TEST FAILED: Page not opens with dark background");
    }

    @Test (description = "ExLab logo is displayed", groups = "Header")
    public void test_3() {
        Assert.assertTrue(landingPage.open().isLogoDisplayed());
    }

    @Test (description = "Menu item About us is displayed", groups = "Header")
    public void test4(){
        Assert.assertTrue(landingPage.open().isMenuAboutDisplayed());
    }

    @Test (description = "About us menu link opens About us module", groups = "Header")
    public void test_5 ()  {
        Assert.assertTrue(landingPage.open().menuAboutUsClick().isAboutUsHeaderDisplayed());
    }

    @Test (description = "Menu item Projects is displayed", groups = "Header")
    public void test_6(){
        Assert.assertTrue(landingPage.open().isMenuProjectDisplayed());
    }

    @Test (description = "Menu item Projects opens Projects module", groups = "Header")
    public void test_7() throws InterruptedException {
        Assert.assertTrue(landingPage.open().menuProjectsClick().isProjectsHeaderDisplayed());
    }

    @Test (description = "Menu item Mentors is displayed", groups = "Header")
    public void test_8() {
        Assert.assertTrue(landingPage.open().isMenuMentorsDisplayed());
    }

    @Test (description = "Menu item Mentors opens Mentors module", groups = "Header")
    public void test_9() throws InterruptedException {
        Assert.assertTrue(landingPage.open().menuMentorsClick().isMentorsHeaderDisplayed());
    }

    @Test (description = "Menu item Mentors opens Mentors module", groups = "Header")
    public void test_9_1() throws InterruptedException {
        Assert.assertTrue(landingPage.open().scrollToTheEnd().moveToMentorsHeader().isMentorsHeaderDisplayed());
    }

    @Test (description = "Menu item StartUp is displayed", groups = "Header")
    public void test_10(){
        Assert.assertTrue(landingPage.open().isMenuStartUpDisplayed());
    }

    @Test (description = "Menu item StartUp opens Start up module", groups = "Header")
    public void test_11() throws InterruptedException {
        Assert.assertTrue(landingPage.open().menuStartUpClick().isStartUpHeaderDisplayed());
    }

    @Test (description = "BackgroundColor Icon is displayed", groups = "Header")
    public void test_12(){
        Assert.assertTrue(landingPage.open().isBackgroundColorChangeButtonDisplayed());
    }

    @Test (description = "BackgroundColor button changes background color", groups = "Header")
    public void test_13() throws InterruptedException {
        String backgroundClassBeforeClick = landingPage.open().takeBackgroungClass();
        String backgroundClassAfterClick = landingPage.clickBackgroundColorChangeButton().takeBackgroungClass();
        Assert.assertNotEquals(backgroundClassAfterClick, backgroundClassBeforeClick,
                "TEST FAILED: BackgroundColor button NOT changes background color");
    }

    @Test (description = "Join button is displayed", groups = "Header")
    public void test_14(){
        Assert.assertTrue(landingPage.open().isJoinButtonDisplayed(),
                "TEST FAIL: Join button is NOT displayed");
    }

    @Test (description = "Join button opens telegram inviting page", groups = "Header")
    public void test_15() throws InterruptedException {
        landingPage.open().joinButtonClick().changeToNewTab();
        Assert.assertEquals(landingPage.getUrl(),"https://t.me/ExLab_registration_bot",
                "TEST FAIL: Join button NOT opens telegram inviting page");
    }

    @Test(description = "Mentors header is displayed", groups = "Mentors")
    public void test_25() throws InterruptedException {
        Assert.assertTrue(landingPage.open().scrollToTheEnd().moveToMentorsHeader().isMentorsHeaderDisplayed());
    }

    @Test(description = "Mentors info opens by + click")
    public void test_26() throws InterruptedException {
        Assert.assertTrue(landingPage.open().menuMentorsClick().clickMentorsInfoOpen().checkMentorsInfo());
    }

    @Test (description = "Mentors info is closed by clicking - click")
    public void test_29() throws InterruptedException {
        Assert.assertFalse(landingPage.open().menuMentorsClick().
                clickMentorsInfoOpen().clickMentorsInfoOpen().checkMentorsInfo());
    }
}
