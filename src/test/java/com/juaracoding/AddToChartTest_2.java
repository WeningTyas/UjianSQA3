package com.juaracoding;

import com.juaracoding.model.AddToChart;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToChartTest_2 {

    AddToChart addChart = new AddToChart();

    @Test
    public void testWarna(){
        String actual =  "Beige";
        addChart.setWarna(actual);
        String expected = addChart.getWarna();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testUkuran(){
        String actual = "Medium";
        addChart.setUkuran(actual);
        String expected = addChart.getUkuran();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testJumlah(){
        int actual = 1;
        addChart.setJumlah(actual);
        int expected = addChart.getJumlah();
        Assert.assertEquals(actual,expected);
    }
}
