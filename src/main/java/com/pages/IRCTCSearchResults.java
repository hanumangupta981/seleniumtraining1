package com.pages;

import com.wrapper.GenericWrappers;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IRCTCSearchResults extends GenericWrappers {

//    public IRCTCSearchResults(RemoteWebDriver driver){
//        this.driver = driver;
//    }

    public IRCTCViewDetail clickFirstBookNow(){
        clickByXpath("/html/body/app-root/tourpackagelist/div[2]/div/div[3]/div/div[2]/div/div[3]/div/a[2]");
        return new IRCTCViewDetail();
    }
}
