package day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void cookiesTest(){
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> coockieSet=driver.manage().getCookies();
        System.out.println(coockieSet);
        int sayac=1;

        for (Cookie each: coockieSet) {
            System.out.println(sayac + ". cookie: " + each);
            sayac++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(coockieSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Cookie cookieI18n=driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cookie1e8n degeri: " + cookieI18n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myCookie=new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(myCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        sayac=1;
        Set<Cookie> coockieSet2=driver.manage().getCookies();
        for (Cookie each :coockieSet2) {
            System.out.println(sayac + ". cookie: " + each);
            sayac++;
        }

        Assert.assertTrue(coockieSet2.contains(myCookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        sayac=1;
        Set<Cookie> coockieSet3=driver.manage().getCookies();
        for (Cookie each :coockieSet3) {
            System.out.println(sayac + ". cookie: " + each);
            sayac++;
        }
        Assert.assertFalse(coockieSet3.contains(driver.manage().getCookieNamed("skin")));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> coockieSet4=driver.manage().getCookies();
        Assert.assertTrue(coockieSet4.size()==0);
    }
}
