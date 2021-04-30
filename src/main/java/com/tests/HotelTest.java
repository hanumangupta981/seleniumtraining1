package com.tests;

import com.pages.IRCTCMainPage;
import com.utils.TestBase;
import com.utils.TestConfiguration;
import com.utils.TestDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HotelTest extends TestBase {

    /*@BeforeClass
    public void passData (){
        TestDataProvider.EXCEL_PATH = "./src/main/resources/DataProvider.xlsx";
        TestDataProvider.EXCEL_SHEET_NAME = "testcase01";
    }*/

//  @Test(dataProvider = "getData", dataProviderClass = TestDataProvider.class)
    @Test
    @TestConfiguration(excelPath = "./src/main/resources/DataProvider.xlsx", excelSheet = "testcase01")
    public void testcase01(HashMap<String,Object> tdMap) {
        new IRCTCMainPage().acceptPopUp().
                clickIRCTCHotels().acceptBanner().enterDestination(tdMap.get("Destination").toString()).selectDestination()
                .clickFindHotel().buttonBook().buttonContinueToBook();
    }

}
