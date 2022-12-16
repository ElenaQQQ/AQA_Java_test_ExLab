import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.BasePage;
import static driver.driver.createDriver;
import static driver.driver.quite;

public class BasePageTest {

@BeforeTest
public void start () {
    createDriver();
}

@AfterTest
public void finish() {
        quite();
}

    @Test
    public void pageOpened()
    {
        BasePage basePage = new BasePage();

        String url = basePage.open().getUrl();
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


    public void isLinkExist(WebElement locator, String expectedText, BasePage basePage){

        String menuLink = basePage.open().getMenuLink(locator);
        System.out.println("menuLink for " + locator.getText() + " = " + menuLink);
        Assert.assertEquals(menuLink,expectedText,"TEST FAILED: link " + locator.getText() + " doesn't match to expected");
        System.out.println("________________________\nTEST PASSED: menu " + locator.getText() +
                " is exist and link is matched with expected" +
                "\n________________________");
    }

    @Test
    public void aboutLinkExist(){
        BasePage basePage = new BasePage();
        isLinkExist(basePage.menuAbout, "#about", basePage);
    }

    @Test
    public void projectsLinkExist(){
        BasePage basePage = new BasePage();
        isLinkExist(basePage.menuProjects, "#projects", basePage);
    }

    @Test
    public void mentorsLinkExist(){
        BasePage basePage = new BasePage();
        isLinkExist(basePage.menuMentors, "#mentors", basePage);
    }
}
