package tests.day08;

import org.testng.annotations.Test;

public class C01_NG {

    @Test(priority = -9)
    public void youTubeTest01(){
        System.out.println("YouTube testi calisti");
    }

    @Test(priority = 8)
    public void amazonTest02(){
        System.out.println("Amazon testi calisti");
    }

    @Test(priority = 5)
    public void bestBuyTest03(){
        System.out.println("BestBuy testi calisti");
    }
}
