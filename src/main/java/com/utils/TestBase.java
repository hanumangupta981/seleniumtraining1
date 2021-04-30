package com.utils;

import com.wrapper.GenericWrappers;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestBase extends GenericWrappers {

    @BeforeSuite
    public void startReport (){
        initiateBaseReport();
    }

    @BeforeTest
    public void loadObjects (){
        objProp = new Properties();
        try {
            objProp.load(new FileInputStream("./src/main/resources/object.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @BeforeMethod
    public void launchURL (Method method){
        ReportManager.test = ReportManager.extentReports.createTest(method.getName());
        invokeApp("Chrome","https://www.irctctourism.com/");
    }

    @AfterMethod
    public void closeBrowser (){
        closeAllBrowsers();
    }

    @AfterSuite
    public void endReport (){
        ReportManager.extentReports.flush();
    }


}
