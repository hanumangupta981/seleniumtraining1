package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ReportManager {

    public static File resultsDirectory;
    public static ExtentReports extentReports;
    public static ExtentTest test;

    public void initiateBaseReport(){

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd HH_mm"));
        resultsDirectory = new File(System.getProperty("user.dir")+"/testresults/"+timestamp);
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(resultsDirectory+"/"+"index.html"));
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

    }

    public void logStatus (String status, String message){
        if (status.equalsIgnoreCase("pass")){
            ReportManager.test.pass(message);
        } else if (status.equalsIgnoreCase("fail")){
            ReportManager.test.fail(message);
        } else if (status.equalsIgnoreCase("info")){
            ReportManager.test.info(message);
        }
    }

    public abstract String takeSnap();

    public void logStatus (String status, String message, boolean screenshot){

        String screenshotPath = takeSnap();
        if (screenshot){
            if (status.equalsIgnoreCase("pass")){
                ReportManager.test.pass(message);
            } else if (status.equalsIgnoreCase("fail")){
                ReportManager.test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else if (status.equalsIgnoreCase("info")){
                ReportManager.test.info(message);
            }
        }
    }



}
