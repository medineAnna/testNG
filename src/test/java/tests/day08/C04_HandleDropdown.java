package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_HandleDropdown {
    //● Bir class oluşturun: C3_DropDownAmazon

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test1()  {
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropdownELement=driver.findElement(By.xpath("//select[@id='searchDropddownBox']"));
        Select select= new Select(dropdownELement);

        List<WebElement> optionList=select.getOptions();

        int actualOptionSati= optionList.size();
        int expectedOptioanSayi=45;

        Assert.assertEquals(actualOptionSati,expectedOptioanSayi);

    }
    @Test
    public void test2()  {
        //-Test 2

        //    1. Kategori menusunden Books secenegini  secin
        //    2. Arama kutusuna Java yazin ve aratin
        //    3. Bulunan sonuc sayisini yazdirin
        //    4. Sonucun Java kelimesini icerdigini test edin
    }
    @AfterMethod
    public void teardown(){
        //   driver.close();
    }
}

