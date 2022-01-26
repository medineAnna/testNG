package day09_tests;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {
    /*● Bir class oluşturun: DependsOnTest
● https://www.amazon.com/ adresine gidin.
 1. Test : Amazon ana sayfaya gittiginizi test edin
 2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
 3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $16.83 oldugunu test edin */
WebDriver driver;
@BeforeClass
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

@Test(priority = 1)
    public void logoTest(){
    driver.get("https://www.amazon.com/");
    WebElement logoElement=driver.findElement(By.id("nav-logo-sprites"));

    Assert.assertTrue(logoElement.isDisplayed());
}

@Test(dependsOnMethods = "logoTest ")
    public void nutellaTest(){
    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

    String actualTitle=driver.getTitle();
    String arananKelime="Nutella";

    Assert.assertTrue(actualTitle.contains(arananKelime));
}

@Test
    public void fiyatTest(){
    driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
    WebElement urunFiyatElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]"));
    String urunFiyatiString=urunFiyatElementi.getText();
    String arananFiyat="$14.99";
    Assert.assertTrue(urunFiyatiString.contains(arananFiyat));
}

}
