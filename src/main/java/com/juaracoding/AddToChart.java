package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToChart {
    public static void main(String[] args) {

        String path = "E:\\Bootcam\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://shop.demoqa.com/shop/");
        System.out.println("Buka Browser dan buka URL");

        // Scroll ke bawah dan cari produk
        JavascriptExecutor jx = (JavascriptExecutor) driver;
        jx.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll ke bawah dan cari produk");

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

        // Verifikasi sdh berhasil atau belum
        String pesan = driver.findElement(By.className("woocommerce-message")).getText();
        if(pesan.contains("has been added to your cart")){
            System.out.println("Tambah produk Oke!");
        } else {
            System.out.println("Tambah produk gagal");
        }

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
