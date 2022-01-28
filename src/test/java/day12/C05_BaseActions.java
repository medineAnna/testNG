package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_BaseActions extends TestBase {
    @Test
    public void test01(){
        //1- Bir Class olusturalim KeyboardActions1
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        WebElement aramaKutu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        Actions actions=new Actions(driver);
        actions.click(aramaKutu).
                keyDown(Keys.SHIFT).
                sendKeys("S").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("A").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).perform();

        //4- aramanin gerceklestigini test edin

    }
}
