package com.juaracoding.Ver_2;

import com.juaracoding.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndAddToChart {

    public static void main(String[] args) {
        String path = "E:\\Bootcam\\App\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        loginTest(driver);
        addToChartTest(driver);

        //End proses
        delay();
        driver.quit();
        System.out.println("Keluar dari Browser");
    }


    //============================ Login ke akun =========================//
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


    //============================ Tambahkan produk ke Chart =========================//
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

    public static void delay(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

/*Klo ada error pas run bagian addToChartTest
* Itu biasanya karena di webnya udh ada produk yg nyangkut
* maka coba aja hapus dulu tuh produk
* trus Run ulang
* */
