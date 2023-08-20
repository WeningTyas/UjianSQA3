package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToChartTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        String path = "E:\\Bootcam\\App\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
    }
    @Test
    public void testAddToChart(){
        driver.get("https://shop.demoqa.com/shop/");
        JavascriptExecutor jx = (JavascriptExecutor) driver;
        jx.executeScript("window.scrollBy(0,500)");

        // Pilih 1 produk
        driver.findElement(By.className("noo-product-inner")).click();
        System.out.println("Pilih satu produk");

        jx.executeScript("window.scrollBy(0,500)");

        //Pilih dropdown 1, Color
        WebElement pilihWarna = driver.findElement(By.id("pa_color"));
        pilihWarna.click();
        WebElement warnaKlik = driver.findElement(By.xpath("//option[text()='Beige']")); // Ganti dengan locator yang sesuai
        warnaKlik.click();
        System.out.println("Pilih warna Oke!");

        //Pilih dropdown 2, Ukuran
        WebElement pilihUkuran = driver.findElement(By.id("pa_size"));
        pilihUkuran.click();
        WebElement ukuranKlik = driver.findElement(By.xpath("//option[text()='Medium']")); // Ganti dengan locator yang sesuai
        ukuranKlik.click();
        System.out.println("Pilih ukuran Oke!");

        //driver.findElement(By.className("icon_plus")).click(); // tambah jumlah produk

        WebElement add = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        add.click();
        System.out.println("klik Add to Chart");

        String pesan = driver.findElement(By.className("woocommerce-message")).getText();
        Assert.assertTrue(pesan.contains("has been added to your cart"));
    }
    @AfterMethod
    public void close() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
