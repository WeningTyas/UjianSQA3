package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        String path = "E:\\Bootcam\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
    }
    @Test
    public void testLogin(){
        driver.get("https://shop.demoqa.com/my-account/");
        JavascriptExecutor jx = (JavascriptExecutor) driver;
        jx.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.name("username")).sendKeys("weningputri3@gmail.com");
        driver.findElement(By.name("password")).sendKeys("GunakanSandiKuat");
        driver.findElement(By.name("login")).click();

        String menu = driver.findElement(By.className("woocommerce-MyAccount-navigation")).getText();
        Assert.assertTrue(menu.contains("Dashboard"));
    }
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
