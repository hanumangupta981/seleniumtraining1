package com.wrapper;

import com.utils.ReportManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GenericWrappers extends ReportManager implements Wrappers{
    public static RemoteWebDriver driver;
    public static Properties objProp;
    /**
     * This method will launch the given browser and maximise the browser and set the
     * wait for 30 seconds and load the url
     * @author Hanuman Gupta
     * @param browser - The browser of the application to be launched
     * @param url - The url with http or https
     * @throws Exception
     *
     */
    @Override
    public void invokeApp(String browser, String url) {
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\dev\\Tools\\chromedriver.exe");
            driver = new ChromeDriver();
         }
        else if (browser.equalsIgnoreCase("FireFox")){
            System.setProperty("webdriver.gecko.driver","C:\\dev\\Tools\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
    }
    /**
     * This method will enter the value to the text field using id attribute to locate
     *
     * @param idValue - id of the webelement
     * @param data - The data to be sent to the webelement
     * @author Hanuman Gupta
     * @return
     * @throws Exception
     */
    @Override
    public void enterById(String idValue, String data) {
        try {
            driver.findElementById(idValue).sendKeys(data);
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + idValue +" and data:" + data);
            //logStatus("fail","There is no such element with ID:" + idValue +" and data:" + data);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + idValue +" and data:" + data);
        }catch (ElementNotInteractableException e){
            logStatus("fail","Element with ID:" + idValue +" is not Interactable");
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + idValue +" is giving Stale Element Reference");
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will enter the value to the text field using name attribute to locate
     *
     * @param nameValue - name of the webelement
     * @param data - The data to be sent to the webelement
     * @author Hanuman Gupta
     */
    @Override
    public void enterByName(String nameValue, String data) {
        try {
            driver.findElementByName(nameValue).sendKeys(data);
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + nameValue +" and data:" + data);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + nameValue +" and data:" + data);
        }catch (ElementNotInteractableException e){
            logStatus("fail","Element with ID:" + nameValue +" is not Interactable");
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + nameValue +" is giving Stale Element Reference");
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will enter the value to the text field using xpath attribute to locate
     *
     * @param xpathValue - name of the webelement
     * @param data - The data to be sent to the webelement
     * @author Hanuman Gupta
     */
    @Override
    public void enterByXpath(String xpathValue, String data) {
        try {
            driver.findElementByXPath(xpathValue).sendKeys(data);
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + xpathValue +" and data:" + data);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + xpathValue +" and data:" + data);
        }catch (ElementNotInteractableException e){
            logStatus("fail","Element with ID:" + xpathValue +" is not Interactable");
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + xpathValue +" is giving Stale Element Reference");
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will verify the title of the browser
     * @param title - The expected title of the browser
     * @author Hanuman Gupta
     */
    @Override
    public void verifyTitle(String title) {
        try {
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(title)) {
                logStatus("fail","Titles match");
            } else {
                logStatus("fail","Titles NOT match");
            }
        }catch(NoSuchWindowException e){
            logStatus("fail","No such Window with title:" + title);
        }catch(Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will verify the given text
     * @param id - The locator of the object in id
     * @param text  - The text to be verified
     * @author Hanuman Gupta
     */
    @Override
    public void verifyTextById(String id, String text) {
        try {
            String actualText = driver.findElementById(id).getText();
            if (actualText.equals(text)) {
                logStatus("fail","text match");
            } else {
                logStatus("fail","text NOT match");
            }
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + id +" and data:" + text);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + id +" and data:" + text);
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + id +" is giving Stale Element Reference");
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will verify the given text with exact match
     * @param xpath - The locator of the object in id
     * @param text  - The text to be verified
     * @author Hanuman Gupta
     */
    @Override
    public void verifyTextByXpath(String xpath, String text) {
        try {
            String actualText = driver.findElementByXPath(xpath).getText();
            if (actualText.equals(text)) {
                logStatus("fail","text match");
            } else {
                logStatus("fail","text NOT match");
            }
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + xpath +" and data:" + text);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + xpath +" and data:" + text);
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + xpath +" is giving Stale Element Reference");
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will verify the given text with partial match
     * @param xpath - The locator of the object in xpath
     * @param text  - The text to be verified
     * @author Hanuman Gupta
     */
    @Override
    public void verifyTextContainsByXpath(String xpath, String text) {
        try {
            String actualText = driver.findElementByXPath(xpath).getText();
            if (actualText.contains (text)) {
                logStatus("fail","text match");
            } else {
                logStatus("fail","text NOT match");
            }
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + xpath +" and data:" + text);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + xpath +" and data:" + text);
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + xpath +" is giving Stale Element Reference");
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will click the element using id as locator
     * @param id  The id (locator) of the element to be clicked
     * @author Hanuman Gupta
     */
    @Override
    public void clickById(String id) {
        try {
            driver.findElementById(id).click();
            logStatus("pass","Able to click the element with the ID: "+id);
        }catch (NoSuchElementException e){
            logStatus("fail","There is no such element with ID:" + id);
        }catch (ElementNotVisibleException e){
            logStatus("fail","Element not visible with ID:" + id);
        }catch (ElementNotInteractableException e){
            logStatus("fail","Element with ID:" + id);
        }catch(StaleElementReferenceException e){
            logStatus("fail","Element with ID:" + id);
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will click the element using ClassName as locator
     * @param classVal  The class (locator) of the element to be clicked
     * @author Hanuman Gupta
     * @throws Exception
     */
    @Override
    public void clickByClassName(String classVal) {
        try {
            driver.findElementByClassName(classVal).click();
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + classVal);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + classVal);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + classVal);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + classVal);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will click the element using name as locator
     * @param name  The name (locator) of the element to be clicked
     * @author Hanuman Gupta
     */
    @Override
    public void clickByName(String name) {
        try {
            driver.findElementByName(name).click();
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + name);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + name);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + name);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + name);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will click the element using link name as locator and do take snap
     * @param name  The link name (locator) of the element to be clicked
     * @author Hanuman Gupta
     */
    @Override
    public void clickByLink(String name) {
        try {
            driver.findElementByLinkText(name).click();
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + name);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + name);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + name);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + name);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
    }

    /**
     * This method will click the element using xpath as locator
     * @param xpathVal  The xpath (locator) of the element to be clicked
     * @author Hanuman Gupta
     */
    @Override
    public void clickByXpath(String xpathVal) {
        try {
            driver.findElementByXPath(xpathVal).click();
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + xpathVal, true);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + xpathVal, true);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + xpathVal, true);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + xpathVal, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will get the text of the element using id as locator
     * @param xpathVal  The id (locator) of the element
     * @author Hanuman Gupta
     */
    @Override
    public String getTextById(String xpathVal) {
        try {
            String actualText = driver.findElementById(xpathVal).getText();
            return actualText;
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + xpathVal);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + xpathVal);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + xpathVal);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + xpathVal);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
        return null;
    }
    /**
     * This method will get the text of the element using xpath as locator
     * @param xpathVal  The xpath (locator) of the element
     * @author Hanuman Gupta
     */
    @Override
    public String getTextByXpath(String xpathVal) {
        try {
            String actualText = driver.findElementByXPath(xpathVal).getText();
            return actualText;
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + xpathVal);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + xpathVal);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + xpathVal);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + xpathVal);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
        return null;
     }
    /**
     * This method will select the drop down visible text using id as locator
     * @param id The id (locator) of the drop down element
     * @param value The value to be selected (visibletext) from the dropdown
     * @author Hanuman Gupta
     */
    @Override
    public void selectVisibileTextById(String id, String value) {
        try {
            WebElement element = driver.findElementById(id);
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + id);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + id);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + id);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + id);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will select the drop down using index as id locator
     * @param id The id (locator) of the drop down element
     * @param value The value to be selected (visibletext) from the dropdown
     * @author Hanuman Gupta
     */
    @Override
    public void selectIndexById(String id, int value) {
        try {
            WebElement element = driver.findElementById(id);
            Select dropdown = new Select(element);
            dropdown.selectByIndex(value);
        } catch (NoSuchElementException e) {
            logStatus("fail","There is no such element with ID:" + id);
        } catch (ElementNotVisibleException e) {
            logStatus("fail","Element not visible with ID:" + id);
        } catch (ElementNotInteractableException e) {
            logStatus("fail","Element with ID:" + id);
        } catch (StaleElementReferenceException e) {
            logStatus("fail","Element with ID:" + id);
        } catch (Exception e) {
            logStatus("fail",e.getMessage());
        }
    }
    /**
     * This method will switch to the parent Window
     * @author Hanuman Gupta
     */
    @Override
    public void switchToParentWindow() {
        Set <String> windowNames = driver.getWindowHandles();
//        List<String> windowList = new ArrayList<>(windowNames);
//        driver.switchTo().window(windowList.get(0));
        for (String str:windowNames ){
            driver.switchTo().window(str);
            break;
        }

    }

    @Override
    public void switchToLastWindow() {
        Set <String> windowNames = driver.getWindowHandles();
//        List<String> windowList = new ArrayList<>(windowNames);
//        driver.switchTo().window(windowList.get(0));
        for (String str:windowNames ){
            driver.switchTo().window(str);
        }
    }
    /**
     * This method will accept the alert opened
     * @author Hanuman Gupta
     */
    @Override
    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e){
            logStatus("fail","Alert not found "+ e);
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
    }

    @Override
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e){
            logStatus("fail","Alert not found "+ e);
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }

    }

    @Override
    public String getAlertText() {
        try {
            String alertText = driver.switchTo().alert().getText();
            return alertText;
        } catch (NoAlertPresentException e){
            logStatus("fail","Alert not found "+ e);
        }catch (Exception e){
            logStatus("fail",e.getMessage());
        }
        return null;
    }

    @Override
    public String takeSnap() {
        File source = driver.getScreenshotAs(OutputType.FILE);
        long snapshot = (long) (Math.random()*10000000+10000001);
        File dest = new File("./screenshot/"+snapshot+".png");
        try {
            FileUtils.copyFile(source,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest.getAbsolutePath();
    }

    @Override
    public void closeBrowser() {
        driver.close();
    }

    @Override
    public void closeAllBrowsers() {
        driver.quit();

    }
}
