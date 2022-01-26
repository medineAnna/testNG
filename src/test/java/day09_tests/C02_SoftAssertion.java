package day09_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {
    /*Yeni bir Class Olusturun : C03_SoftAssert
 1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
 "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
 "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
 "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)" */
    WebDriver driver;
    @BeforeClass
    public void setuo(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        WebElement loginKutusu=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");

        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        WebElement dropdown=driver.findElement(By.xpath("//select[@name='currency']"));
        Select select=new Select(dropdown);
        select.selectByValue("EUR");

        SoftAssert softAssert=new SoftAssert();
        String actualSecim=select.getFirstSelectedOption().getText();
        String expectedSecim="Eurozone (Euro)";
        softAssert.assertEquals(actualSecim,expectedSecim,"Dropdown dogru secilmedi");

        List<WebElement> optionList=select.getOptions();

        String actualOptionListeString="";

        for (WebElement each : optionList) {
            actualOptionListeString +="\"" + each.getText() + "\",";
        }

        softAssert.assertAll();
    }
}
