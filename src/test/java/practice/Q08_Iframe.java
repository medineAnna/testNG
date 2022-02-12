package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q08_Iframe extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

// web sitesini maximize yapin
        driver.manage().window().maximize();

// ikinci emojiye tıklayın
        //driver.switchTo().frame("emoojis");
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

// tüm ikinci emoji öğelerini tıklayın
        WebElement secondemoojis= driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondemoojis.click();
        List<WebElement> emoojisOgeler=driver.findElements(By.xpath("//div[@id='nature']//div/img"));

        for (WebElement w:emoojisOgeler) {
            w.click();
        }
        System.out.println("Ogeler tiklandi");
        Thread.sleep(300);

// parent iframe e geri donun
        driver.switchTo().defaultContent();

// formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> metinGirList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>metinler=new ArrayList<>(Arrays.asList("Bir", "iframe","sorusu","bu","kadar","eglenceli",
                "olabilir","sizce de","oyle degil mi","",""));

        for (int i = 0; i < metinGirList.size(); i++) {
            metinGirList.get(i).sendKeys(metinler.get(i));
        }

//  apply button a basin
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
    }
}
