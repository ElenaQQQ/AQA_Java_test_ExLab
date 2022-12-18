import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.BasePage;
import static driver.driver.createDriver;
import static driver.driver.quite;

public class BasePageTest {

    public BasePage basePage;

@BeforeTest
public void start () {

    createDriver();
    basePage = new BasePage();
    basePage.open();
}

@AfterTest
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

//    @Test
//    public void ifDarkBackground(){
//        BasePage basePage = new BasePage();
//
//        String currentBackgroundClass = basePage.open().getBackgroundClass();
//        Assert.assertEquals(currentBackgroundClass,"","Test failed: background is not dark");
//    }


    public void isLinkMatch(WebElement locator, String expectedText){

        String menuLink = basePage.getMenuLink(locator);
        System.out.println("menuLink for " + locator.getText() + " = " + menuLink);
        Assert.assertEquals(menuLink,expectedText,"TEST FAILED: link " + locator.getText() + " doesn't match to expected");
        System.out.println("________________________\nTEST PASSED: menu " + locator.getText() +
                " is displayed and link is matched with expected" +
                "\n________________________");
    }

//    public void printMenuItemDisplayed(WebElement locator){
    public void isMenuItemDisplayed(WebElement locator) {
    Assert.assertTrue(locator.isDisplayed());
        System.out.println("TEST PASSED: Menu " + locator.getText() + " is displayed");
    }

    @Test
    public void isHeaderLogoDisplayed() {
//    Assert.assertTrue(basePage.logo.isDisplayed());
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
    public void menuSunIconIsDisplayed(){
        isMenuItemDisplayed(basePage.menuSunIcon);
    }
}
