import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.LandingPage;

import static driver.driver.createDriver;
import static driver.driver.quite;

public class ExLabLandingTests {

    @BeforeMethod
    public void start () { createDriver(); }

    @AfterMethod
    public void finish() {
        quite();
    }

    @Test (description = "ExLab landing is available by URL", groups = "Header")
    public void test_1() {

        LandingPage landingPage = new LandingPage();

        landingPage.open().ifUrlExLabMatches();
        landingPage.ifTitleExLabMatches();
        landingPage.ifLogoDisplayed();

        System.out.println("TEST PASSED: website is opened:\n" +
                "- URL is matches\n" +
                "- Title is matches" + "\n" +
                "- Logo is visible");
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
    public void test_5 (){
        new LandingPage().open().menuAboutUsClick().isAboutUsHeaderDisplayed();
    }

    @Test (description = "Menu item Projects is displayed", groups = "Header")
    public void test_6(){
        new LandingPage().open().isMenuProjectDisplayed();
    }

    @Test (description = "Menu item Projects opens Projects module", groups = "Header")
    public void test_7(){
        new LandingPage().open().menuProjectsClick().isProjectsHeaderDisplayed();
    }

    @Test (description = "Menu item Mentors is displayed", groups = "Header")
    public void test_8(){
        new LandingPage().open().isMenuMentorsDisplayed();
    }

    @Test (description = "Menu item Mentors opens Mentors module", groups = "Header")
    public void test_9(){
        new LandingPage().open().menuMentorsClick().isMentorsHeaderDisplayed();
    }

    @Test (description = "Menu item StartUp is displayed", groups = "Header")
    public void test_10(){
        new LandingPage().open().isMenuStartUpDisplayed();
    }

    @Test (description = "Menu item StartUp opens Start up module", groups = "Header")
    public void test_11(){
        new LandingPage().open().menuStartUpClick().isStartUpHeaderDisplayed();
    }

    @Test (description = "BackgroundColor Icon is displayed", groups = "Header")
    public void test_12(){
        new LandingPage().open().backgroundColorIconDisplayed();
    }




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
