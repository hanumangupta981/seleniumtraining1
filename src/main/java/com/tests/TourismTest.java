package com.tests;

import com.pages.IRCTCMainPage;
import com.utils.TestBase;
import com.utils.TestConfiguration;
import com.utils.TestDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TourismTest extends TestBase {

    /*@BeforeClass
    public void passData (){
        TestDataProvider.EXCEL_PATH = "./src/main/resources/DataProvider.xlsx";
        TestDataProvider.EXCEL_SHEET_NAME = "testcase02";
    }*/

    @Test
    @TestConfiguration(excelPath = "./src/main/resources/DataProvider.xlsx", excelSheet = "testcase02")
    public void testcase02(HashMap<String,Object> tdMap){
        new IRCTCMainPage()
                .acceptPopUp()
                .enterOrigin(tdMap.get("Origin").toString())
                .selectOrigin()
                .clickFirstBookNow()
                .clickViewDetail();
    }
}
