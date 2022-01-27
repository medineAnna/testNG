package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_HandleWindows {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void windowHandleTest(){
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement sayfadakiYaziElement=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfadakiYaziElement.getText(),"Opening a new window", "sayfadaki yazi");

        softAssert.assertEquals(driver.getTitle(),"The Internet","sayfa title'i beklenenden farkli");

        String windowHandleDeger=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> handleDegerlerSet=driver.getWindowHandles();//tum window handlde degerleri alip sete koyacak
        String windowHandleDegerler2="";

        for (String each : handleDegerlerSet) {
            if(!each.equals(windowHandleDeger)){
                windowHandleDegerler2=each;
            }
        }
        driver.switchTo().window(windowHandleDegerler2);
        softAssert.assertEquals(driver.getTitle(),"New Window", "yeni sayfa title istenenden farkli");

        softAssert.assertAll();

        WebElement ikincisayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikincisayfadakiYaziElementi.getText(), "New Window","2.sayfadaki istenen deger farkli");

        driver.switchTo().window(windowHandleDeger);

        softAssert.assertEquals(driver.getTitle(),"The Internet", "ilk sayfanin title beklenen gibi degil");
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
