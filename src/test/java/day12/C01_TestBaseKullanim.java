package day12;

import day10_.C01_Allerts;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestBaseKullanim {

    @Test
    public void test01(){
        //projeniz icerisindeki herhangi bir class'dan obje olusturabilir ve
        //o obje sayesinde ait oldugu class'daki tum varible ve method'lara
        //(access modifier izin verdigi surece) ulasabalirm

        C01_Allerts obj=new C01_Allerts();

        //eger proje kapsaminda bir class'dan obje olusturulmaisni engellemek isterseniz
        //1) class'in cons'ni private yapabilirz
        //2) class'in kendisini abstract yapabiliriz
        //2.methodu sik kullaniriz, boylece abstract olmayan(concrete) methodlari override etmek mecburiyeti olmadan kullanabilirz
        //ama obje olusturamayiz

        //ornegin biz TestBase class'ni abstract yaptigimmzdan obje olusturamayiz ama child class'dan TestBase'deki setUp ve TearDown metholari kullanabilirz

        TestBase obj1=new TestBase();
    }
}
