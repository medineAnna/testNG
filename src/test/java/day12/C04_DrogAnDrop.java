package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_DrogAnDrop extends TestBase {
    //Yeni bir class olusturalim: MouseActions2
    @Test
    public void test01() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);

        WebElement tasinacakElement=driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement tasinacakHedefElement=driver.findElement(By.xpath("//div[@id='simpleDropContainer']"));

        actions.dragAndDrop(tasinacakElement,tasinacakHedefElement).perform();
        Thread.sleep(7000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDroppedYazi=tasinacakHedefElement.getText();
        String expectedDroppedYazisi="Dropped";

        Assert.assertEquals(actualDroppedYazi,expectedDroppedYazisi);
    }
}
