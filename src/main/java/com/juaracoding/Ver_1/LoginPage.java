package com.juaracoding.Ver_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static void main(String[] args) {
        String path = "E:\\Bootcam\\App\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://shop.demoqa.com");
        System.out.println("Buka Browser dan buka URL");

        // Scroll ke bawah dan munculkan header, karena header ketutup "This is a ToolsQA Demo shop for testing purposes"
        JavascriptExecutor jx = (JavascriptExecutor) driver;
        jx.executeScript("window.scrollBy(0,200)");
        System.out.println("Scroll ke bawah, utk munculkan header");

        // KLik MyAccount
        WebElement elemen = driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/my-account/']"));
        elemen.click();
        System.out.println("Klik menu My Account");

        jx.executeScript("window.scrollBy(0,500)");

        // Isi uname & password
        driver.findElement(By.name("username")).sendKeys("weningputri3@gmail.com");
        driver.findElement(By.name("password")).sendKeys("GunakanSandiKuat");
        driver.findElement(By.name("login")).click();
        System.out.println("Masukkan username & password lalu klik Login");

        jx.executeScript("window.scrollBy(0,500)");

        // Verifikasi sdh login atau belum
        String menu = driver.findElement(By.className("woocommerce-MyAccount-navigation")).getText();
        if(menu.contains("Dashboard")){
            System.out.println("Login Oke!");
        } else {
            System.out.println("Login Failed");
        }
        // Karena mau saat login ataupun tidak tetap tulisan Headernya my account (ini gak bisa dibuat patokan),
        // jd pembedanya hanya di form login atau menu, yg mana salah satu menunya adalah Dashboard

        //End proses
        delay();
        driver.quit();
        System.out.println("Keluar dari Browser");
    }

    public static void delay(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}



/* GOAL
 * Automation Testing:
 * -  Login web https://shop.demoqa.com
 * -  Fitur Add 1 product to cart
 * Metode :  Assert dan if
 * Hanya test case positif
 * End: Push project ke github
 *
 * email: weningputri3@gmail.com
 * pwd  : GunakanSandiKuat
 * */