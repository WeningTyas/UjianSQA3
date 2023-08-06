package com.juaracoding;

import com.juaracoding.model.AddToChart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToChartTest {
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
