package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;

public class ExplicityWait extends TestBase {
    @Test
    public void isEnabled(){
        SoftAssert softAssert=new SoftAssert();
        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        softAssert.assertFalse(textBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(textBox)).isEnabled();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsEnableYazi=driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(itsEnableYazi.isEnabled());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın,
        softAssert.assertTrue(textBox.isEnabled());
        softAssert.assertAll();
    }
}
