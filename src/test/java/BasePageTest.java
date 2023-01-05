import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;

import java.time.Duration;
import java.util.ArrayList;

import static driver.driver.*;

public class BasePageTest {

    public BasePage basePage;

@BeforeMethod
public void start () {

    createDriver();
    basePage = new BasePage();
    basePage.open();
}

@AfterMethod
public void finish() {
        quite();
}

    @Test
    public void pageOpened() {

        String url = basePage.getUrl();
        Assert.assertEquals(url, "http://test.exlab.team/", "TEST FAILED: Url is not the same");

        String title = basePage.getTitle();
        Assert.assertEquals(title,"ExLab Landing", "TEST FAILED: title is not the same");

        Assert.assertTrue(basePage.logo.isDisplayed());

        System.out.println("________________________\nTEST PASSED: website is opened:\n- URL is the same\n- Title is the same" +
                "\n- Logo is visible\n________________________");
    }

    public void isLinkMatch(WebElement locator, String expectedText){

        String menuLink = basePage.getMenuLink(locator);
//        System.out.println("menuLink for " + locator.getText() + " = " + menuLink);
        Assert.assertEquals(menuLink,expectedText,"TEST FAILED: link " + locator.getText() + " doesn't match to expected");
        System.out.println("________________________\nTEST PASSED: menu " + locator.getText() +
                " is displayed and link is matched with expected" +
                "\n________________________");
    }

    public void isMenuItemDisplayed(WebElement locator) {
    Assert.assertTrue(locator.isDisplayed());
        System.out.println("TEST PASSED: Menu " + locator.getText() + " is displayed");
    }

        @Test
    public void ifDarkBackground(){
    //Logo in header is dark
        Assert.assertEquals(basePage.logo.getAttribute("class"), "sc-jqUVSM EnPDN",
                "Test failed: background is not dark - logo is not dark");
        //Theme icon is a sun
        Assert.assertTrue(basePage.menuBackgroundChange.getAttribute("class").contains("fEkGUM"),
                "Test failed: background is not dark - icon is not a sun");
        //Image going through all page is in dark option
        Assert.assertTrue(basePage.sidePicture.getAttribute("class").contains("kjBOCW"),
                "Test failed: background is not dark - side image is not at dark option");
            System.out.println("________________________\nTEST PASSED: background is dark\n________________________");
    }

    @Test
    public void isHeaderLogoDisplayed() {
        isMenuItemDisplayed(basePage.logo);
    }

    @Test
    public void menuAboutDisplayed(){
        isMenuItemDisplayed(basePage.menuAbout);
    }

    @Test
    public void menuAboutLink(){
        isLinkMatch(basePage.menuAbout, "#about");
    }

    @Test
    public void menuProjectDisplayed(){
        isMenuItemDisplayed(basePage.menuProjects);
    }

    @Test
    public void menuProjectsLink(){
        isLinkMatch(basePage.menuProjects, "#projects");
    }

    @Test
    public void menuMentorsDisplayed(){
        isMenuItemDisplayed(basePage.menuMentors);
    }

    @Test
    public void menuMentorsLink(){
        isLinkMatch(basePage.menuMentors, "#mentors");
    }

    @Test
    public void menuStartUpDisplayed(){
        isMenuItemDisplayed(basePage.menuStartUp);
    }

    @Test
    public void menuStartUpLink(){
        isLinkMatch(basePage.menuStartUp, "#startup");
    }

    @Test
    public void menuBackgroundChangeIsDisplayed(){
        isMenuItemDisplayed(basePage.menuBackgroundChange);
    }

    @Test
    public void menuBackgroundChangeWorks(){
//        basePage.menuBackgroundChange.click();
//Check if we have dark theme, then chek if it changes to light. If not - vice versa
    if (basePage.logo.getAttribute("class").contains("EnPDN")) {
        basePage.menuBackgroundChange.click();
        Assert.assertTrue(basePage.logo.getAttribute("class").contains("FjAfx"),
                "Test failed: background not changes");
    }
    else {
        basePage.menuBackgroundChange.click();
        Assert.assertTrue(basePage.logo.getAttribute("class").contains("EnPDN"),
                "Test failed: background not changes");
    }
        System.out.println("________________________\nTEST PASSED: background changes\n________________________");
    }

    @Test
    public void joinUsButtonIsDisplayed() {
        isMenuItemDisplayed(basePage.getJoinButton());

    }

    @Test
    public void joinUsButtonOpensCorrectLink() {
        basePage.getJoinButton().click();
        basePage.changeToNewTab();
        Assert.assertEquals(basePage.getUrl(), "https://t.me/ExLab_registration_bot",
                "TEST FAILED: Url is not that expected");
        System.out.println("________________________\nTEST PASSED: joinUs button opens expected URL\n________________________");
    }

}
