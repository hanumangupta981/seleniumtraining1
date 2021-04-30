package com.pages;

import com.wrapper.GenericWrappers;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IRCTCViewDetail extends GenericWrappers {

//    public IRCTCViewDetail(RemoteWebDriver driver){
//        this.driver = driver;
//    }

    public IRCTCViewDetail clickViewDetail() {
        clickByXpath("/html/body/app-root/tourpackagebooking/div/div[1]/div/div[3]/div/div/a");
        return this;
    }
}
