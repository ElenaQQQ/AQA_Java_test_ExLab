package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.example.factory.WebDriverFactory;

import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class AppTest {

    @Test
    public void ifOpened()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
//        webDriver.get("http://test.exlab.team/");
        webDriver.get("http://exlab.team/");

        WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='header']//img")));

        WebElement logo = webDriver.findElement(By.xpath("//div[@id='header']//img"));
        Assert.assertTrue(logo.isDisplayed());

        System.out.println("________________________\ntest passed: website is opened\n________________________");

        webDriver.close();
        webDriver.quit();

    }
}
