package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void dropdownTest01(){

        //dropdown'da var olan seceneklerden birini secmek icin
        //1.adim: Dropdown webelementini locate edip bir degiskene atiyoruz
        driver.get("//https:www.amazon.com/");
        WebElement dropdownElement=driver.findElement(By.xpath("//select[]@id='searchDropdownBox']"));

        //2.adim: select class'dan bir obje olusturalim
        //ve parametre olarak locate ettigimiz webelementi yazalim
        Select select=new Select(dropdownElement);

        //3.adim: select objesini kullanarak Select classindan var olan 3 secim methodundan
        //istedigimizi kullanarak dropdown'da var olan optiolardan birini secebiliriz
        //secim yapmamaiza yardim eden bu 3 method voiddir, dolayisiyla bize bir sey dondurmez
        select.selectByIndex(3);
        //System.out.println(select.selectByIndex(5));

        // eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText()); //Baby

        select.selectByVisibleText("Deals");

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        //tum dropdown elemanlari getirmek istersek
        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
        ) {
            System.out.println(each.getText());
        }

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
