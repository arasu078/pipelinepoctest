package sampletest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {

    private WebDriver driver;
    private GooglePage google;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities dc = DesiredCapabilities.chrome();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        System.out.println("Initialised the Deiver and sent the script to grid");
        
    }

    @Test
    public void sample() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("Opened the google application");
        driver.findElement(By.name("q")).sendKeys("Automation");
        System.out.println("Searching for work Automation");
        System.out.println("Asseted Successfull");
    }
    
     @Test
    public void sample1() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("Opened the google application");
        driver.findElement(By.name("q")).sendKeys("Automation");
        System.out.println("Searching for work Automation");
        System.out.println("Asseted Successfull");
    }
     @Test
    public void sample2() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("Opened the google application");
        driver.findElement(By.name("q")).sendKeys("Automation");
        System.out.println("Searching for work Automation");
        System.out.println("Asseted Successfull");
    }
     @Test
    public void sample3() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("Opened the google application");
        driver.findElement(By.name("q")).sendKeys("Automation");
        System.out.println("Searching for work Automation");
        System.out.println("Asseted Successfull");
    }
     @Test
    public void sample4() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("Opened the google application");
        driver.findElement(By.name("q")).sendKeys("Automation");
        System.out.println("Searching for work Automation");
        System.out.println("Asseted Successfull");
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }    

}
