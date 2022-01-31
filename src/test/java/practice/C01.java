package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {
    Select select;
    WebElement dropDownElement;
    WebElement searchBox;

    @BeforeMethod
    public void atamaAmazon(){
        driver.get("https://www.amazon.com");
        WebElement dropDownElement=driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropDownElement);
        searchBox=driver.findElement(By.id("nav-search-submit-button"));
    }
    @Test
    public void test01(){
        List<WebElement> dropDownListesi=select.getOptions();
        dropDownListesi.stream().forEach(t-> System.out.println(t.getText()));
        Assert.assertTrue(dropDownListesi.size()==40);
    }

    @Test
    public void test02(){
        //dorpdown menusunden elektronik bolumunu secin
        select.selectByValue("search-alias=electronics-intl-ship");

        //arama kutusunda iphone yazip arattirin bulunan sonuc sayisini yazdirin
        searchBox.sendKeys("iphone" + Keys.ENTER);
        String sonucYaziStr=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String arr[]=sonucYaziStr.split(" ");
        System.out.println(2);

        // sonuc yazisi nin iphone icerdigini test edin
        Assert.assertTrue(sonucYaziStr.contains("iphone"));

        //ikinci urune Relativ locator kullanarak locate edin
        WebElement birinciUrun=driver.findElement(By.xpath("//img[@data-image-index=\"1\"]"));
        WebElement ucuncuUrun=driver.findElement(By.xpath("//img[@data-image-index=\"3\"]"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.className("s-image")).below(birinciUrun).above(ucuncuUrun));
        ikinciUrun.click();

        //urunbun title ve fiyatini assign edip sepete ekleyelim
        String urun1Title=driver.getTitle();
        String urun1Fiyat=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[2]")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Test
    public void test03(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        WebElement dropDownElement=driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropDownElement);
        select.selectByValue("search-alias=baby-products-intl-ship");
        searchBox=driver.findElement(By.id("nav-search-submit-button"));
        searchBox.sendKeys("Stroller" + Keys.ENTER);
    }
}
