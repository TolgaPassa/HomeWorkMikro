package com.mikro.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.awt.*;
import java.security.Key;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class mainpage {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           }



   /* @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }*/

    @Test
    public void Test1() throws InterruptedException {


        driver.get(ConfigurationReader.get("url"));
       //short
        Assert.assertEquals("n11.com - Hayat Sana Gelir",driver.getTitle());

         /*long
        String expectedURl=ConfigurationReader.get("url");
        String actualUrl = driver.getCurrentUrl();

        if(expectedURl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedURl = " + expectedURl);
        }
  */

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.className("btnSignIn")).click();

        Assert.assertEquals("Giriş Yap - n11.com",driver.getTitle());

        //normalde login izin verilmesi durumunda olucak sistem
        /*driver.findElement(By.id("email")).clear();
        driver.findElement(By.name("email")).sendKeys(username);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/div[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals("Giriş Yap - n11.com",driver.getTitle());


        //bildirim kapatma
        driver.findElement(By.xpath("//*[@id=\"dengage-push-perm-slide\"]/div/div[2]/div/button[2]")).click();
*/

        driver.findElement(By.xpath("//*[@id=\"loginContainer\"]/div/div[1]/div/div[3]")).click();

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }


        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(8000);

        driver.switchTo().window(currentWindowHandle);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]")).click();


        System.out.printf( driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]")).getText());

        driver.findElement(By.xpath("//*[@id=\"searchData\"]")).sendKeys("Iphone");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/div/a")).click();
        Thread.sleep(1000);
        Assert.assertEquals("Iphone - n11.com",driver.getTitle());
        System.out.printf(driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/section[2]/div[1]/div[3]")).getText());

        driver.findElement(By.xpath("//*[@id=\"searchData\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"searchData\"]")).sendKeys("Ayfon");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/div/a")).click();
        Thread.sleep(1000);
        Assert.assertEquals("Ayfon - n11.com",driver.getTitle());
        System.out.printf(driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/section[2]/div[1]/div[3]")).getText());

        driver.findElement(By.xpath("//*[@id=\"searchData\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"searchData\"]")).sendKeys("iphone");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/div/a")).click();
        Thread.sleep(1000);
        Assert.assertEquals("Iphone - n11.com",driver.getTitle());
        System.out.printf(driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/section[2]/div[1]/div[3]")).getText());











    }


}