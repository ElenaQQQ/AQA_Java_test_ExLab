package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class driver {

private static WebDriver driver;

public static void createDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//    WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='header']//img")));
}

public static WebDriver getDriver (){
    return driver;
}

public static void quite() {
//        driver.close();
        driver.quit();
}

}
