package com.utils;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestDP {

    @Test(dataProvider = "getData" , dataProviderClass = TestDataProvider.class)
    public void dataProviderTest (HashMap<String,Object> tdMap){
        System.out.println(tdMap);
    }
}
