package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_KeyboardBaseActions extends TestBase {
    @Test
    public void test01(){
        //Yeni bir class olusturalim: D15_MouseActions4
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        //2- Yeni hesap olustur butonuna basalim
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //4- Kaydol tusuna basalim
    }
}
