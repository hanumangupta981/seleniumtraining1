package com.pages;

import com.wrapper.GenericWrappers;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IRCTCMainPage extends GenericWrappers {

//    public IRCTCMainPage(RemoteWebDriver driver){
//        this.driver = driver;
//    }

    public IRCTCMainPage callURL(String browserType, String URL){
        invokeApp(browserType,URL);
        return this;
    }

    public IRCTCMainPage acceptPopUp(){
        clickByXpath(objProp.getProperty("irctc.mainpage.acceptpopup"));
        return this;
    }
    public IRCTCHotel clickIRCTCHotels(){
        clickByXpath(objProp.getProperty("irctc.mainpage.clickirctcHotels"));
        switchToLastWindow();
        return new IRCTCHotel();

    }
    public IRCTCMainPage enterOrigin(String origin){
        enterByXpath(objProp.getProperty("irctc.mainpage.enterOrigin"), origin);
        return this;
    }
    public IRCTCSearchResults selectOrigin(){
        clickByXpath(objProp.getProperty("irctc.mainpage.selectOrigin"));
        return new IRCTCSearchResults();
    }

}
