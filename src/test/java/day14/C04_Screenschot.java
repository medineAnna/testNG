package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenschot extends TestBase {
    @Test
    public void test01() {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='I agree']")).click();

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File tumSayfaSS = new File("C: /src/tumSayfa.png");

        tumSayfaSS=takesScreenshot.getScreenshotAs(OutputType.FILE);

        WebElement logoElement=driver.findElement(By.xpath("//img[@id='hplogo']"));
        File logoResmi=new File("src/logo.ong");
    }
}
