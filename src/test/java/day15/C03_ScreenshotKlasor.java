package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenshotKlasor extends TestBase {
    @Test
    public void amazonSS() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        tumSayfaScreenshot();//method call
    }
    @Test
    public void test02() throws IOException {
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        tumSayfaScreenshot();
    }
    @Test
    public void test03() throws IOException {
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Elma" + Keys.ENTER);
        tumSayfaScreenshot();
    }
}
