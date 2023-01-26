package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class driver {

private static WebDriver driver;
public static Actions actions;

public static void createDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

//    actions = new Actions(driver);
    driver.manage().window().maximize();
}

public static WebDriver getDriver (){
    return driver;
}

public static void quite() {
//        driver.close();
        driver.quit();
}

}
