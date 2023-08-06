package com.juaracoding;

import com.juaracoding.model.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_2 {

    LoginPage pageLogin = new LoginPage();

    @Test
    public void testUsename(){
        String actual = "weningputri3@gmail.com";
        pageLogin.setUsername(actual);
        String expected = pageLogin.getUsername();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testPassword(){
        String actual = "GunakanSandiKuat";
        pageLogin.setPassword(actual);
        String expected = pageLogin.getPassword();
        Assert.assertEquals(actual, expected);
    }
}
