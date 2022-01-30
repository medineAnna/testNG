package day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExist {
    @Test
    public void test01(){
         System.out.println(System.getProperty("user.home"));
         //masaustundeki deneme klasorunun Path'ni istesem
        //Users/medineannamammedova/Desktop/deneme/selenium
        //yani dinamik olarak masaustundeki deneme klasorunun path'ni yazmak istersem
        String path=System.getProperty("user.home")+"/Desktop/deneme/selenium";//concate ettim
        System.out.println(path);

        System.out.println("user.dir" + System.getProperty("user.dir"));

        //masaustu deneme klasoru icinde bir dosya oldugunu test edin
        //
        //1 once bu dosyaya ulasmak icin dinamik bir path olusturalim

        String dosyaYolu=System.getProperty("user.home")+"/Desktop/deneme/selenium";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        //projemizde pom.xml oldugunu test et
        ///Users/medineannamammedova/git/com.TestNG_Batch44/pom.xml
        System.out.println(System.getProperty("user.dir"));

        String pomPath=System.getProperty("user.dir") + "/pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));
    }
}
