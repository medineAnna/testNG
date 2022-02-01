package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();

        Thread.sleep(5000);
        //4. Popup mesajini yazdirin
        String text=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(text);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        driver.switchTo().defaultContent();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.id("nav-title")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedURL="http://webdriveruniversity.com/index.html";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URL Test hatali");

    }
}
