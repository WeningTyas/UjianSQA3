package com.juaracoding;

import com.juaracoding.Ver_2.LoginAndAddToChart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends LoginAndAddToChart {
    public static void loginTest(WebDriver driver){
        Scroll scroll = new Scroll(driver);
        driver.get("https://shop.demoqa.com");
        System.out.println("Buka Browser dan buka URL");

        // Scroll ke bawah dan munculkan header, karena header ketutup "This is a ToolsQA Demo shop for testing purposes"
        scroll.scrollBy(0, 200);
        System.out.println("Scroll ke bawah, utk munculkan header");

        // KLik MyAccount
        WebElement elemen = driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/my-account/']"));
        elemen.click();
        System.out.println("Klik menu My Account");

        scroll.scrollBy(0, 500);

        // Isi uname & password
        driver.findElement(By.name("username")).sendKeys("weningputri3@gmail.com");
        driver.findElement(By.name("password")).sendKeys("GunakanSandiKuat");
        driver.findElement(By.name("login")).click();
        System.out.println("Masukkan username & password lalu klik Login");

        scroll.scrollBy(0, 500);

        // Verifikasi sdh login atau belum
        String menu = driver.findElement(By.className("woocommerce-MyAccount-navigation")).getText();
        if(menu.contains("Dashboard")){
            System.out.println("Login Oke!");
        } else {
            System.out.println("Login Failed");
        }
        // Karena mau saat login ataupun tidak tetap tulisan Headernya my account (ini gak bisa dibuat patokan),
        // jd pembedanya hanya di form login atau menu, yg mana salah satu menunya adalah Dashboard
    }
}
