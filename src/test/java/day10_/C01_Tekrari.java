package day10_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_Tekrari {
    WebDriver driver;
    WebElement sonucYazisiElementi;

    @BeforeClass
    public void setUp(){
        //● Bir class olusturun: Alerts
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        //● Bir metod olusturun: acceptAlert
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));

        String actualYaziResult=sonucYazisiElementi.getText();
        String exceptedYaziResult="You successfully clicked an alert";

        Assert.assertEquals(actualYaziResult,exceptedYaziResult);
    }
    @Test
    public void dismissAlert(){
        //● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().dismiss();
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));

        String actualResultYazi2=sonucYazisiElementi.getText();
        String expectedResultYazi2="successfuly";
    }
    @Test
    public void sendKeysAlert(){
        // ● Bir metod olusturun: sendKeysAlert
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
    }
