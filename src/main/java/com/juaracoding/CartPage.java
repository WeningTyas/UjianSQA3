package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public static void addToChartTest(WebDriver driver){
        Scroll scroll = new Scroll(driver);
        scroll.scrollBy(0, -500);

        WebElement cart = driver.findElement(By.xpath("//span[contains(@class, 'cart-name-and-total')]"));
        cart.click();
        System.out.println("Klik menu Cart");

        scroll.scrollBy(0, 500);

        // Klik tombol Browse products
        WebElement returnShop = driver.findElement(By.xpath("//a[@class='button wc-backward']"));
        returnShop.click();
        System.out.println("Klik menu Return to Shop");

        scroll.scrollBy(0, 500);
        System.out.println("Scroll ke bawah dan cari produk");

        // Pilih 1 produk
        driver.findElement(By.className("noo-product-inner")).click();
        System.out.println("Pilih satu produk");

        scroll.scrollBy(0, 500);

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
    }
}
