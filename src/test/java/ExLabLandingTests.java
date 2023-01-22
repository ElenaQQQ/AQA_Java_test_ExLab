import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.LandingPage;

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

        landingPage.open().ifUrlExLabMatches();
        landingPage.ifTitleExLabMatches();
        landingPage.ifLogoDisplayed();

        System.out.println("TEST PASSED: website is opened:\n" +
                "- URL is matches\n" +
                "- Title is matches" + "\n" +
                "- Logo is visible");
    }

    @Test (description = "Page opens with dark background", groups = "Header")
    public void test_2() {
        String backgroundClassAtStart = landingPage.open().takeBackgroungClass();
        Assert.assertTrue(backgroundClassAtStart.contains("fEkGUM"),
                "TEST FAILED: Page not opens with dark background");
    }

    @Test (description = "ExLab logo is displayed", groups = "Header")
    public void test_3() {
        new LandingPage().open().ifLogoDisplayed();
    }

    @Test (description = "Menu item About us is displayed", groups = "Header")
    public void test4(){
        new LandingPage().open().isMenuAboutDisplayed();
    }

    @Test (description = "About us menu link opens About us module", groups = "Header")
    public void test_5 ()  {
        new LandingPage().open().menuAboutUsClick().isAboutUsHeaderDisplayed();
    }

    @Test (description = "Menu item Projects is displayed", groups = "Header")
    public void test_6(){
        new LandingPage().open().isMenuProjectDisplayed();
    }

    @Test (description = "Menu item Projects opens Projects module", groups = "Header")
    public void test_7() throws InterruptedException {
        new LandingPage().open().menuProjectsClick().isProjectsHeaderDisplayed();
    }

    @Test (description = "Menu item Mentors is displayed", groups = "Header")
    public void test_8() {
        new LandingPage().open().isMenuMentorsDisplayed();
    }

    @Test (description = "Menu item Mentors opens Mentors module", groups = "Header")
    public void test_9() throws InterruptedException {
        new LandingPage().open().menuMentorsClick().isMentorsHeaderDisplayed(); //клик делается с задержкой, так как прогрузка страницы идет по блокам и некорректно
    }

    @Test (description = "Menu item StartUp is displayed", groups = "Header")
    public void test_10(){
        new LandingPage().open().isMenuStartUpDisplayed();
    }

    @Test (description = "Menu item StartUp opens Start up module", groups = "Header")
    public void test_11() throws InterruptedException {
        new LandingPage().open().menuStartUpClick().isStartUpHeaderDisplayed(); //клик делается с задержкой, так как прогрузка страницы идет по блокам и некорректно
    }

//    @Test
//    public void test_scrollToTheEndAndBack() throws InterruptedException {
//        new LandingPage().open().menuAboutUsClick().scrollToTheEnd().isProjectsHeaderDisplayed();
//    }

    @Test (description = "BackgroundColor Icon is displayed", groups = "Header")
    public void test_12(){
        new LandingPage().open().backgroundColorIconDisplayed();
    }

    @Test(description = "Mentors header is displayed", groups = "Mentors")
    public void test_25() throws InterruptedException {
        new LandingPage().open().moveToMentorsHeader().isMentorsHeaderDisplayed();
    }

//    @Test(description = "Mentors info opens by + click")
//    public void test_26()  {
//        new LandingPage().open().menuMentorsClick().isMentorsHeaderDisplayed().clickMentorsHeaderPlus();
//    }



//    @Test
//    public void menuBackgroundChangeWorksCorrectly(){
//
////Check if we have dark theme, then check if it changes to light. If not - vice versa
//        if (landingPage.getLogo().getAttribute("class").contains("EnPDN")) {
//            landingPage.getMenuBackgroundChange().click();
//            Assert.assertTrue(landingPage.getLogo().getAttribute("class").contains("FjAfx"),
//                    "Test failed: background color not changes");
//        }
//        else {
//            basePage.getMenuBackgroundChange().click();
//            Assert.assertTrue(landingPage.getLogo().getAttribute("class").contains("EnPDN"),
//                    "Test failed: background color not changes");
//        }
//        System.out.println("________________________\nTEST PASSED: background color changes correctly\n________________________");
//    }
//
//
//
//    @Test
//    public void joinUsButtonOpensCorrectLink() {
//        landingPage.getJoinButton().click();
//        landingPage.changeToNewTab();
//        Assert.assertEquals(landingPage.getUrl(), "https://t.me/ExLab_registration_bot",
//                "TEST FAILED: Url is not that expected");
//        System.out.println("________________________\nTEST PASSED: joinUs button opens expected URL\n________________________");
//    }
}
