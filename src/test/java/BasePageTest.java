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
        Assert.assertEquals(url, "http://test.exlab.team/", "Test failed: Url is not the same");

        String title = basePage.getTitle();
        Assert.assertEquals(title,"ExLab Landing", "Test failed: title is not the same");

        Assert.assertTrue(basePage.logo.isDisplayed());

        System.out.println("________________________\ntest passed: website is opened:\n- URL is the same\n- Title is the same" +
                "\n- Logo is visible\n________________________");
    }

}
