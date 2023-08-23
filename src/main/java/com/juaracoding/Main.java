package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        String path = "E:\\Bootcam\\App\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        LoginPage login = new LoginPage();
        CartPage cart = new CartPage();

        driver.manage().window().maximize();

        login.loginTest(driver);
        cart.addToChartTest(driver);

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

/*Klo ada error pas run bagian addToChartTest atau mentok di halaman Cart
 * Itu biasanya karena di webnya udh ada produk yg nyangkut
 * maka coba aja hapus dulu tuh produk
 * trus Run ulang
 * */