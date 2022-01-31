package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    @Test
    public void implicitWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //   Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        Thread.sleep(7000);

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());

        Thread.sleep(7000);

    }

    @Test
    public void explicitWait() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //WebElement itsGoneElement=driver.findElement(By.xpath("//p[@id='message']"));
        //wait.until(ExpectedConditions.visibilityOf(itsGoneElement));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        WebElement itsGoneElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        Thread.sleep(7000);

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsBackElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());

    }
}
