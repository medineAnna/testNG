package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q07_SoftAllert extends TestBase {
   @Test
    public void alert01(){
       SoftAssert softAssert=new SoftAssert();
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
       driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

     // 2. CLICK ME of JavaScript Alert e tıklayın
       driver.findElement(By.id("button1")).click();

     // 3. pop up text i alın
       String message=driver.switchTo().alert().getText();

     // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
       String expMessage="I am an alert box!";
       softAssert.assertTrue(message.equals(expMessage));

     // 5. pop up i kabul edin
       driver.switchTo().alert().accept();
       softAssert.assertAll();
   }
   @Test(dependsOnMethods = "alert01")
    public void alert02() throws InterruptedException {
       SoftAssert softAssert=new SoftAssert();

       // Yine ayni class da baska test methodu olusturun
       // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
       driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
       Thread.sleep(2000);

       // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
       driver.findElement(By.xpath("(//p[text()='CLICK ME!'])[3]")).click();

       // 3.  pop up text i alın
       String message=driver.switchTo().alert().getText();

       // 4. Mesajın "Press a button!" olduğunu doğrulayın
       String expMssage="Press a button!";
       softAssert.assertTrue(message.equals(expMssage));

       // 5. Açılır pencereyi kapat
       driver.switchTo().alert().dismiss();

       // 6. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
       softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-alert-text']")).isDisplayed());//icinde locate ettik kontolude

       // 7. alert1'e göre dependsOnMethods kullanın
       softAssert.assertAll();
   }
}
