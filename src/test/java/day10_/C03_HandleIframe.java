package day10_;

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

public class C03_HandleIframe {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement istenenYaziElement=driver.findElement(By.tagName("h3"));

        SoftAssert softassert=new SoftAssert();

        softassert.assertTrue(istenenYaziElement.isEnabled(),"Iframe yazisi gorunmutor");
        System.out.println(istenenYaziElement.getText());

        //○ Text Box’a “Merhaba Dunya!” yazin.
        //yazi yazmak istedigimiz tex kutusu iframe'in icinde oldugundan direk ulasamiyoruz
        //once iframe locate edip, onun icine switch yapmaliyiz
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement textBox= driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
        //ana sayfaya donmeliyiz
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //  yeni sayfada "Sponsored by Sauce Labs"    textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        // sponsored yazisi yeni sayfada oldugundan ve driver eski sayfada kaldigindan
        // yaziyi locate edemedik.....
        WebElement sponsoredYazisiElementi=driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
        softassert.assertTrue(sponsoredYazisiElementi.isDisplayed(),"Sponsored yazisi gorunmuyor");

        softassert.assertAll();
    }

    @AfterClass
    public void teardown(){
        //driver.close();
    }
}
