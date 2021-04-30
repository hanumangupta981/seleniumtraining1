package com.pages;

import com.wrapper.GenericWrappers;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IRCTCHotel extends GenericWrappers {

//    public IRCTCHotel(RemoteWebDriver driver){
//        this.driver = driver;
//    }

    public IRCTCHotel acceptBanner(){
        clickByXpath("//*[@id=\"modaladditionalPayment\"]/div/div/div[2]/button");
        return this;
    }

    public IRCTCHotel enterDestination(String dest){
        enterByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/searchbox/input",dest);
        return this;
    }
    public IRCTCHotel selectDestination(){
        clickByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[1]/searchbox/div/ul/li[1]/a");
        return this;

    }
    public IRCTCHotel clickFindHotel(){
        clickByXpath("//*[@id=\"TravellerEconomydropdown\"]/div[5]/button");
        return this;
    }
    public IRCTCHotel buttonBook(){
        clickByXpath("/html/body/app-root/app-fulllayout/div/app-hotellist/main/div/div[2]/div/div[2]/div/div/div[3]/button");
        return this;
    }
    public IRCTCHotel buttonContinueToBook(){
        clickByXpath("//*[@id=\"hotel-dtl-sticky-photo\"]/div[1]/div[1]/div[2]/div/div/div[4]/button");
        return this;
    }
}
