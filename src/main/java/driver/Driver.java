package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static utils.Config.*;

public class Driver {

private static WebDriver driver;
public static Actions actions;

public static void createDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(getChromeOptions());

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITY_WAIT));
    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    driver.manage().window().setSize(DIMENSION);
//    driver.manage().window().maximize();
}

public static WebDriver getDriver (){
    return driver;
}

public static void quite() {
//        driver.close();
        driver.quit();
}

protected static ChromeOptions getChromeOptions(){
    ChromeOptions chromeOptions = new ChromeOptions();
        if(ON_HEADLESS) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
}

}
